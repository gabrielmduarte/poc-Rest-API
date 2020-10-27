package com.expressacademy.professores.domain;

public enum AccountType {
    CONTA_CORRENTE("Conta Corrente"),
    CONTA_POUPANCA("Conta Poupança"),
    CONTA_SALARIO("Conta Salário");

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
