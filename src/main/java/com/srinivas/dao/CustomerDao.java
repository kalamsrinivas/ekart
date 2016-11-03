package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.Customer;


public interface CustomerDao {
	public void insert(Customer customer);
	public List<Customer> getCustomers();
	public void update(int cust_id, Customer customer);
	public Customer getCustomer(int cust_id);
}
