package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.Agendamento.Agendamento;
import com.telemedicina.pre_cadastro.domain.Dto.AgendamentoRequestDTO;
import com.telemedicina.pre_cadastro.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping("medico/{cpf}")
    public ResponseEntity<Agendamento> getAgendamentoByMedico(@PathVariable String cpf) {
        var agendamento = agendamentoService.getByMedicoCpf(cpf);
        if (agendamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("paciente/{cpf}")
    public ResponseEntity<Agendamento> getAgendamentoByPaciente(@PathVariable String cpf) {
        var agendamento = agendamentoService.getByPacienteCpf(cpf);
        if (agendamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agendamento);
    }
}
