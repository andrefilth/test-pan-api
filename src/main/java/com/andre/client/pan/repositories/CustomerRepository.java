package com.andre.client.pan.repositories;

import com.andre.client.pan.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CustomerRepository extends CrudRepository<Customer,Long> {


    Optional<Customer> findByDocument(String document);
}
