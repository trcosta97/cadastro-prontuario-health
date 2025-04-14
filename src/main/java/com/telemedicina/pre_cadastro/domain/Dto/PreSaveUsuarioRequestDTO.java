package com.telemedicina.pre_cadastro.domain.Dto;

import java.time.LocalDate;

public record PreSaveUsuarioRequestDTO(
        String nomeCompleto,
        String cpf,
        LocalDate dataNascimento,
        String sexo,
        boolean gestante,
        String celular,
        String email,
        String senha,
        SaveEnderecoRequestDTO endereco
    ) {
}
