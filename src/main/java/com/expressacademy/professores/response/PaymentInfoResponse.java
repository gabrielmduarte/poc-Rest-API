package com.expressacademy.professores.response;

import lombok.Data;

@Data
public class PaymentInfoResponse {

    private String bank;

    private int bankCode;

    private String agency;

    private String accountNumber;

    private String type;

}
