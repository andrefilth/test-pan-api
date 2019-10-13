package com.andre.client.pan.ws.response;

import java.util.LinkedList;
import java.util.List;

public class StatesWSResponse {

    private Integer id;
    private String sigla;
    private String nome;
    private List<CityWsResponse> cityWsResponses = new LinkedList<>();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CityWsResponse> getCityWsResponses() {
        return cityWsResponses;
    }

    public void setCityWsResponses(List<CityWsResponse> cityWsResponses) {
        this.cityWsResponses = cityWsResponses;
    }
}
