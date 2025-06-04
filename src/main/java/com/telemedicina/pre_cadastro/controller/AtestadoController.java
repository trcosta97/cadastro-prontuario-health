package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.atestado.Atestado;
import com.telemedicina.pre_cadastro.domain.dto.AtestadoRequestDTO;
import com.telemedicina.pre_cadastro.domain.dto.AtestadoResponseDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/atestado")
public class AtestadoController {

    @Autowired
    private AtestadoService atestadoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PacienteService pacienteService;

    // Conversor para o DTO de resposta, sem o campo motivo
    private AtestadoResponseDTO toResponseDTO(Atestado atestado) {
        return new AtestadoResponseDTO(
                atestado.getId(),
                atestado.getPaciente() != null ? atestado.getPaciente().getId() : null,
                atestado.getDataInicio(),
                atestado.getDuracaoDias(),
                atestado.getPaciente() != null ? atestado.getPaciente().getNomeCompleto() : null
        );
    }

    @GetMapping("/medico/{cpf}")
    public ResponseEntity<List<AtestadoResponseDTO>> getAtestadoByMedico(@PathVariable String cpf) {
        var atestados = atestadoService.getByMedicoCpf(cpf);
        if (atestados == null || atestados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AtestadoResponseDTO> dtos = atestados.stream().map(this::toResponseDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<AtestadoResponseDTO>> getAtestadoByPaciente(@PathVariable String cpf) {
        var atestados = atestadoService.getByPacienteCpf(cpf);
        if (atestados == null || atestados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AtestadoResponseDTO> dtos = atestados.stream().map(this::toResponseDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping
    public ResponseEntity<List<AtestadoResponseDTO>> getAllAtestado() {
        var atestados = atestadoService.getAll();
        if (atestados == null || atestados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AtestadoResponseDTO> dtos = atestados.stream().map(this::toResponseDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtestadoResponseDTO> getAtestadoById(@PathVariable Long id) {
        Optional<Atestado> atestadoOptional = atestadoService.getById(id);
        if (atestadoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toResponseDTO(atestadoOptional.get()));
    }

    @PostMapping
    public ResponseEntity<AtestadoResponseDTO> save(@RequestBody AtestadoRequestDTO data) {
        var newAtestado = new Atestado(data);

        // Seta o paciente com base no ID recebido no corpo da requisição
        newAtestado.setPaciente(pacienteService.getById(data.pacienteId()));

        // Recupera o ID do usuário logado diretamente do JWT (campo "sub")
        var authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getToken().getSubject());

        // Busca o usuário com base no ID extraído do JWT
        newAtestado.setUsuario(usuarioService.getById(usuarioId));

        // Salva e retorna o DTO de resposta
        var salvo = atestadoService.save(newAtestado);
        return ResponseEntity.ok(toResponseDTO(salvo));
    }
}
