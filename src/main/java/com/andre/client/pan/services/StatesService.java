package com.andre.client.pan.services;

import com.andre.client.pan.endpoint.enums.StatesType;
import com.andre.client.pan.ws.response.CityWsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StatesService {


    Flux<List<String>> findStates();

    Mono<List<CityWsResponse>> findStatesByCity(StatesType state);
}
