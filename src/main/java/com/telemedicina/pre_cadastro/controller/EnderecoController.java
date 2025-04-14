package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    @Autowired
    EnderecoService service;

    @RequestMapping("/all")
    public ResponseEntity<Iterable<Endereco>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }


}
