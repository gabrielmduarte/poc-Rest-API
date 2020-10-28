package com.expressacademy.professores.response;

import com.expressacademy.professores.domain.CourseEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeacherResponse {

    private Long id;

    private String name;

    private List<CourseEntity> courses;

    private String email;

    private String cpf;

    private PaymentInfoResponse paymentInfo;

    private AddressResponse address;

}
