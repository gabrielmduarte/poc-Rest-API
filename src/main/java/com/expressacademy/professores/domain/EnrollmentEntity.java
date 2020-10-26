package com.expressacademy.professores.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "enrollment")
public class EnrollmentEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_id_enrollment"
    )
    @SequenceGenerator(name = "sequence_id_enrollment")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private StudentEntity student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private CourseEntity course;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(nullable = false)
    private BigDecimal discountPercentage;

    private BigDecimal monthlyFee;

    @OneToMany(mappedBy = "enrollment")
    @JsonManagedReference
    private List<MonthlyPaymentEntity> payments = new ArrayList<>();

    private boolean pastDue;

}
