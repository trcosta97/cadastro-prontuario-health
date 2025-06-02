package com.telemedicina.pre_cadastro.repository;


import com.telemedicina.pre_cadastro.domain.atestado.Atestado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtestadoRepository extends JpaRepository<Atestado, Long> {

    List<Atestado> findByPacienteCpf(String cpf);

    List<Atestado> findByUsuarioCpf(String cpf);

}
