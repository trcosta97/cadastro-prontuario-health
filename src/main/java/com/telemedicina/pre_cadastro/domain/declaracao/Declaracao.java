package com.telemedicina.pre_cadastro.domain.declaracao;

import com.telemedicina.pre_cadastro.domain.dto.DeclaracaoRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tb_declaracao")
@Entity(name = "Declaracao")
public class Declaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id")
    private Usuario usuario;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private List<MotivoDeclaracao> motivos;

    public Declaracao(DeclaracaoRequestDTO data){
        this.paciente = new Paciente();
        this.paciente.setId(data.pacienteId());
        this.usuario = new Usuario();
        this.usuario.setId(data.usuarioId());
        this.entrada = data.entrada();
        this.saida = data.saida();
        this.motivos = data.motivos();
    };

    public Declaracao(Long id, Paciente paciente, Usuario usuario, LocalDateTime entrada, LocalDateTime saida, List<MotivoDeclaracao> motivos) {
        this.id = id;
        this.paciente = paciente;
        this.usuario = usuario;
        this.entrada = entrada;
        this.saida = saida;
        this.motivos = motivos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public List<MotivoDeclaracao> getMotivos() {
        return motivos;
    }

    public void setMotivos(List<MotivoDeclaracao> motivos) {
        this.motivos = motivos;
    }
}
