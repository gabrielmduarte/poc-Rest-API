package com.expressacademy.professores.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class AddressRequest {

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String postalCode;
}
