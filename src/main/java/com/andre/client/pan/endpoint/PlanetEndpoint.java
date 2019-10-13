package com.andre.client.pan.endpoint;

import com.andre.client.pan.constants.Constants;
import com.andre.client.pan.endpoint.response.PlanetResponse;
import com.andre.client.pan.exception.ClientException;
import com.andre.client.pan.services.PlanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.andre.client.pan.constants.Constants.*;

@RestController
@RequestMapping(CONTEXT_PATH)
public class PlanetEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(PlanetEndpoint.class);

    private final PlanetService planetService;

    public PlanetEndpoint(PlanetService planetService) {
        this.planetService = planetService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/planets/{id}")
    public Mono<PlanetResponse> findPlanetById(@PathVariable("id") String id) {

        LOG.info("Buscar um planeta por ID: [{}]", id);

        return planetService.findPlanetById(id)
                .switchIfEmpty(Mono.error(new ClientException(404, "planet_validation", "Planeta não encontrado")))
                .map(PlanetResponse::new)
                .doOnSuccess(t -> LOG.info("Encontrado cidades [{}]", t));
    }


}