package com.srinivas.model;

import javax.persistence.*;

@Entity
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
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
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

    @ManyToOne
    @JoinColumn(name = "address_id")
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
