package com.srinivas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

    private long custId;
    private String name;
    private int age;
    
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="address", joinColumns = {@JoinColumn(name = "cust_Id", referencedColumnName = "cust_id") }, inverseJoinColumns = { @JoinColumn(name = "id", referencedColumnName = "id") })
    private Address address;

    public Customer(){
    }
  
    public Customer(long custId, String name, int age, Address address) {
        this.custId = custId;
        this.name = name;
        this.age = age;
        this.address = address;
    }
  
    public long getCustId() {
        return custId;
    }
    public void setCustId(long custId) {
        this.custId = custId;
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
        return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
        + "]";
    }
}
