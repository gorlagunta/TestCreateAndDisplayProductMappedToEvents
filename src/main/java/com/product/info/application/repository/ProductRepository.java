package com.product.info.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.product.info.application.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
