package com.andre.client.pan.endpoint;

import com.andre.client.pan.constants.Constants;
import com.andre.client.pan.exception.ClientException;
import com.andre.client.pan.services.CustomerService;
import com.andre.client.pan.endpoint.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constants.CONTEXT_PATH)
public class CustomerEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerEndpoint.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/customer/{cpf}")
    public Mono<CustomerResponse> findCustomer(@PathVariable("cpf") String cpf) {

        LOG.info("Buscar informações de Customer por CPF: [{}] ", cpf);

        return customerService.findByCpf(cpf)
                .switchIfEmpty(Mono.error(new ClientException(404, "customer_validation",	"Informações não encontradas com o Customer " + cpf)))
                .map(CustomerResponse::new)
                .doOnSuccess(t -> LOG.info("Encontrado custumer [{}]", t));



    }

}