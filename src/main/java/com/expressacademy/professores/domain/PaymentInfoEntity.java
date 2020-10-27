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

    private int bankCode;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private AccountType type;





    //cpf email e address -> atributos do teacher
    //bank data deixa de existir e os atributos ficam nesta classe


}
