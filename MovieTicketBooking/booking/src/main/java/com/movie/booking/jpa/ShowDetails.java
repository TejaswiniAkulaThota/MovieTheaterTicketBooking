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
@Table(name = "SHOW_DETAILS")
public class ShowDetails implements Serializable {
    @Serial
    private static final long serialVersionId = 1224234458456895L;

    @Id
    @Column(name= "Id")
    private String id;

    @Column(name = "NAME")
    private String showName;

    @Column(name = "SHOW_TIMING")
    private String showTimings;

}
