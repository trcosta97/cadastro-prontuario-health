package com.telemedicina.pre_cadastro.config;

import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.RoleRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AdminUserConfig(RoleRepository roleRepository, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Roles.Values.ADMIN.name());

        var userAdmin = usuarioRepository.findByEmail("admin");

        userAdmin.ifPresentOrElse(
                (usuario) -> {
                    System.out.println("Usuário já existe");
                },
                () -> {
                    roleAdmin.ifPresent(adminRole -> {
                        var usuario = new Usuario();
                        usuario.setNomeCompleto("admin");
                        usuario.setEmail("admin");
                        usuario.setPassword(bCryptPasswordEncoder.encode("123"));
                        usuario.setRole(Set.of(adminRole));
                        usuarioRepository.save(usuario);
                    });
                }
        );
    }
}