package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.Agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByPacienteCpf(String cpf);

    Agendamento findByMedicoCpf(String cpf);
}
