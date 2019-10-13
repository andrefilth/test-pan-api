package com.andre.client.pan.ws;

import com.andre.client.pan.ws.response.AddressWSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface AddressCepClient {

    @GetMapping("{cep}/json")
    AddressWSResponse buscaEnderecoPor(@PathVariable("cep") String cep);

}
