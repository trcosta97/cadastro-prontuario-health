package com.telemedicina.pre_cadastro.domain.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProntuarioRequestDTO(
        @NotNull
        Long pacienteId,
        String subjetivo,
        @NotBlank(message = "Código de prontuário não pode ser vazio")
        String cdProntuario,
        String objetivo,
        String avaliacao,
        String plano,
        Boolean hipertensaoArterialSistemica,
        Boolean diabetes,
        Boolean tuberculose,
        Boolean hanseniase,
        Boolean gestante,
        Boolean puperpera,
        Boolean saudeMental
) {
}
