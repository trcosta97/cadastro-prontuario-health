package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.Dto.PreSavePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.Dto.UpdatePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import com.telemedicina.pre_cadastro.service.PacienteService;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;


    @PostMapping("/cadastro")
    public ResponseEntity<Paciente> save(@RequestBody @Valid PreSavePacienteRequestDTO data, UriComponentsBuilder uriBuilder){
        var newUsuario = service.save(new Paciente(data));
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(newUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(newUsuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody UpdatePacienteRequestDTO data) {
        var updatedUsuario = service.update(id, data);
        return ResponseEntity.ok(updatedUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> get(@PathVariable Long id) {
        var usuario = service.get(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }



    @GetMapping("/all")
    public ResponseEntity<Iterable<Paciente>> getAll() {
        var usuarios = service.getAll();
        return ResponseEntity.ok(usuarios);

    }

}
