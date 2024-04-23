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
@Table(name = "USER_TYPE")
public class UserType implements Serializable {
    @Serial
    private static final long serialVersionId = 1223930058456895L;

    @Id
    @Column(name= "ID")
    private String id;

    @Column(name= "USER_TYPE")
    private String userType;

}
