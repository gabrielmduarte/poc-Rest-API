package com.expressacademy.professores.response;

import com.expressacademy.professores.domain.EnrollmentEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private List<EnrollmentEntity> enrollments;

}
