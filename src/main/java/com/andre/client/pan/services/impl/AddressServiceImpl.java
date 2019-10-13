package com.andre.client.pan.services.impl;

import com.andre.client.pan.services.AddressService;
import com.andre.client.pan.ws.AddressCepClient;
import com.andre.client.pan.ws.response.AddressWSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);


    private final AddressCepClient viaCEPClient;

    @Autowired
    public AddressServiceImpl(AddressCepClient viaCEPClient) {
        this.viaCEPClient = viaCEPClient;
    }

    @Override
    public Mono<AddressWSResponse> findByCep(String cep) {
        return getAddrressByCep(cep)

                .doOnSuccess( c -> LOG.info("Encontrado dados do CEP: [{ }] ", c.getCep()));
    }

    private Mono<AddressWSResponse> getAddrressByCep(String cep) {
        return Mono.justOrEmpty(viaCEPClient.buscaEnderecoPor(cep));
    }
}
