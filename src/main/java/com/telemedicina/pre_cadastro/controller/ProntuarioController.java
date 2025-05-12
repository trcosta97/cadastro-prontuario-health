package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.dto.ProntuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Prontuario;
import com.telemedicina.pre_cadastro.domain.paciente.Enums.Roles;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import com.telemedicina.pre_cadastro.service.PacienteService;
import com.telemedicina.pre_cadastro.service.ProntuarioService;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteService pacienteService;

    // Listar prontuários de um paciente específico
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Prontuario>> listarProntuariosPorPaciente(@PathVariable Long pacienteId) {
        List<Prontuario> prontuarios = prontuarioService.listarProntuariosPorPaciente(pacienteId);
        return ResponseEntity.ok(prontuarios);
    }

    // Obter um prontuário específico
    @GetMapping("/{id}")
    public ResponseEntity<Prontuario> buscarProntuario(@PathVariable Long id) {
        try {
            Prontuario prontuario = prontuarioService.buscarProntuario(id);
            return ResponseEntity.ok(prontuario);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Prontuario> criarProntuario(@RequestBody ProntuarioRequestDTO data) {
        var prontuario = new Prontuario(data);
        prontuarioService.criarProntuario(prontuario);
        return ResponseEntity.ok(prontuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prontuario> atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioRequestDTO dto) {
        try {
            Prontuario prontuarioAtualizado = prontuarioService.atualizarProntuario(id, dto);
            return ResponseEntity.ok(prontuarioAtualizado);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Desativar prontuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarProntuario(@PathVariable Long id) {
        try {
            prontuarioService.desativarProntuario(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prontuario>> listarTodosProntuarios() {
        try {
            List<Prontuario> prontuarios = prontuarioService.getAll();
            return ResponseEntity.ok(prontuarios);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Listar prontuários atendidos pelo médico logado
    @GetMapping("/medico")
    public ResponseEntity<List<Prontuario>> listarProntuariosPorMedicoLogado() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String emailMedicoLogado = auth.getName();
            Usuario medicoLogado = usuarioService.buscarPorEmail(emailMedicoLogado);

            List<Prontuario> prontuarios = prontuarioService.listarProntuariosPorMedico(medicoLogado.getId());
            return ResponseEntity.ok(prontuarios);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Listar prontuários atendidos pelo médico por data
    @GetMapping("/medico/data")
    public ResponseEntity<List<Prontuario>> listarProntuariosPorMedicoEData(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String emailMedicoLogado = auth.getName();
            Usuario medicoLogado = usuarioService.buscarPorEmail(emailMedicoLogado);

            LocalDateTime inicio = data.atStartOfDay();
            LocalDateTime fim = data.atTime(LocalTime.MAX);

            List<Prontuario> prontuarios = prontuarioService.listarProntuariosPorMedicoEData(
                    medicoLogado.getId(), inicio, fim);
            return ResponseEntity.ok(prontuarios);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}