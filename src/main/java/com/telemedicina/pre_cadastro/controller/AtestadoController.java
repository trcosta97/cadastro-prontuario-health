package com.telemedicina.pre_cadastro.controller;



import com.telemedicina.pre_cadastro.domain.atestado.Atestado;
import com.telemedicina.pre_cadastro.domain.dto.AtestadoRequestDTO;
import com.telemedicina.pre_cadastro.service.AtestadoService;
import com.telemedicina.pre_cadastro.service.PacienteService;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/atestado")

public class AtestadoController {

    @Autowired
    private AtestadoService atestadoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/medico/{cpf}")
    public ResponseEntity<List<Atestado>> getAtestadoByMedico(@PathVariable String cpf) {
        var atestado = atestadoService.getByMedicoCpf(cpf);
        if (atestado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atestado);
    }

    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<Atestado>> getAtestadoByPaciente(@PathVariable String cpf) {
        var atestado = atestadoService.getByPacienteCpf(cpf);
        if (atestado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atestado);
    }

    @GetMapping
    public ResponseEntity<List<Atestado>> getAllAtestado() {
        var atestado = atestadoService.getAll();
        if (atestado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atestado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atestado> getAtestadoById(@PathVariable Long id) {
        Optional<Atestado> atestadoOptional = atestadoService.getById(id);
        var atestado = atestadoOptional.get();
        return ResponseEntity.ok(atestado);

    }

    @PostMapping
    public ResponseEntity<Atestado> save(@RequestBody AtestadoRequestDTO data) {
        // Cria a nova declaração com os dados do DTO
        var newAtestado = new Atestado(data);



        // Seta o paciente com base no ID recebido no corpo da requisição
        newAtestado.setPaciente(pacienteService.getById(data.pacienteId()));

        // Recupera o ID do usuário logado diretamente do JWT (campo "sub")
        var authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getToken().getSubject());

        // Busca o usuário com base no ID extraído do JWT
        newAtestado.setUsuario(usuarioService.getById(usuarioId));

        // Salva e retorna a declaração
        return ResponseEntity.ok(atestadoService.save(newAtestado));
    }

}
