package com.telemedicina.pre_cadastro.domain.Usuario.Enums;

public enum IdentidadesGeneros {

    CISGENERO("Cisgênero"),
    TRANSGENERO("Transgênero"),
    HOMOSSEXUAL("Homossexual"),
    BISEXUAL("Bissexual"),
    TRANSGEENRO_TRANSSEXUAL("Transgênero/Transsexual"),
    TRAVESTI("Travesti"),
    INTERSEXUAL("Intersexual"),
    NAO_BINARIO("Não Binário"),
    OUTRO("Outro");

    private final String descricao;

    IdentidadesGeneros(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
