package com.telemedicina.pre_cadastro.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telemedicina.pre_cadastro.domain.Dto.SaveEnderecoRequestDTO;
import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Table(name = "tb_users_address")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    @Column(name="street")
    private String logradouro;
    @Column(name="number")
    private String numero;
    @Column(name="neighborhood")
    private String bairro;
    @Column(name="city")
    private String cidade;
    @Column(name="state")
    private String estado;
    @Column(name="complement")
    private String complemento;
    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    @PrimaryKeyJoinColumn(name="userId")
    private Paciente paciente;
    @Column(name="isActive")
    private boolean ativo;
    @Column(name="createdAt")
    private LocalDateTime dataRegsitro;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String logradouro, String number, String bairro, String cidade, String estado, String complemento, Paciente paciente, boolean ativo, LocalDateTime dataRegsitro) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = number;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.paciente = paciente;
        this.ativo = ativo;
        this.dataRegsitro = dataRegsitro;
    }

    public Endereco(SaveEnderecoRequestDTO data) {
        this.cep = data.cep();
        this.logradouro = data.logradouro();
        this.numero = data.numero();
        this.bairro = data.bairro();
        this.cidade = data.cidade();
        this.estado = data.estado();
        this.complemento = data.complemento();
        this.ativo = true;
        this.dataRegsitro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumber() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDateTime getDataRegsitro() {
        return dataRegsitro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumber(String number) {
        this.numero = number;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataRegsitro(LocalDateTime dataRegsitro) {
        this.dataRegsitro = dataRegsitro;
    }

    public void setUsuario(Usuario usuario) {
        if (this.paciente != null) {
            this.paciente.setEndereco(this);
        }
    }
}
