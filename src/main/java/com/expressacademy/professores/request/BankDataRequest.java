package com.expressacademy.professores.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BankDataRequest {

    @NotBlank
    private String bank;

    @NotNull
    @Range(min = 1, max = 1000)
    private int code;

    @NotNull
    @Range(min = 1, max = 1000)
    private int agency;

    @NotNull
    @Range(min = 1, max = 100000000)
    private int accountNumber;

    @NotBlank
    private String type;

}
