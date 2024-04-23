package com.movie.booking.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "THEATER_INFO")
public class TheaterInfo implements Serializable {

    @Serial
    private static final long serialVersionId = 122424913423525L;
    @Id
    private int id ;

    @Column(name = "THEATER_NAME")
    private String theaterName;

    @Column(name = "OWNER_USER_ID")
    private String  ownerUserId;

    @Column(name = "DURATION")
    private float duration;

    @Column(name = "RATING")
    private float rating;



}
