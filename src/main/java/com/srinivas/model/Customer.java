package com.srinivas.model;

public class Customer {

    private long cust_id;
    private String name;
    private int age;
    private Address address;

    public Customer(){
    }
  
    public Customer(long custId, String name, int age, Address address) {
        this.cust_id = custId;
        this.name = name;
        this.age = age;
        this.address = address;
    }
  
    public long getCustId() {
        return cust_id;
    }
    public void setCustId(long custId) {
        this.cust_id = custId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
 
    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return "Customer [age=" + age + ", custId=" + cust_id + ", name=" + name
        + "]";
    }
}
