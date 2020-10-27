package com.expressacademy.professores.request;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TeachersRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @Valid
    @NotNull
    private PaymentInfoRequest paymentInfo;

    @Valid
    @NotNull
    private AddressRequest address;

}
