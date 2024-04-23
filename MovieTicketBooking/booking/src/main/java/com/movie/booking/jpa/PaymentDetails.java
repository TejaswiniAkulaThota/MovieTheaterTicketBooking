package com.movie.booking.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails implements Serializable {
    @Serial
    private static final long serialVersionId = 1023934458456895L;
    @Id
    @Column(name= "ID")
    private String id;

    @Column(name= "PAYMENTGATEWAY_ID")
    private String paymentGatewayId;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;



}
