package com.expressacademy.professores.domain;

public enum Level {
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado"),
    CONVERSACAO("Conversação");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


//from value, from code

