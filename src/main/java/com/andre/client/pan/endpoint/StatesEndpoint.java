package com.andre.client.pan.endpoint;

import com.andre.client.pan.constants.Constants;
import com.andre.client.pan.endpoint.enums.StatesType;
import com.andre.client.pan.exception.ClientException;
import com.andre.client.pan.services.StatesService;
import com.andre.client.pan.ws.response.CityWsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(Constants.CONTEXT_PATH)
public class StatesEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(StatesEndpoint.class);

    private final StatesService statesService;

    @Autowired
    public StatesEndpoint(StatesService statesService) {
        this.statesService = statesService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/states")
    public Flux<List<String>> findAllStates() {

        LOG.info("Buscar todos os Estados da Federação");

        return statesService.findStates()
                .switchIfEmpty(Mono.error(new ClientException(404, "states_validation",	"Sem lista de estados  ")))
                .doOnEach( c ->LOG.info("Dados encontrados  : [{}]", c))
                ;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/states/{state}/city")
    public Mono<List<CityWsResponse>> findStatesByCity(@PathVariable("state") StatesType state) {

        LOG.info("Buscar todos as cidades deste Estado: [{}]", state);

        return statesService.findStatesByCity(state)
                .switchIfEmpty(Mono.error(new ClientException(404, "states_validation",	"Sem lista de estados  ")))
                .doOnSuccess(t -> LOG.info("Encontrado cidades [{}]", t));
    }
}
