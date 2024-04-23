package com.movie.booking.repository;

import com.movie.booking.jpa.TheaterMovieShowMapping;
import com.movie.booking.model.MovieShowDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TheaterMovieShowMappingRepository extends JpaRepository<TheaterMovieShowMapping,String> {
    @Query(value = "select distinct show_dates as showDates from theater_movie_show_mapping where movie_id = :movieId and theater_id = :theaterId " , nativeQuery = true)
    List<Date> getMovieShowDates(String movieId , String theaterId);

    @Query(value = "select sd.show_timing as showTiming from (select show_id from theater_movie_show_mapping where movie_id = :movieId and theater_id = :theaterId and " +
            "show_date = :showDate) as tmsm inner join show_details sd on tmsm.show_id = sd.id " , nativeQuery = true)
    List<String> getMovieShowTimings(String movieId , String theaterId , String showDate );
}
