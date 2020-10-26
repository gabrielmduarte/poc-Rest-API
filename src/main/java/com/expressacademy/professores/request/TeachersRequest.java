package com.expressacademy.professores.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TeachersRequest {

    @NotBlank
    private String name;

    @Valid
    @NotNull
    private PaymentInfoRequest paymentInfo;

}
