package com.movie.booking.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "OFFERS")
public class Offers implements Serializable {
    private static final long serialVersionId = 1223996098758456895L;

    @Id
    @Column(name= "ID")
    private String Id;

    @Column(name = "OFFER_NAME")
    private String offerName;

    @Column(name = "THEATER_ID")
    private String theaterId;

    @Column(name = "MOVIE_ID")
    private String movieId;




}
