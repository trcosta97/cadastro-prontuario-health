package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {


    @Autowired
    EnderecoRepository repository;


    public Iterable<Endereco> getAll(){
        return repository.findAll();
    }
}
