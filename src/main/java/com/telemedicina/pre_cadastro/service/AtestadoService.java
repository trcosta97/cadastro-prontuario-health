package com.telemedicina.pre_cadastro.service;


import com.telemedicina.pre_cadastro.domain.atestado.Atestado;
import com.telemedicina.pre_cadastro.repository.AtestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtestadoService {

    @Autowired
    private AtestadoRepository atestadoRepository;


    @Autowired
    AtestadoRepository repository;



    public List<Atestado> getByPacienteCpf(String cpf) {
        return atestadoRepository.findByPacienteCpf(cpf);
    }

    public List<Atestado> getByMedicoCpf(String cpf) {
        return atestadoRepository.findByUsuarioCpf(cpf);
    }

    public Optional<Atestado> getById(Long id) {
        return atestadoRepository.findById(id);
    }

    public List<Atestado> getAll() {
        return atestadoRepository.findAll();
    }

    public Atestado save(Atestado atestado) {
        return repository.save(atestado);
    }



}
