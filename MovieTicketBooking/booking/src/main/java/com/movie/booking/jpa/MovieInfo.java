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
@Table(name = "MOVIE_INFO")
public class MovieInfo implements Serializable {

    @Serial
    private static final long serialVersionId = 1224249132344314525L;
    @Id
    private String id ;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;




}
