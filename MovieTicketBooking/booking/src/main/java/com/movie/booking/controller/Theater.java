package com.movie.booking.controller;

import com.movie.booking.model.CityDetails;
import com.movie.booking.model.CityDetailsRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/theater")
public interface Theater {
    @PutMapping(name = "/updateCities" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateCities(@RequestBody CityDetailsRequest cityDetailsRequest);
}
