package com.expressacademy.professores.response;

import lombok.Data;

@Data
public class PaymentInfoResponse {

    private AddressResponse address;

    private BankDataResponse bankData;

    private String email;

    private String cpf;

}
