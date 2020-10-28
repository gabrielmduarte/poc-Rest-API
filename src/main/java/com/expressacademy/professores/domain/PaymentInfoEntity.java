package com.expressacademy.professores.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "PAYMENT_INFO")
@Entity
public class PaymentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Banks bank;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private AccountType type;

}
