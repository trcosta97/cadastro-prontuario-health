package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.Dto.UpdatePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.RoleRepository;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    RoleRepository roleRepository;



    public Usuario save(Usuario usuario){
        var newUsuario = repository.save(usuario);
        return repository.save(usuario);
    }

    public Usuario get(Long id){
        Optional<Usuario> optionalUsuario = repository.findById(id);
        return optionalUsuario.orElse(null);
    }


    public Iterable<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario setRole(Long id, Long roleId) {
        var usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada"));


        usuario.setRole(Set.of(role));
        return repository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> buscarTodosAtivos() {
        return repository.findAllByAtivoTrue()
                .orElseThrow(() -> new RuntimeException("Nenhum usuário ativo encontrado"));
    }

}
