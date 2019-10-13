package com.andre.client.pan.ws;

import com.andre.client.pan.ws.response.PlanetWSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(url="https://swapi.co/api/planets", name = "planet")
public interface PlanetClient {

    @GetMapping("/{id}")
    public PlanetWSResponse findPlanetById(@PathVariable("id") String id);
}
