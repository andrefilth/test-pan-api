package com.andre.client.pan.endpoint;

import com.andre.client.pan.endpoint.response.AddressResponse;
import com.andre.client.pan.exception.ClientException;
import com.andre.client.pan.services.AddressService;
import com.andre.client.pan.ws.response.AddressWSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.andre.client.pan.constants.Constants.CONTEXT_PATH;

@RestController
@RequestMapping(CONTEXT_PATH)
public class AddressEnpoint {

    private static final Logger LOG = LoggerFactory.getLogger(AddressEnpoint.class);

    private final AddressService addressService;

    @Autowired
    public AddressEnpoint(AddressService addressService) {
        this.addressService = addressService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/addresses/{cep}")
    public @ResponseBody
    Mono<AddressResponse> findCustomer(@PathVariable("cep") String cep) {

        LOG.info("Buscar informações de Customer por CPF: [{}] ", cep);

        return addressService.findByCep(cep)
                .switchIfEmpty(Mono.error(new ClientException(404, "address_validation",	"Informações não encontradas para o Address " + cep)))
                .map(AddressResponse::new)
                .doOnSuccess(t -> LOG.info("Encontrado dados do cep [{}]", t));




    }
}
