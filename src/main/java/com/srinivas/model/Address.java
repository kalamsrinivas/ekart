package com.srinivas.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
	private int id;
	private String street;
	private int zip;
	private Set<Customer> customers;

	public Address() {}

	public Address(String street, int zip) {
		super();
		this.street = street;
		this.zip = zip;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	
}
