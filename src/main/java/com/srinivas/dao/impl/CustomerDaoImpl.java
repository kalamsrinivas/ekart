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
		String sql = "SELECT * from customer";
		return (List<Customer>) getJdbcTemplate().query(sql, new CustomerMapper());
	}

	private static final class CustomerMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustId(resultSet.getInt("CUST_ID"));
			customer.setAge(resultSet.getInt("AGE"));
			customer.setName(resultSet.getString("NAME"));
			return customer;
		}
	}
}
