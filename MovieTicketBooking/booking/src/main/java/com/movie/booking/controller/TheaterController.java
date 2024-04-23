package com.movie.booking.controller;

import com.movie.booking.model.CityDetailsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController implements Theater{
    @Override
    public ResponseEntity<String> updateCities(CityDetailsRequest cityDetailsRequest) {
        return null;
    }
}
