package com.telemedicina.pre_cadastro.domain.dto;

import com.telemedicina.pre_cadastro.domain.agendamento.Agendamento;
import com.telemedicina.pre_cadastro.domain.agendamento.StatusAgendamento;
import com.telemedicina.pre_cadastro.domain.agendamento.TipoAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(LocalDateTime dataHora,
                                     String nomePaciente,
                                     String nomeMedico,
                                     String cpfPaciente,
                                     StatusAgendamento status,
                                     TipoAgendamento tipo) {
    public AgendamentoResponseDTO(Agendamento newAgendamento) {
        this(newAgendamento.getDataHora(),
                newAgendamento.getPaciente().getNomeCompleto(),
                newAgendamento.getMedico().getNomeCompleto(),
                newAgendamento.getPaciente().getCpf(),
                newAgendamento.getStatusAgendamento(),
                newAgendamento.getTipo());
    }
}
