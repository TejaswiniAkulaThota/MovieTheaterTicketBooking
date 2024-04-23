package com.movie.booking.repository;

import com.movie.booking.jpa.TheaterSeatMapping;
import com.movie.booking.model.SeatStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Transactional
@Repository
public interface TheaterSeatMappingRepository extends JpaRepository<TheaterSeatMapping,String> {
    @Query(value = "select distinct seat_id from theater_seat_mapping where  movie_id = :movieId and " +
            "theater_id = :theaterId and show_date = :showDate and show_id = :showId and status = 'Y' " ,nativeQuery = true)
    List<String> getSeatAvailability(String movieId,String theaterId, String showDate, String showId);

    @Query(value = "select seat_id as seatId , status from Theater_Seat_Mapping where theater_id = :theaterId and movie_id = :movieId and show_date = :showDate and show_id = :showId and seat_id in (:seatIds))" , nativeQuery = true)
    List<SeatStatus> getSeatStatus(String movieId, String theaterId, String showDate, String showId, List<String> seatIds);
    @Modifying
    @Query(value = "update Theater_Seat_Mapping set status = :status where theater_id = :theaterId and movie_id = :movieId and show_date = :showDate and show_id = :showId and seat_id in (:seatIds)" , nativeQuery = true)
    List<SeatStatus> updateSeatStatus(String movieId, String theaterId, String showDate, String showId, List<String> seatIds , String status);


}
