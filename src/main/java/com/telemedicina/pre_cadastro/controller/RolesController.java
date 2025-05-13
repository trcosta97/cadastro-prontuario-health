package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import com.telemedicina.pre_cadastro.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/roles")
@RestController
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    public ResponseEntity<Roles> save(@RequestBody Roles role) {
        Roles savedRole = rolesService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }
}
