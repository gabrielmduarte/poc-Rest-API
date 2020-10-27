package com.expressacademy.professores.request;

import com.expressacademy.professores.domain.AccountType;
import com.expressacademy.professores.domain.Banks;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentInfoRequest {

    @NotBlank
    private String agency;

    @NotBlank
    private String accountNumber;

    @NotNull
    private Banks bank;

    @NotNull
    private AccountType type;

}
