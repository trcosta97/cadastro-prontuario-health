package com.telemedicina.pre_cadastro.domain.Usuario;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telemedicina.pre_cadastro.domain.Dto.LoginRequestDTO;
import com.telemedicina.pre_cadastro.domain.Dto.SaveUsuarioDTO;
import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.domain.Usuario.Enums.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_users")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    //Campos de pré-cadastro
    private String cpf;
    @Column(name = "fullname")
    private String nomeCompleto;
    @Column(name = "email")
    private String email;
    @Column(name = "birthdate")
    private LocalDate dataNascimento;
    @Column(name="gender")
    private String sexo;
    @Column(name = "whatsapp")
    private String celular;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column(name="enabled ")
    private boolean ativo;
    @Column(name="dateCreated ")
    private LocalDateTime dataRegistro;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Roles> roles;

    public Usuario() {
    }

    public Usuario(String cpf, String nomeCompleto, LocalDate dataNascimento, String sexo, String celular, String password, Endereco endereco) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.celular = celular;
        this.password = password;
        this.endereco = endereco;
    }

    public Usuario(@Valid SaveUsuarioDTO data) {
        this.cpf = data.cpf();
        this.nomeCompleto = data.nomeCompleto();
        this.dataNascimento = data.dataNascimento();
        this.sexo = data.sexo();
        this.celular = data.celular();
        this.password = data.senha();
        this.email = data.email();
        this.endereco = new Endereco(data.endereco());
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCelular() {
        return celular;
    }

    public String getPassword() {
        return password;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.endereco = endereco;
        endereco.setUsuario(this);
    }


    public boolean isLoginCorrect(LoginRequestDTO loginRequestDTO, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequestDTO.password(), this.password);
    }

    public void setRole(Set<Roles> adminRole) {
        this.roles = adminRole;
    }
}
