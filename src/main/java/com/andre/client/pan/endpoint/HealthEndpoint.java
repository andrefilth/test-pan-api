package com.andre.client.pan.endpoint;

import com.andre.client.pan.constants.Constants;
import com.andre.client.pan.endpoint.response.HealthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(HealthEndpoint.class);

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(Constants.CONTEXT_PATH + "/health")
    public Mono<HealthResponse> health() {
        return Mono.just(new HealthResponse())
                .doOnSuccess(t -> LOG.info("Status da aplicação [{}]", t));
    }
}
