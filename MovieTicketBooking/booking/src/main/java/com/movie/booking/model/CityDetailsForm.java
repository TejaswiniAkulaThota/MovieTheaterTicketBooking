package com.movie.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CityDetailsForm (
        @JsonProperty(value = "id" ,required = true)
        String id,
        @JsonProperty(value = "city_name" ,required = true)
        String cityName,
        @JsonProperty(value = "state" ,required = true)
        String state
) implements Serializable {
}
