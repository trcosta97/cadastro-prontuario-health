package com.telemedicina.pre_cadastro.domain.atestado;

import com.telemedicina.pre_cadastro.domain.dto.AtestadoRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_atestados")

public class Atestado {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id")
    private Usuario usuario;
    @Column(name = "data_inicio_atestado")
    private LocalDate dataInicio;
    @Column(name = "duracao_dias_atestado")
    private Integer duracaoDias;


    public Atestado(Long id, Paciente paciente, Usuario usuario, LocalDate dataInicio, Integer duracaoDias) {
        this.id = id;
        this.paciente = paciente;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.duracaoDias = duracaoDias;
    }

    public Atestado() {

    }

    public Atestado(AtestadoRequestDTO data) {
        this.duracaoDias = data.duracaoDias();
        this.dataInicio = data.dataInicio();
    }

    public Integer getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(Integer duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
