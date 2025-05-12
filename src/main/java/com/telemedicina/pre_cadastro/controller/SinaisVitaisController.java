package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.SinaisVitais;
import com.telemedicina.pre_cadastro.repository.SinaisVitaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sinais-vitais")
public class SinaisVitaisController {

    @Autowired
    private SinaisVitaisRepository sinaisVitaisRepository;

    @GetMapping("/prontuario/{prontuarioId}")
    public ResponseEntity<SinaisVitais> buscarSinaisVitaisPorProntuario(@PathVariable Long prontuarioId) {
        return sinaisVitaisRepository.findByProntuarioId(prontuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
