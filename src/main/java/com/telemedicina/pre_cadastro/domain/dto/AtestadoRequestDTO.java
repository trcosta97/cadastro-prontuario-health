package com.telemedicina.pre_cadastro.domain.dto;

import java.time.LocalDate;

public record AtestadoRequestDTO(Long pacienteId, LocalDate dataInicio, Integer duracaoDias) {



}
