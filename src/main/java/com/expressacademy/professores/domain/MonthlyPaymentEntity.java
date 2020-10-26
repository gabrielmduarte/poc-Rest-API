package com.expressacademy.professores.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Table(name = "payment")
@Entity
@Data
public class MonthlyPaymentEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_id_payment"
    )
    @SequenceGenerator(name = "sequence_id_payment")
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private EnrollmentEntity enrollment;

    @Column(nullable = false)
    private boolean paid;

    private boolean pastDue;

    @Column(nullable = false)
    private BigDecimal price;

    private BigDecimal discount;

}
