package com.telemedicina.pre_cadastro.repository;


import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> getUsuarioById(Long id);
    Optional<Usuario> findByEmail(String email);
    Optional<List<Usuario>> findAllByAtivoTrue();

    Usuario findByCpf(String s);
}
