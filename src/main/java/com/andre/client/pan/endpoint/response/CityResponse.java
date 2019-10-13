package com.andre.client.pan.endpoint.response;

import com.andre.client.pan.ws.response.CityWsResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CityResponse {

    private Integer id;
    private String nome;

    public CityResponse(CityWsResponse response) {
        this.id = response.getId();
        this.nome = response.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .build();
    }
}
