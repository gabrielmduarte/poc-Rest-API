package com.expressacademy.professores.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

}
