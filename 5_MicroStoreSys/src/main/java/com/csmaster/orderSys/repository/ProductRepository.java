package com.csmaster.orderSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csmaster.orderSys.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
