package com.expressacademy.professores.domain;

public enum Status {
    INSCRICAO("Aberto para matrículas", true),
    EM_ANDAMENTO("Em andamento", true),
    ENCERRADO("Encerrado", true),
    CANCELADO("Cancelado", false);

    private String description;

    private boolean active;

    Status(String description, boolean active) {
        this.description = description;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

}
