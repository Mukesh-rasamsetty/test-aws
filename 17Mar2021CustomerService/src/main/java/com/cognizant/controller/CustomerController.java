package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.commons.Customer;
import com.cognizant.commons.Product;
import com.cognizant.dto.CustomerDto;
import com.cognizant.feign.client.ProductClient;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private ProductClient productClient;
    
    @Autowired
    private CustomerDto dto;

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable String id){
    	Optional<Customer> customer = dto.findById(id);
    	List<Product> listProductsByCustomerId = productClient.listProductsByCustomerId(id);
    	if(customer.isPresent())
    		return customer+"\n"+listProductsByCustomerId;
        return null;
    }
    
    @GetMapping("/")
    public List<Customer> getCustomers() {
    	return dto.findAll();
    }

}
