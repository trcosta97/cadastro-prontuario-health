package com.telemedicina.pre_cadastro.domain.Dto;

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
