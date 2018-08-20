package com.product.info.test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.product.info.application.Application;
import com.product.info.application.controller.ProductController;
import com.product.info.application.model.Event;
import com.product.info.application.model.Product;
import com.product.info.application.repository.EventRepository;
import com.product.info.application.repository.ProductRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductControllerTests {
	 MockMvc mockMvc;
	  @Autowired
	    private WebApplicationContext webApplicationContext;
	 @Autowired
	    private ProductController restTemplate;
	 private HttpMessageConverter mappingJackson2HttpMessageConverter;
	 private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
	            MediaType.APPLICATION_JSON.getSubtype(),
	            Charset.forName("utf8"));
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

	
	 @Before
	    public void setup() throws Exception {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	 }
	 @Autowired
	    void setConverters(HttpMessageConverter<?>[] converters) {

	        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
	            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
	            .findAny()
	            .orElse(null);

	        assertNotNull("the JSON message converter must not be null",
	                this.mappingJackson2HttpMessageConverter);
	    }
	   protected String json(Object o) throws IOException {
	        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
	        this.mappingJackson2HttpMessageConverter.write(
	                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
	        return mockHttpOutputMessage.getBodyAsString();
	    }
	   
	   @Test
	    public void getProductByEvent() throws Exception {
	        mockMvc.perform(get("/getProductsForEvent"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(contentType))
	        		.andExpect(jsonPath("$.evename", is("Independent Day Promo")));	               
	    }
}
