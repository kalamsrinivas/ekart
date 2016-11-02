package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.Customer;


public interface CustomerDao {
	void insert(Customer cus);
	public List<Customer> getCustomers();
}
