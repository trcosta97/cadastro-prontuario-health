package com.telemedicina.pre_cadastro.repository;


import com.telemedicina.pre_cadastro.domain.remedio.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    List<Remedio> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT r FROM Remedio r JOIN r.linhasDeCuidado lc JOIN r.condicoes c " +
            "WHERE (:linhaId IS NULL OR lc.id = :linhaId) " +
            "AND (:condicaoId IS NULL OR c.id = :condicaoId)")
    List<Remedio> filtrarPorLinhaECondicao(@Param("linhaId") Long linhaId, @Param("condicaoId") Long condicaoId);
}



