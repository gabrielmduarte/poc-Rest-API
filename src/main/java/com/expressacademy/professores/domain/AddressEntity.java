package com.expressacademy.professores.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "ADDRESS")
@Entity
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

}
