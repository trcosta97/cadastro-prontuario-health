package com.telemedicina.pre_cadastro.domain.dto;

import com.telemedicina.pre_cadastro.domain.agendamento.StatusAgendamento;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        LocalDateTime dataHora,
        String cpfPaciente,
        String cpfMedico,
        StatusAgendamento statusAgendamento,
        String observacao
) {
}
