package com.expressacademy.professores.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_id_course"
    )
    @SequenceGenerator(name = "sequence_id_course")
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private LanguageEntity language;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @Column(nullable = false)
    private boolean active;//status

    @ManyToOne
    @JsonBackReference
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<EnrollmentEntity> enrollments = new ArrayList<>();

    @Column(nullable = false)
    private int numberOfClasses;

    private int classesGiven;

    @Column(nullable = false)
    private Month firstMonth;

    @Enumerated(EnumType.STRING)
    private Month lastMonth;

    @Enumerated(EnumType.STRING)
    private Weekday classDay;

    @Column(nullable = false)
    private String hour;

    private String note;

    @Column(nullable = false)
    private boolean allMonthlyFeePaid;

    @Column(nullable = false)
    private BigDecimal monthlyPrice;
//
//    @Column(nullable = false)
//    private int totalEnrollments;

    @Column(nullable = false)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstPaymentDate;

    @Column(nullable = false)
    private int numberOfMonthlyPayments;

}
