package com.product.info.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)	
	private long prod_id;
	private String prod_name;
	private int quantity;
	private double totalSaleAmount;	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="evename")
	private Event event;
	public Product() {
		
	}		
	public Product(String prod_name, int quantity, double totalSaleAmount) {
		super();
		this.prod_name = prod_name;
		this.quantity = quantity;
		this.totalSaleAmount = totalSaleAmount;		
	}
	public Product(String prod_name, int quantity, double totalSaleAmount, Event event) {
		super();
		this.prod_name = prod_name;
		this.quantity = quantity;
		this.totalSaleAmount = totalSaleAmount;
		this.event = event;
	}
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
}
