package com.telemedicina.pre_cadastro.domain.Usuario.Enums;

public enum Deficiencias {
    NENHUMA("Nenhuma"),
    VISUAL("Visual"),
    AUDITIVA("Auditiva"),
    FISICA("Física"),
    INTELECTUAL("Intelectual");

    private final String descricao;

    Deficiencias(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
