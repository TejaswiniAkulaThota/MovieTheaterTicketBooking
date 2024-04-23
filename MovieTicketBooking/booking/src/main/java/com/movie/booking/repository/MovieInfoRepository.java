package com.movie.booking.repository;

import com.movie.booking.jpa.MovieInfo;
import com.movie.booking.model.MovieResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo, String> {
    @Query(value = "select distinct id ,movie_Name as movieName from  movie_info where start_Date <= current_timestamp() and end_date >= current_timestamp() " , nativeQuery = true)
    List<MovieResponse> getMovieInfo();

}
