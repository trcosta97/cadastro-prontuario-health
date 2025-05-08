package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.declaracao.Declaracao;
import com.telemedicina.pre_cadastro.domain.dto.DeclaracaoRequestDTO;
import com.telemedicina.pre_cadastro.service.DeclaracaoService;
import com.telemedicina.pre_cadastro.service.PacienteService;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/declaracao")
public class DeclaracaoController {


    @Autowired
    DeclaracaoService declaracaoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Declaracao> save(@RequestBody DeclaracaoRequestDTO data) {
        var newDeclaracao = new Declaracao(data);
        newDeclaracao.setPaciente(pacienteService.getById(data.pacienteId()));
        newDeclaracao.setUsuario(usuarioService.getById(data.pacienteId()));
        return ResponseEntity.ok(declaracaoService.save(newDeclaracao));
    }
}
