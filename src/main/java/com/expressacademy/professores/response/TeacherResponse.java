package com.expressacademy.professores.response;

import lombok.Data;

import java.util.List;

@Data
public class TeacherResponse {

    private Long id;

    private String name;

    private List<CourseIdLevelLanguageAndEnrollmentsResponse> courses;

    private PaymentInfoResponse paymentInfo;

}
