package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.paciente.Enums.Roles;
import com.telemedicina.pre_cadastro.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    private RoleRepository roleRepository;

    public Roles save(Roles role) {
        return roleRepository.save(role);
    }

}
