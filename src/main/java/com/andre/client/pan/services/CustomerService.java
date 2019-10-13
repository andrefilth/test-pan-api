package com.andre.client.pan.services;

import com.andre.client.pan.model.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {

	Mono<Customer> findByCpf(String cpf);
}
