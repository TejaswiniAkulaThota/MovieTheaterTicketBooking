package com.movie.booking.controller;


import com.movie.booking.jpa.MovieInfo;
import com.movie.booking.model.CityDetails;
import com.movie.booking.model.MovieResponse;
import com.movie.booking.model.MovieShowDates;
import com.movie.booking.model.MovieTheaterDetails;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/booking")
public interface Booking {
    /*
    Get all movie id and name details as list
     */
    @GetMapping(value = "/getAllMovies" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MovieResponse>> getAllMovies();

    @GetMapping(value = "/getMovieCities" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CityDetails>> getMovieCities(@Param("movieId") String movieId);

    @GetMapping(value = "/getMovieTheaters" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MovieTheaterDetails>> getMovieTheaters(@RequestAttribute(value = "movieId" , required = true) String movieId,
                                                               @RequestAttribute(value = "cityId" , required = true) String cityId);

    @GetMapping(value = "/getMovieShowDates" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Date> getMovieShowDates(@RequestAttribute(value = "movieId" , required = true) String movieId,
                                                @RequestAttribute(value = "theaterId" , required = true) String theaterId);

    @GetMapping(value = "/getShowTiming" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> getShowTiming(@RequestAttribute(value = "movieId" , required = true) String movieId,
                                     @RequestAttribute(value = "theaterId" , required = true) String theaterId,
                                     @RequestAttribute(value = "showDate" , required = true) String showDate);

    @GetMapping(value = "/searchAvailability" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> searchAvailability(@RequestAttribute(value = "movieId" , required = true) String movieId,
                                               @RequestAttribute(value = "theaterId" , required = true) String theaterId,
                                               @RequestAttribute(value = "showDate" , required = true) String showDate,
                                               @RequestAttribute(value = "showId" , required = true) String showId);

    @GetMapping(value = "/bookTicket" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> bookTicket(@RequestAttribute(value = "movieId" , required = true) String movieId,
                                                    @RequestAttribute(value = "theaterId" , required = true) String theaterId,
                                                    @RequestAttribute(value = "showDate" , required = true) String showDate,
                                                    @RequestAttribute(value = "showId" , required = true) String showId,
                                                    @RequestAttribute(value = "seatIds" , required = true) List<String> seatIds);








}
