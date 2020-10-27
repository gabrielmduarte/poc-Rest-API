package com.expressacademy.professores.domain;

public enum Banks {
    BB("BCO DO BRASIL S.A.", 001),
    BRADESCO("BCO BRADESCO S.A.", 237),
    CAIXA("CAIXA ECONOMICA FEDERAL", 104),
    ITAU("ITAÚ UNIBANCO S.A.", 341),
    NUBANK("NU PAGAMENTOS S.A.", 260),
    SANTANDER("BCO SANTANDER (BRASIL) S.A.", 033);

    private String name;

    private int code;

    Banks(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
