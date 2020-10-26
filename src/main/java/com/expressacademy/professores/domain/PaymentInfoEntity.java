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

    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.PERSIST)
    private BankDataEntity bankData;

    @Column(nullable = false)//unique
    private String email;

    @Column(nullable = false)
    private String cpf; //document




    //cpf email e address -> atributos do teacher
    //bank data deixa de existir e os atributos ficam nesta classe


}
