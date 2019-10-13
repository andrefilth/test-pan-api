package com.andre.client.pan.services;

import com.andre.client.pan.ws.response.PlanetWSResponse;
import reactor.core.publisher.Mono;

public interface PlanetService {


    Mono<PlanetWSResponse> findPlanetById(String id);
}
