package com.movie.booking.repository;

import com.movie.booking.model.CityDetails;
import com.movie.booking.jpa.TheaterMovieMapping;
import com.movie.booking.model.MovieShowDates;
import com.movie.booking.model.MovieTheaterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TheaterMovieMappingRepository extends JpaRepository<TheaterMovieMapping , String> {
    @Query(value = "select  tmm.city_id as cityId , c.city_name as cityName from THEATER_MOVIE_MAPPING tmm inner join city_details c on tmm.city_id = c.id  where tmm.movie_id = :movieId" , nativeQuery = true)
    List<CityDetails> getCitiesForMovie(String movieId);

    @Query(value = "select ti.id as theaterId, ti.theater_name as theaterName from (select distinct theater_id from THEATER_MOVIE_MAPPING where movie_id = :movieId and city_id = :cityId) tmm" +
            " inner join THEATER_INFO ti on  tmm.theater_id = ti.id " , nativeQuery = true)
    List<MovieTheaterDetails> getMovieTheaters(String movieId , String cityId);

}
