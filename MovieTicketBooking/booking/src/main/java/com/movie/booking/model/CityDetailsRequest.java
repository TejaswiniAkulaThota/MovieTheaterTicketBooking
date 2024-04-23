package com.movie.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


public record CityDetailsRequest (
    @JsonProperty
    List<CityDetailsForm> cityDetailsFormList
) implements Serializable {

}
