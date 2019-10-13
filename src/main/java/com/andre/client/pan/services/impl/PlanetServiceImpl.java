package com.andre.client.pan.services.impl;

import com.andre.client.pan.services.PlanetService;
import com.andre.client.pan.ws.PlanetClient;
import com.andre.client.pan.ws.response.PlanetWSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlanetServiceImpl implements PlanetService {
    private static final Logger LOG = LoggerFactory.getLogger(PlanetServiceImpl.class);

    private final PlanetClient client;

    @Autowired
    public PlanetServiceImpl(PlanetClient client) {
        this.client = client;
    }

    @Override
    public Mono<PlanetWSResponse> findPlanetById(String id) {
        return Mono.justOrEmpty(client.findPlanetById(id));
    }
}
