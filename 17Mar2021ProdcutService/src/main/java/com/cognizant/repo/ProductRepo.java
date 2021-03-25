package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.models.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

}
