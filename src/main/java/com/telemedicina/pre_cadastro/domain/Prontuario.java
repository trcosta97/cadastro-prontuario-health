package com.telemedicina.pre_cadastro.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cd_prontario")
    private String cdProntuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Usuario medico;

    @Column(name = "data_atendimento")
    private LocalDateTime dataAtendimento;

    // Campos do SOAP
    @Column(name = "subjetivo", columnDefinition = "TEXT")
    private String subjetivo; // S - Queixas e relatos do paciente

    @Column(name = "objetivo", columnDefinition = "TEXT")
    private String objetivo; // O - Exame físico e achados clínicos

    @Column(name = "avaliacao", columnDefinition = "TEXT")
    private String avaliacao; // A - Diagnóstico e avaliação clínica

    @Column(name = "plano", columnDefinition = "TEXT")
    private String plano; // P - Plano de tratamento e conduta

    // Campos de comorbidades que podem ser atualizados pelo médico
    @Column(name = "hipertensao")
    private boolean hipertensaoArterialSistemica;

    @Column(name = "diabetes")
    private boolean diabetes;

    @Column(name = "tuberculose")
    private boolean tuberculose;

    @Column(name = "hanseniase")
    private boolean hanseniase;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ativo")
    private boolean ativo;

    public Prontuario() {
    }

    public Prontuario(Long id, Paciente paciente, Usuario medico, LocalDateTime dataAtendimento,
                      String subjetivo, String objetivo, String avaliacao, String plano,
                      boolean hipertensaoArterialSistemica, boolean diabetes,
                      boolean tuberculose, boolean hanseniase,
                      LocalDateTime dataCriacao, boolean ativo, String cdProntuario) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAtendimento = dataAtendimento;
        this.subjetivo = subjetivo;
        this.objetivo = objetivo;
        this.avaliacao = avaliacao;
        this.plano = plano;
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
        this.diabetes = diabetes;
        this.tuberculose = tuberculose;
        this.hanseniase = hanseniase;
        this.dataCriacao = dataCriacao;
        this.cdProntuario = cdProntuario;
        this.ativo = ativo;
    }

    // Método para inicializar prontuário com as informações de comorbidades do usuário
    public static Prontuario iniciarProntuario(Paciente paciente, Usuario medico) {
        Prontuario prontuario = new Prontuario();
        prontuario.setPaciente(paciente);
        prontuario.setMedico(medico);
        prontuario.setDataAtendimento(LocalDateTime.now());

        // Preenchendo os campos de comorbidades com as informações do paciente
        prontuario.setHipertensaoArterialSistemica(paciente.isHipertensaoArterialSistemica());
        prontuario.setDiabetes(paciente.isDiabetes());
        prontuario.setTuberculose(paciente.isTuberculose());
        prontuario.setHanseniase(paciente.isHanseniase());

        prontuario.setDataCriacao(LocalDateTime.now());
        prontuario.setAtivo(true);

        return prontuario;
    }

    // Getters e Setters
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

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public boolean isHipertensaoArterialSistemica() {
        return hipertensaoArterialSistemica;
    }

    public void setHipertensaoArterialSistemica(boolean hipertensaoArterialSistemica) {
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(boolean tuberculose) {
        this.tuberculose = tuberculose;
    }

    public boolean isHanseniase() {
        return hanseniase;
    }

    public void setHanseniase(boolean hanseniase) {
        this.hanseniase = hanseniase;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}