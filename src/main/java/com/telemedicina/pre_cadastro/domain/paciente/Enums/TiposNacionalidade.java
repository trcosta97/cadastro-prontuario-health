package com.telemedicina.pre_cadastro.domain.paciente.Enums;

public enum TiposNacionalidade {
    BRASILEIRA("Brasileira"),
    ESTRANGEIRA("Estrangeira"),
    NATURALIZADA("Naturalizada");

    private final String descricao;

    TiposNacionalidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
