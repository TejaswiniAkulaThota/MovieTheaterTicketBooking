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
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable {

    @Serial
    private static final long serialVersionId = 1223987058456895L;

    @Id
    @Column(name= "USER_ID")
    private String userId;

    @Column(name= "USER_NAME")
    private String userName;

    @Column(name= "USER_TYPE")
    private String userType;

    @Column(name= "PHONE_NO")
    private String phoneNo;

    @Column(name= "EMAIL_ID")
    private String emailId;

}
