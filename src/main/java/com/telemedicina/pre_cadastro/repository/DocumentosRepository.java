package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.documentos.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long> {
}
