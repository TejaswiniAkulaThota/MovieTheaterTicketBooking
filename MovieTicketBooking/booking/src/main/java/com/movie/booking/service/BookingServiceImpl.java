package com.movie.booking.service;

import com.movie.booking.jpa.Reservation;
import com.movie.booking.model.*;
import com.movie.booking.repository.*;
import com.movie.booking.util.Constants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.movie.booking.util.Constants.OFFER_AFTERNOON_OFF;
import static com.movie.booking.util.Constants.OFFER_THIRD_FIFTY_PER_OFF;

@Service
public class BookingServiceImpl {
    MovieInfoRepository movieInfoRepository;
    TheaterMovieMappingRepository theaterMovieMappingRepository;

    TheaterMovieShowMappingRepository theaterMovieShowMappingRepository;

    TheaterSeatMappingRepository theaterSeatMappingRepository;

    OffersRepository offersRepository;

    ReservationRepository reservationRepository;
    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Autowired
    public void setOffersRepository(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }

    @Autowired
    public void setTheaterSeatMappingRepository(TheaterSeatMappingRepository theaterSeatMappingRepository) {
        this.theaterSeatMappingRepository = theaterSeatMappingRepository;
    }

    @Autowired
    public void setTheaterMovieShowMappingRepository(TheaterMovieShowMappingRepository theaterMovieShowMappingRepository) {
        this.theaterMovieShowMappingRepository = theaterMovieShowMappingRepository;
    }

    @Autowired
    public void setTheaterMovieMappingRepository(TheaterMovieMappingRepository theaterMovieMappingRepository) {
        this.theaterMovieMappingRepository = theaterMovieMappingRepository;
    }

    @Autowired
    public void setMovieInfoRepository(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    public List<MovieResponse> getAllMovies()
    {
        try {
            return movieInfoRepository.getMovieInfo();
        }catch(Exception e)
        {
            return null;
        }
    }

    public List<CityDetails> getCitiesForMovie(String movieId)
    {
        try {
            return theaterMovieMappingRepository.getCitiesForMovie(movieId);
        }catch(Exception e)
        {
            return null;
        }
    }
    public List<MovieTheaterDetails> getMovieTheaters(String movieId, String cityId)
    {
        try{
            return theaterMovieMappingRepository.getMovieTheaters(movieId,cityId);
        }catch(Exception e)
        {
            return null;
        }

    }
    public List<Date> getMovieShowDates(String movieId, String theaterId)
    {
        try{
            return theaterMovieShowMappingRepository.getMovieShowDates(movieId,theaterId);
        }catch(Exception e)
        {
            return null;
        }

    }
    public List<String> getMovieShowTiming(String movieId, String theaterId, String showDate)
    {
        try{
            return theaterMovieShowMappingRepository.getMovieShowTimings(movieId,theaterId,showDate);
        }catch(Exception e)
        {
            return null;
        }

    }
    public List<String> getSeatAvailablity(String movieId, String theaterId, String showDate , String showId)
    {
        try{
            return theaterSeatMappingRepository.getSeatAvailability(movieId,theaterId,showDate,showId);
        }catch(Exception e)
        {
            return null;
        }

    }

    public String bookTicket(String movieId, String theaterId, String showDate , String showId , List<String> seatIds) {
        //getseat status -- if not blocked then go to synchronize block
        Float price = 0f;
        List<SeatStatus> seatStatus = theaterSeatMappingRepository.getSeatStatus(movieId, theaterId, showDate, showId, seatIds);
        List blockedSeats = seatStatus.stream().filter(s -> s.status() == Constants.BLOCKED_STATUS).map(bs -> bs.getSeatId()).collect(Collectors.toList());
        if (!blockedSeats.isEmpty())
            return "Seats" + blockedSeats + " are blocked for booking by other user.Please select any other seats to proceed";
        else {
                List<String> offers = offersRepository.getMovieOffers(movieId, theaterId);
                synchronized (this) {
                    theaterSeatMappingRepository.updateSeatStatus(movieId, theaterId, showDate, showId, seatIds, Constants.BLOCKED_STATUS);
                    if(offers.contains(OFFER_THIRD_FIFTY_PER_OFF))
                    {
                        int noOfTicketsForOff = seatIds.size() % 3;
                        price = (float) ((seatIds.size() - noOfTicketsForOff) * 150 + noOfTicketsForOff % 2);

                    }
                    if(offers.contains(OFFER_AFTERNOON_OFF) && showId.equals("2"))
                    {
                        price = (80 * price) / 100;
                    }
                }
            }
        return " Please click Proceed to pay the price of" + price + "to finish the booking";
        }

        public String performPayment(String movieId, String theaterId, String showDate, String showId, List<String> seatIds , Float price , String paymentMode)
        {
            //call the payment api to perform payment .In case of success give the reservation Id
            // In case of any timeout or exception during the payment then in the finally block update the status of
            // blocked seats to Y and return failure message
            return "";
        }
        public String cancelTicket(String reservationId)
        {
            Optional<Reservation> reservation = reservationRepository.findById(reservationId);
            if(reservation.isPresent())
            {
                // call payment reverse api
                // If the payment reverse is successfull delete the reservation details and unblock the seat availability
                //else return message to user to try after sometime
            }
            return "";
        }
        //Payment can be done some payment mode or wallet
        //Create a scheduler service to check the status of the seats every 15 min and update status to Y
        //Create a scheduler to update the seat availability for movie and theater and seat mapping after the date has passed

    }
