package com.telemedicina.pre_cadastro.service;


import com.telemedicina.pre_cadastro.domain.declaracao.Declaracao;
import com.telemedicina.pre_cadastro.repository.DeclaracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclaracaoService {


    @Autowired
    DeclaracaoRepository repository;


    public Declaracao save(Declaracao declaracao) {
        return repository.save(declaracao);
    }


}
