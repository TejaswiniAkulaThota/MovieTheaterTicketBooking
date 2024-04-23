package com.movie.booking.controller;

import com.movie.booking.jpa.MovieInfo;
import com.movie.booking.model.CityDetails;
import com.movie.booking.model.MovieResponse;
import com.movie.booking.model.MovieShowDates;
import com.movie.booking.model.MovieTheaterDetails;
import com.movie.booking.service.BookingServiceImpl;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class BookingController implements Booking{

    private BookingServiceImpl bookingService;
    @Autowired
    public void setBookingService(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }
    @Override
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movieInfoList = bookingService.getAllMovies();
        if(movieInfoList !=null)
            return new ResponseEntity(movieInfoList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<CityDetails>> getMovieCities(String movieId) {
        List<CityDetails> cityDetailsList = bookingService.getCitiesForMovie(movieId);
        if(cityDetailsList !=null)
            return new ResponseEntity(cityDetailsList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<MovieTheaterDetails>> getMovieTheaters(String movieId, String cityId) {
        List<MovieTheaterDetails> movieTheaterDetails = bookingService.getMovieTheaters(movieId,cityId);
        if(movieTheaterDetails !=null)
            return new ResponseEntity(movieTheaterDetails, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Date> getMovieShowDates(String movieId, String theaterId) {
        List<Date> movieShowDates = bookingService.getMovieShowDates(movieId,theaterId);
        if(movieShowDates !=null)
            return new ResponseEntity(movieShowDates, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<List<String>> getShowTiming(String movieId, String theaterId, String showDate) {
        List<String> movieShowTiming = bookingService.getMovieShowTiming(movieId,theaterId,showDate);
        if(movieShowTiming !=null)
            return new ResponseEntity(movieShowTiming, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<String>> searchAvailability(String movieId, String theaterId, String showDate, String showId) {
        List<String> availableSeats = bookingService.getSeatAvailablity(movieId,theaterId,showDate,showId);
        if(availableSeats!=null )
            return new ResponseEntity(availableSeats, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<String>> bookTicket(String movieId, String theaterId, String showDate, String showId, List<String> seatIds) {
        return null;
    }

}
