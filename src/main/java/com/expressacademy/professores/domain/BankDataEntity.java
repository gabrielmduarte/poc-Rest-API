package com.expressacademy.professores.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "BANK_DATA")
@Entity
public class BankDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String bank;

    @Column(nullable = false)
    private int code;

    @Column(nullable = false)
    private int agency;

    @Column(nullable = false)
    private int accountNumber;

    @Column(nullable = false)
    private String type; //fazer enum

    // infos que sao printadas melhor ser string
    //n vai fazer ops aritmeticas



}
