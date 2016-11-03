package com.srinivas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srinivas.dao.CustomerDao;
import com.srinivas.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;

	@RequestMapping(value = "/customers/{cust_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@PathVariable("cust_id") int cust_id) {
		return (Customer) customerDao.getCustomer(cust_id);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public void insertCustomer(@RequestBody Customer customer) {
		customerDao.insert(customer);
	}

	@RequestMapping(value = "/customers/{cust_id}", method = RequestMethod.POST)
	public void updateCustomer(@PathVariable("cust_id") int cust_id, @RequestBody Customer customer) {
		customerDao.update(cust_id, customer);
	}
}
