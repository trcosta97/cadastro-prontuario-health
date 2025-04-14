package com.telemedicina.pre_cadastro.domain.Usuario;

public enum SituacaoMercadoDeTrabalho {
    ANALFABETA("Analfabeta"),
    FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
    FUNDAMENTAL_COMPLETO("Fundamental Completo"),
    MEDIO_INCOMPLETO("Médio Incompleto"),
    MEDIO_COMPLETO("Médio Completo"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    SUPERIOR_COMPLETO("Superior Completo");
    private final String descricao;
    SituacaoMercadoDeTrabalho(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
