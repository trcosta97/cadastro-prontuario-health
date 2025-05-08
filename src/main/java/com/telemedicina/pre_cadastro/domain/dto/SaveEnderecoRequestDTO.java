package com.telemedicina.pre_cadastro.domain.dto;

public record SaveEnderecoRequestDTO(
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String complemento
) {
}
