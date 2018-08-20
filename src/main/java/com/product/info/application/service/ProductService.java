package com.product.info.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.info.application.controller.ProductController;
import com.product.info.application.model.Event;
import com.product.info.application.model.Product;
import com.product.info.application.repository.EventRepository;
import com.product.info.application.repository.ProductRepository;

@Component
public class ProductService implements ProductServiceInt {
	@Autowired
	EventRepository eventRepository;
	@Autowired
	ProductRepository productRepository;
	private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

	public String saveEvents(Event event) {
		LOGGER.info("-------------*****inside service saveEvents**********-------------" + event.getEvename());
		try {
			eventRepository.save(event);
			for (Product entity : event.getProductLst()) {
				Product productEntity = new Product(entity.getProd_name(), entity.getQuantity(),
						entity.getTotalSaleAmount(), event);
				productRepository.save(productEntity);
			}
			return "Records has been inserted to MYSQL DB successfull";
		} catch (Exception exception) {
			throw exception;
		}
	}

	public Iterable<Event> getAllEvents() {
		LOGGER.info("-------------*****inside service getAllEvents**********-------------");
		try {
			return eventRepository.findAll();
			
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	public Event getEvent(String eventName) {
		LOGGER.info("-------------*****inside service getAllEvents**********-------------");
		try {
			return eventRepository.findByEvename(eventName);
			
		} catch (Exception exception) {
			throw exception;
		}
	}
}
