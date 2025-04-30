package com.telemedicina.pre_cadastro.domain.Dto;

import com.telemedicina.pre_cadastro.domain.Agendamento.Enums.StatusAgendamento;
import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        LocalDateTime dataHora,
        String cpfPaciente,
        String cpfMedico,
        StatusAgendamento statusAgendamento,
        String observacao
) {
}
