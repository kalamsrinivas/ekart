package com.srinivas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srinivas.dao.CustomerDao;
import com.srinivas.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;

	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
}
