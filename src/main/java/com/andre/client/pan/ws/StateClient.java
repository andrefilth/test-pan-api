package com.andre.client.pan.ws;

import com.andre.client.pan.ws.response.CityWsResponse;
import com.andre.client.pan.ws.response.StatesWSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.util.List;

@FeignClient(url="https://servicodados.ibge.gov.br/api/v1/localidades/estados", name = "viaestado")
public interface StateClient {

    @GetMapping("/")
    List<StatesWSResponse> findByStates();

    @GetMapping("/{id}/municipios")
    List<CityWsResponse> findStatesByCity(@PathVariable("id") Integer id);
}
