package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.Customer;


public interface CustomerDao {
	public void insert(Customer cus);
	public List<Customer> getCustomers();
}
