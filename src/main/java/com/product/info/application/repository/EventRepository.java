package com.product.info.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product.info.application.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
	Event findByEvename(String eventName);
}
