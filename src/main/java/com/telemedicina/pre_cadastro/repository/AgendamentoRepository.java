package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByPacienteCpf(String cpf);

    List<Agendamento> findByMedicoCpf(String cpf);

    Long countByDataCriacaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
