package com.expressacademy.professores.domain;

public enum Weekday {
    SEGUNDA("Segunda feira"),
    TERCA("Terça feira"),
    QUARTA("Quarta feira"),
    QUINTA("Quinta feira"),
    SEXTA("Sexta feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private String day;

    Weekday(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

}
