package com.movie.booking.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "CITY_DETAILS")
public class CityDetails implements Serializable {

    @Serial
    private static final long serialVersionId = 12242498492395L;
    @Id
    @Column(name= "Id")
    private String id;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "STATE")
    private String state;
}
