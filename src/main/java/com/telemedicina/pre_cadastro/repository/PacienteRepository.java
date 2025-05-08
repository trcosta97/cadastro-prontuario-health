package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> getPacienteById(Long id);
    Optional<Paciente> findByCpf(String cpf);
    Optional<Paciente> findByEmail(String email);
    Optional<List<Paciente>> findAllByAtivoTrue();


}
