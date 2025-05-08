package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.dto.SaveUsuarioDTO;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> save(@RequestBody @Valid SaveUsuarioDTO data, UriComponentsBuilder uriBuilder){
        var newUsuario = service.save(new Usuario(data));
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(newUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(newUsuario);

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid UpdatePacienteRequestDTO data) {
//        var updatedUsuario = service.update(id, data);
//        return ResponseEntity.ok(updatedUsuario);
//    }

    @PutMapping("/role")
    public ResponseEntity<Usuario> setRole(@RequestParam Long id, @RequestParam Long roleId) {
        var updatedUsuario = service.setRole(id, roleId);
        return ResponseEntity.ok(updatedUsuario);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Usuario>> getAll() {
        var usuarios = service.getAll();
        return ResponseEntity.ok(usuarios);

    }

}
