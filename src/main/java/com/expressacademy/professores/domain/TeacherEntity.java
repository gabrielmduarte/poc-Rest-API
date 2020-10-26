package com.expressacademy.professores.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
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
    private PaymentInfoEntity paymentInfo;

    @Column(nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<CourseEntity> courses = new ArrayList<>(); //nao criar aqui

}
