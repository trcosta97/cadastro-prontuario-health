package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    List<Prontuario> findByPacienteIdAndAtivoTrue(Long pacienteId);

    List<Prontuario> findByMedicoIdAndAtivoTrue(Long medicoId);

    // Buscar prontuários por médico e data
    List<Prontuario> findByMedicoIdAndDataAtendimentoBetween(Long medicoId,
                                                             java.time.LocalDateTime inicio,
                                                             java.time.LocalDateTime fim);

    Long countByDataCriacaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}