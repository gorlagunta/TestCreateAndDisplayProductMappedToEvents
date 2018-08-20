package com.product.info.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.info.application.model.Product;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue	
	@JsonIgnore
	Long id;
	@Column(unique=true)
	private String evename;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;	
    @OneToMany(mappedBy = "event")
    private List<Product> productLst ;
    public Event() {
    	
    }
    public Event(String evename, Date date) {
		super();
		this.evename = evename;
		this.date = date;		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEvename() {
		return evename;
	}
	public void setEvename(String evename) {
		this.evename = evename;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Product> getProductLst() {
		return productLst;
	}
	public void setProductLst(List<Product> productLst) {
		this.productLst = productLst;
	}
	
}
