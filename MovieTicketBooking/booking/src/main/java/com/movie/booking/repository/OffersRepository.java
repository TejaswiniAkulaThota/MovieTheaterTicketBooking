package com.movie.booking.repository;

import com.movie.booking.jpa.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OffersRepository extends JpaRepository<Offers,String> {
    @Query(value = "select offer_Name as offerName from offers where  movie_id = :movieId and theater_id = :theaterId" , nativeQuery = true)
    List<String> getMovieOffers(String movieId , String theaterId);
}
