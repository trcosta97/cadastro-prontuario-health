package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.Dto.PreSaveUsuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Dto.SetRoleDTO;
import com.telemedicina.pre_cadastro.domain.Dto.UpdateUsuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody PreSaveUsuarioRequestDTO data, UriComponentsBuilder uriBuilder){
        var newUsuario = service.save(new Usuario(data));
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(newUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(newUsuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody UpdateUsuarioRequestDTO data) {
        var updatedUsuario = service.update(id, data);
        return ResponseEntity.ok(updatedUsuario);
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<Usuario> setRole(@PathVariable Long id, @RequestBody SetRoleDTO data) {
        var updatedUsuario = service.setRole(id, data.role());
        return ResponseEntity.ok(updatedUsuario);
    }

}
