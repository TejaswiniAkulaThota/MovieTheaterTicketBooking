package com.movie.booking.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "PAYMENT_GATEWAY")
public class PaymentGateway implements Serializable {
    @Serial
    private static final long serialVersionId = 12239965058456895L;

    @Id
    @Column(name= "ID")
    private String Id;

    @Column(name= "PROVIDER_NAME")
    private String providerName;
}
