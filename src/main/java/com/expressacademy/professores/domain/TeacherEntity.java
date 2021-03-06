package com.expressacademy.professores.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_id_teacher"
    )
    @SequenceGenerator(name = "sequence_id_teacher")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private PaymentInfoEntity paymentInfo;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressEntity address;

}
