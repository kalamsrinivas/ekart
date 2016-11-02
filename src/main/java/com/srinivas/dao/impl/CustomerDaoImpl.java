package com.srinivas.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

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
	public void insert(Customer cus) {
	    String sql = "INSERT INTO customer " +
	    		"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)" ;
	    getJdbcTemplate().update(sql, new Object[]{
	    		cus.getCustId(), cus.getName(), cus.getAge()
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
			customer.setCustId(resultSet.getInt("CUST_ID"));
			customer.setAge(resultSet.getInt("AGE"));
			customer.setName(resultSet.getString("NAME"));
			address.setId(resultSet.getInt("ID"));
			address.setStreet(resultSet.getString("STREET"));
			address.setZip(resultSet.getInt("ZIP"));
			customer.setAddress(address);
			return customer;
		}
	}
}
