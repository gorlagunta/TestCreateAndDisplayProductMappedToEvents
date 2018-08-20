package com.product.info.application;

import java.util.Arrays;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.product.info.application.model.Event;
import com.product.info.application.model.Product;
import com.product.info.application.repository.EventRepository;
import com.product.info.application.repository.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(EventRepository eventRepository,
						   ProductRepository productRepository) {
		return args ->
			Arrays.asList("Independent Day Promo")
				.forEach(eventname -> {
					Event event = eventRepository.save(new Event(eventname, new Date()));
					productRepository.save(new Product("Apple", 2, 359, event));
					productRepository.save(new Product("Samsung", 3, 450, event));
				});
	}

}
