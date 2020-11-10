package com.expressacademy.professores.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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
    @ToString.Exclude
    private LanguageEntity language;

    @Column(nullable = false)
    @ToString.Exclude
    private Level level;

    @Column(nullable = false)
    @ToString.Exclude
    private Status status;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @ToString.Exclude
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<EnrollmentEntity> enrollments;

    @Column(nullable = false)
    private int numberOfClasses;

    private int classesGiven;

    @Enumerated(EnumType.STRING)
    private Weekday classDay;

    @Column(nullable = false)
    private LocalTime time;

    private String note;

    @Column(nullable = false)
    private BigDecimal monthlyPrice;

    @Column(nullable = false)
    private LocalDate firstPaymentDate;

    @Column(nullable = false)
    private int numberOfMonthlyPayments;

    public int getTotalEnrollments() {
        return this.getEnrollments().size();
    }

    public String getStatusDescription() {
        return this.status.getDescription();
    }

    public String getLevelName() {
        return this.level.getName();
    }

    public String getClassDayName() {
        return this.classDay.getDay();
    }

    public String getTeacherName() {
        return this.teacher.getName();
    }

    public String getLanguageName() {
        return this.language.getName();
    }

}
