package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.Product;
import com.cognizant.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepo repo;
	
    @GetMapping
    public List<Product> listProducts(){
    	return repo.findAll();
    }

    @GetMapping("/{id}")
    private Product getProductById(@PathVariable String id){
    	Optional<Product> pro = repo.findById(id);
    	if(pro.isPresent())
    		return pro.get();
    	return null;
    }

    @PostMapping
    private Product setProduct(@RequestBody Product product){
    	return repo.save(product);
    }

    @GetMapping("/customer/{custId}")
    public List<Product> listProductsByCustomerId(@PathVariable String custId){
    	List<Product> pro = repo.findAll();
    	List<Product> result = new ArrayList<>();
    	for(Product temp : pro) {
    		if(temp.getCustomerId().equals(custId))
    			result.add(temp);
    	}
    	return result;
    }
}
