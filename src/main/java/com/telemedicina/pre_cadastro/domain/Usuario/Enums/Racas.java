package com.telemedicina.pre_cadastro.domain.Usuario.Enums;

public enum Racas {
    BRANCA("Branca"),
    PRETA("Preta"),
    PARDA("Parda"),
    AMARELA("Amarela"),
    INDIGENA("Indígena");

    private final String descricao;

    Racas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
