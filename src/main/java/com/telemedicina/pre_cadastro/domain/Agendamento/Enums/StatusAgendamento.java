package com.telemedicina.pre_cadastro.domain.Agendamento.Enums;

public enum StatusAgendamento {
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    REALIZADO("Realizado"),
    CANCELADO("Cancelado"),
    NAO_COMPARECEU("Não Compareceu"),
    REAGENDADO("Reagendado");

    private final String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
