package com.telemedicina.pre_cadastro.domain.Dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProntuarioRequestDTO(
        @NotNull
        Long pacienteId,
        String subjetivo,
        String objetivo,
        String avaliacao,
        String plano,
        boolean hipertensaoArterialSistemica,
        boolean diabetes,
        boolean tuberculose,
        boolean hanseniase
) {

}