package com.expressacademy.professores.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentInfoRequest {

    @Valid
    @NotNull
    private AddressRequest address;

    @Valid
    @NotNull
    private BankDataRequest bankData;

    @NotBlank
    private String email;

    @NotBlank
    private String cpf;
}
