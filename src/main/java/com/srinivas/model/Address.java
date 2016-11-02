package com.srinivas.model;

public class Address {
	private int id;
	private String street;
	private int zip;

	public Address() {}

	public Address(int id, String street, int zip) {
		super();
		this.id = id;
		this.street = street;
		this.zip = zip;
	}
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
}
