package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.RoleRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    public Usuario save(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
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
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Roles role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));

        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        usuario.setRoles(roles); // Veja o próximo item também
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

    public Usuario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario buscarPorCpf(String cpf){
        return  repository.findByCpf(cpf);

    }


}
