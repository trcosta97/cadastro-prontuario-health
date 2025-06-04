package com.telemedicina.pre_cadastro.domain.dto;

import java.time.LocalDate;

public record AtestadoResponseDTO(
        Long id,
        Long pacienteId,
        LocalDate dataInicio,
        Integer duracaoDias,
        String nomePaciente
) {
}
