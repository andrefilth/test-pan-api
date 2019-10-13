package com.andre.client.pan.endpoint.response;

import com.andre.client.pan.ws.response.AddressWSResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AddressResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public AddressResponse(AddressWSResponse response) {
        this.cep = response.getCep();
        this.logradouro = response.getLogradouro();
        this.complemento = response.getComplemento();
        this.bairro = response.getBairro();
        this.localidade = response.getLocalidade();
        this.uf = response.getUf();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cep", cep)
                .append("logradouro", logradouro)
                .append("complemento", complemento)
                .append("bairro", bairro)
                .append("localidade", localidade)
                .append("uf", uf)
                .build();
    }
}
