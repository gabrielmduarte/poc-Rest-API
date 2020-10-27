package com.expressacademy.professores.response;

import lombok.Data;

import java.util.List;

@Data
public class TeacherResponse {

    private Long id;

    private String name;

    private List<CourseResponse> courses;

    private String email;

    private String cpf;

    private PaymentInfoResponse paymentInfo;

    private AddressResponse address;

}
