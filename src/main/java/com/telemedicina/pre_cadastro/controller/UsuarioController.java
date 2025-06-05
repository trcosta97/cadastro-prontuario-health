package com.telemedicina.pre_cadastro.controller;


import com.telemedicina.pre_cadastro.domain.dto.SaveUsuarioDTO;
import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.RoleRepository;
import com.telemedicina.pre_cadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> save(@RequestBody @Valid SaveUsuarioDTO data, UriComponentsBuilder uriBuilder){
        Usuario newUsuario = new Usuario(data);

        // Associe as roles existentes do banco ao usuário
        if (data.rolesIds() != null && !data.rolesIds().isEmpty()) {
            Set<Roles> roles = data.rolesIds().stream()
                    .map(id -> roleRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Role não encontrada: " + id)))
                    .collect(Collectors.toSet());
            newUsuario.setRoles(roles);
        }

        var savedUsuario = service.save(newUsuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(savedUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(savedUsuario);
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
