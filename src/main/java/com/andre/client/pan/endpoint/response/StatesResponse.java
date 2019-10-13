package com.andre.client.pan.endpoint.response;

import com.andre.client.pan.ws.response.StatesWSResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import reactor.core.publisher.Signal;

import java.util.List;

public class StatesResponse {
    private Integer id;
    private String nome;

    public StatesResponse(StatesWSResponse response) {
        this.nome = response.getNome();
        this.id = response.getId();
    }


    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .build();
    }
}
