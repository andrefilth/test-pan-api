package com.andre.client.pan.services.impl;

import com.andre.client.pan.endpoint.enums.StatesType;
import com.andre.client.pan.services.StatesService;
import com.andre.client.pan.ws.StateClient;
import com.andre.client.pan.ws.response.CityWsResponse;
import com.andre.client.pan.ws.response.StatesWSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatesServiceImpl implements StatesService {


    private static final Logger LOG = LoggerFactory.getLogger(StatesServiceImpl.class);

    private final StateClient client;

    @Autowired
    public StatesServiceImpl(StateClient client) {
        this.client = client;
    }

    @Override
    public Flux<List<String>> findStates() {
        var states = client.findByStates();
        return ajustStates(client.findByStates());

//        return listStates().flatMap(c -> ajustStates(c));
    }

    @Override
    public Mono<List<CityWsResponse>> findStatesByCity(StatesType state) {
        return findStatesId(state).flatMap(c -> findCities(c))
                .doOnSuccess(b -> LOG.info(" Lista: [ { } ]", b));
    }

    private Mono<List<CityWsResponse>> findCities(Integer c) {
        List<CityWsResponse> byCity = client.findStatesByCity(c);
        return Mono.justOrEmpty(byCity);
    }

    private Mono<Integer> findStatesId(StatesType state) {
        return Mono.justOrEmpty(client.findByStates()
                .stream()
                .filter(city -> city.getSigla().equals(state.name()))
                .map(StatesWSResponse::getId).findFirst().get());
    }

    private Flux<List<String>> ajustStates(List<StatesWSResponse> listStates) {
        return Flux.just(getSorted(listStates));
    }

    private List<String> getSorted(List<StatesWSResponse> listStates) {
        List<String> newList = new ArrayList<>();
        var sp = listStates.stream()
                .filter(c -> c.getSigla().equals("SP"))
                .map(StatesWSResponse::getSigla)
                .findFirst()
                .get();
        var rj = listStates.stream()
                .filter(c -> c.getSigla().equals("RJ"))
                .map(StatesWSResponse::getSigla)
                .findFirst()
                .get();
        var sorted = listStates.stream()
                .map(StatesWSResponse::getSigla)
                .sorted()
                .filter(c -> !c.equals("SP") && !c.equals("RJ"))
                .collect(Collectors.toList());
        LOG.info("Lista sem SP e RJ [{}] ",  sorted);
        newList.add(sp);
        newList.add(rj);
        newList.addAll(sorted);
        return newList;
    }

}
