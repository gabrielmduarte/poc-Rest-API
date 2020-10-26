package com.expressacademy.professores.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LanguageRequest {

    @NotBlank
    private String name;

}
