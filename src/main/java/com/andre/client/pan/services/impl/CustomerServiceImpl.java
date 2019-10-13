package com.andre.client.pan.services.impl;


import com.andre.client.pan.model.Customer;
import com.andre.client.pan.repositories.CustomerRepository;
import com.andre.client.pan.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

import static com.andre.client.pan.model.util.MapperUtil.*;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);


	private final CustomerRepository repository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<Customer> findByCpf(String cpf) {
		return  getByDocument(cpf)
					.doOnSuccess(client -> LOG.info("Dados encontrados no banco para o idCustomer [ {} ]" , client.getId()));
	}

	private Mono<Customer> getByDocument(String cpf) {
		return Mono.justOrEmpty(repository.findByDocument(cpf));
	}

	@PostConstruct
	public void Init() {
		Customer andre = new Customer();
		andre.setId(1l);
		andre.setName("André Franco");
		andre.setDocument("12345678900");
		andre.setCreatedAt(toZonedDateTime(LocalDateTime.now()));
		andre.setUpdatedAt(toZonedDateTime(LocalDateTime.now()));
		repository.save(andre);

		Customer laura = new Customer();
		laura.setId(2l);
		laura.setName("Laura Reis");
		laura.setDocument("11122233300");
		laura.setCreatedAt(toZonedDateTime(LocalDateTime.now()));
		laura.setUpdatedAt(toZonedDateTime(LocalDateTime.now()));
		repository.save(laura);

		Customer fernando = new Customer();
		fernando.setId(3l);
		fernando.setName("Fernando Cardoso");
		fernando.setDocument("44455566600");
		fernando.setCreatedAt(toZonedDateTime(LocalDateTime.now()));
		fernando.setUpdatedAt(toZonedDateTime(LocalDateTime.now()));
		repository.save(fernando);
	}
}
