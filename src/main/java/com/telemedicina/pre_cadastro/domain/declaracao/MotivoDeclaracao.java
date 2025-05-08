package com.telemedicina.pre_cadastro.domain.declaracao;

public enum MotivoDeclaracao {

    CONSULTA("Consulta"),
    REALIZACAO_DE_EXAMES("Realização de Exames"),
    OUTROS("Outros");

    private final String descricao;

    MotivoDeclaracao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

