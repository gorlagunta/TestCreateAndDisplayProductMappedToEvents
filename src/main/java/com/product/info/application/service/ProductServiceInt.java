package com.product.info.application.service;

import java.util.List;

import com.product.info.application.model.Event;

public interface ProductServiceInt {
	public String saveEvents(Event event);
	public Iterable<Event> getAllEvents();
	public Event getEvent(String eventName);
}
