package com.telemedicina.pre_cadastro.domain.Dto;


import com.telemedicina.pre_cadastro.domain.Usuario.Enums.Roles;

import java.util.Set;

public record SetRoleDTO(Set<Roles> roles) {
}
