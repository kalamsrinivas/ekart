package com.srinivas.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.srinivas.dao.CustomerDao;
import com.srinivas.model.Address;
import com.srinivas.model.Customer;

@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{

	@Autowired
    DataSource dataSource;
  
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

	@Override
	public void insert(Customer customer) {
	    String customerSql = "INSERT INTO customer " +
	    		"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)" ;
	    getJdbcTemplate().update(customerSql, new Object[]{
	    		customer.getCust_id(), customer.getName(), customer.getAge()
	    });
	    
	    final Address address = customer.getAddress();
	    String addressSql = "INSERT INTO address " +
	    		"(ID, STREET, ZIP) VALUES (?, ?, ?)" ;
	    getJdbcTemplate().update(addressSql, new Object[]{
	    		address.getId(), address.getStreet(), address.getZip()
	    });
	}

	@Override
	public List<Customer> getCustomers() {
		String getCustomerSql = "SELECT * from customer c, address a where c.cust_id = a.id";
		return (List<Customer>) getJdbcTemplate().query(getCustomerSql, new CustomerMapper());
	}

	private static final class CustomerMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Customer customer = new Customer();
			Address address = new Address();
			customer.setCust_id(resultSet.getInt("CUST_ID"));;
			customer.setAge(resultSet.getInt("AGE"));
			customer.setName(resultSet.getString("NAME"));
			address.setId(resultSet.getInt("ID"));
			address.setStreet(resultSet.getString("STREET"));
			address.setZip(resultSet.getInt("ZIP"));
			customer.setAddress(address);
			return customer;
		}
	}

	@Override
	public void update(int cust_id, Customer customer) {
		Customer cus = getCustomer(cust_id);
		if (cus == null) {
			throw new ValidationException("there is no customer with customer id: " + cust_id);
		}
		if (customer == null) {
			throw new ValidationException("customer object is null");
		}

 	    String customerSql = "UPDATE customer set name = ?, age = ? where cust_id = ?";
	    getJdbcTemplate().update(customerSql, new Object[]{
	    		customer.getName(), customer.getAge(), cust_id
	    });
	    
	    final Address address = customer.getAddress();
	    if (address != null) {	    
	    	String addressSql = "UPDATE address set street = ?, zip = ? where id = ?";
	    	getJdbcTemplate().update(addressSql, new Object[]{
	    		address.getStreet(), address.getZip(), address.getId()
	    	});
	    }
	}

	@Override
	public Customer getCustomer(int cust_id) {
		String customerSql = "SELECT * FROM customer c, address a where c.cust_id = ? and c.cust_id = a.id";
		return (Customer) getJdbcTemplate().queryForObject(customerSql, new Object[]{cust_id}, new CustomerMapper());
	}
}
