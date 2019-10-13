package com.andre.client.pan.services;

import com.andre.client.pan.ws.response.AddressWSResponse;
import reactor.core.publisher.Mono;

public interface AddressService {

    Mono<AddressWSResponse> findByCep(String cep);
}
