package com.movie.booking.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {
    @Serial
    private static final long serialVersionId = 1223934458456895L;
    @Id
    @Column(name= "ID")
    private String id;

    @Column(name= "THEATER_ID")
    private String theaterId;

    @Column(name= "MOVIE_ID")
    private String movieId;

    @Column(name= "SHOW_ID")
    private String showId;

    @Column(name= "SHOW_DATE")
    private Date showDate;

    @Column(name= "SEAT_ID")
    private String seatId;

    @Column(name= "USER_ID")
    private String userId;

    @Column(name= "CREATE_DATE")
    private Date createDate;

}
