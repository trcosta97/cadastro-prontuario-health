package com.telemedicina.pre_cadastro.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProntuarioRequestDTO(
        @NotNull Long pacienteId,
        @NotBlank(message = "Código de prontuário não pode ser vazio") String cdProntuario,
        String subjetivo,
        String objetivo,
        String avaliacao,
        String plano,
        Boolean hipertensaoArterialSistemica,
        Boolean diabetes,
        Boolean tuberculose,
        Boolean hanseniase,
        Boolean gestante,
        Boolean puperpera,
        Boolean saudeMental,
        String ciap,
        String cip,
        String cipesc,
        String cidOdontologico
) {}
