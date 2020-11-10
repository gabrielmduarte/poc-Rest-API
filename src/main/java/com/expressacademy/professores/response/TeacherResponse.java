package com.expressacademy.professores.response;

import lombok.Data;

@Data
public class TeacherResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private PaymentInfoResponse paymentInfo;

    private AddressResponse address;

}
