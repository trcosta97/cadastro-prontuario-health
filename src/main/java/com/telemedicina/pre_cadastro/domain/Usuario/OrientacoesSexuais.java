package com.telemedicina.pre_cadastro.domain.Usuario;

public enum OrientacoesSexuais {
    HETEROSEXUALIDADE("Heterossexual"),
    HOMOSSEXUALIDADE("Homossexual"),
    BISEXUALIDADE("Bissexual"),
    PANSSEXUALIDADE("Panssexual"),
    DEMISEXUALIDADE("Demissexual"),
    LITERSEXUALIDADE("Literosexual"),
    AUTOSEXUALIDADE("Autosexual"),
    ANTROSEXUALIDADE("Antrosexual");

    private final String descricao;

    OrientacoesSexuais(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}