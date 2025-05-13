package com.telemedicina.pre_cadastro.repository;

import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

    Optional<Roles> getRolesById(Long id);


    Optional<Roles> findByName(String name);
}
