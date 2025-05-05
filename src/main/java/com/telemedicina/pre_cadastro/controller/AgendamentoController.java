package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.Agendamento.Agendamento;
import com.telemedicina.pre_cadastro.domain.Dto.AgendamentoRequestDTO;
import com.telemedicina.pre_cadastro.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;


    @PostMapping
    public ResponseEntity<Agendamento> agendarConsulta(@RequestBody AgendamentoRequestDTO data, UriComponentsBuilder uriBuilder) {
        var newAgendamento = agendamentoService.save(data);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(newAgendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(newAgendamento);
    }

    @GetMapping("/medico/{cpf}")
    public ResponseEntity<List<Agendamento>> getAgendamentoByMedico(@PathVariable String cpf) {
        var agendamento = agendamentoService.getByMedicoCpf(cpf);
        if (agendamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<Agendamento>> getAgendamentoByPaciente(@PathVariable String cpf) {
        var agendamento = agendamentoService.getByPacienteCpf(cpf);
        if (agendamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
        var agendamentos = agendamentoService.getAll();
        if (agendamentos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Agendamento> cancelarAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Agendamento> confirmarAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.confirmarAgendamento(id);
        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/{id}/naoCompareceu")
    public ResponseEntity<Agendamento> naoCompareceu(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.naoCompareceu(id);
        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/{id}/realizado")
    public ResponseEntity<Agendamento> realizado(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.agendamentoRealizado(id);
        return ResponseEntity.ok(agendamento);
    }


}
