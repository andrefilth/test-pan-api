package com.andre.client.pan.endpoint.response;

import com.andre.client.pan.ws.response.PlanetWSResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "countFilms"

})

public class PlanetResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("countFilms")
    private int countFilms;

    public PlanetResponse(PlanetWSResponse planetWSResponse) {
        this.name = planetWSResponse.getName();
        this.countFilms = planetWSResponse.getFilms().size();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("status", name)
                .append("countFilms", countFilms)
                .build();
    }

}
