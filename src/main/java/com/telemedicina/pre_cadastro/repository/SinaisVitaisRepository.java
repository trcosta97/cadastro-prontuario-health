package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.SinaisVitais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SinaisVitaisRepository extends JpaRepository<SinaisVitais, Long> {

    Optional<SinaisVitais> findByProntuarioId(Long prontuarioId);
}
