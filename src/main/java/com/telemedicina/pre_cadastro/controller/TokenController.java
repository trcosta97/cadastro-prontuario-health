package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.dto.LoginRequestDTO;
import com.telemedicina.pre_cadastro.domain.dto.LoginResponseDTO;
import com.telemedicina.pre_cadastro.domain.usuario.Roles;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final JwtEncoder jwtEncoder;

    private final UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        var user = usuarioRepository.findByEmail(loginRequestDTO.email());

        if(user.isEmpty() || !user.get().isLoginCorrect(loginRequestDTO, bCryptPasswordEncoder)){
            throw new BadCredentialsException("Usuário não encontrado ou senha incorreta");
        }

        var now = Instant.now();
        var expiresIn = 3000L;

        // Extrair e mapear os roles do usuário para uma lista de strings
        List<String> userRoles = user.get().getRoles().stream()
                .map(Roles::getName)
                .collect(Collectors.toList());

        var claims = JwtClaimsSet.builder()
                .issuer("telemedicina")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("roles", userRoles) // Adicionando os roles como uma claim no JWT
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        // Retorna o token, tempo de expiração e os roles do usuário
        return ResponseEntity.ok(new LoginResponseDTO(jwtValue, expiresIn, userRoles));
    }

}
