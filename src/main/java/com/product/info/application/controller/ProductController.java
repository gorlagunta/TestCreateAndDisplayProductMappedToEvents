package com.product.info.application.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.info.application.bean.EventBean;
import com.product.info.application.model.Event;
import com.product.info.application.model.Product;
import com.product.info.application.service.ProductService;
import com.product.info.application.service.ProductServiceInt;

@RestController
public class ProductController {
	@Autowired
	ProductServiceInt service;
	private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());
	
	@RequestMapping(value ="/getProductsForEvent",method=RequestMethod.GET)
	public Event getProductsMapToEvent(@RequestParam(value="name", defaultValue="Independent Day Promo") String name) {		
		LOGGER.info("-------------*****before callingservice getAllEvents**********-------------");
		return service.getEvent(name);
	}
	@RequestMapping(value ="/getProductsForEvents",method=RequestMethod.GET)
	public Iterable<Event> getProducts() {		
		LOGGER.info("-------------*****before callingservice getAllEvents**********-------------");
		return service.getAllEvents();
	}
	
	@RequestMapping(value ="/insertProductsForEvent",method = RequestMethod.POST,headers="Accept=application/json")
	public String insertProductsForEvent(@RequestBody Event event ) {
		LOGGER.info("-------------*****inside insertProductsForEvent**********-------------"+event.getDate());
		
		return service.saveEvents(event);
	}
}
