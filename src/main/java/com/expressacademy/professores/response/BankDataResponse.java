package com.expressacademy.professores.response;

import lombok.Data;

@Data
public class BankDataResponse {

    private String bank;

    private int code;

    private int agency;

    private int accountNumber;

    private String type;
}
