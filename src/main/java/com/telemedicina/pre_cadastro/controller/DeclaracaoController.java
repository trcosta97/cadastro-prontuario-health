package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.declaracao.Declaracao;
import com.telemedicina.pre_cadastro.domain.dto.DeclaracaoRequestDTO;
import com.telemedicina.pre_cadastro.service.DeclaracaoService;
import com.telemedicina.pre_cadastro.service.PacienteService;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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
        // Cria a nova declaração com os dados do DTO
        var newDeclaracao = new Declaracao(data);

        // Seta o paciente com base no ID recebido no corpo da requisição
        newDeclaracao.setPaciente(pacienteService.getById(data.pacienteId()));

        // Recupera o ID do usuário logado diretamente do JWT (campo "sub")
        var authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getToken().getSubject());

        // Busca o usuário com base no ID extraído do JWT
        newDeclaracao.setUsuario(usuarioService.getById(usuarioId));

        // Salva e retorna a declaração
        return ResponseEntity.ok(declaracaoService.save(newDeclaracao));
    }
}
