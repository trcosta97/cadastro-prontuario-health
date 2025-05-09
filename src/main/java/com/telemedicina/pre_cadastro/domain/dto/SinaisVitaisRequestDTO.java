package com.telemedicina.pre_cadastro.domain.dto;

import java.math.BigDecimal;

public record SinaisVitaisRequestDTO(
        String pressaoArterial,
        Integer frequenciaRespiratoria,
        Integer frequenciaCardiaca,
        BigDecimal temperatura,
        Integer escalaDor) {
}
