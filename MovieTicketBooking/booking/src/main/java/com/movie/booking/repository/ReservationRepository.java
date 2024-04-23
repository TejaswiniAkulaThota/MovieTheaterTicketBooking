package com.movie.booking.repository;

import com.movie.booking.jpa.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Override
    Optional<Reservation> findById(String s);
}
