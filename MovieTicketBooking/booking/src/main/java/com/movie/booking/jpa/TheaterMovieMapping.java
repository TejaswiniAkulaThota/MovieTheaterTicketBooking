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
@Table(name = "THEATER_MOVIE_MAPPING")
public class TheaterMovieMapping implements Serializable {
    @Serial
    private static final long serialVersionId = 12242498456895L;

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "THEATER_ID")
    private String theaterId;

    @Column(name = "MOVIE_ID")
    private String movieId;

    @Column(name = "CITY_ID")
    private String cityId;
}
