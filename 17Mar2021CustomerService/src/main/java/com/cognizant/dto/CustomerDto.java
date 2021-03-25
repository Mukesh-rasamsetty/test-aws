package com.cognizant.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.commons.Customer;

@Repository
public interface CustomerDto extends JpaRepository<Customer, String> {

}
