package com.rachit.bookstore.service.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sku {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private BookType format;
	private Double discount;
	private int availableQuantity;
	
	public Sku() {
	}
	
	public Sku(BookType format, Double discount, int quantity) {
		this.format = format;
		this.discount = discount;
		this.availableQuantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookType getFormat() {
		return format;
	}

	public void setFormat(BookType format) {
		this.format = format;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
