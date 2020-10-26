package com.expressacademy.professores.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "language")
public class LanguageEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_id_language"
    )
    @SequenceGenerator(name = "sequence_id_language")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean active;

}
