package com.product.info.application.bean;

import java.util.Date;
import java.util.List;
import com.product.info.application.model.Product;

public class EventBean {
	private String evename;	
	private Date date; 
    private List<Product> productLst ;
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
