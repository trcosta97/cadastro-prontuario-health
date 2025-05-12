package com.telemedicina.pre_cadastro.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telemedicina.pre_cadastro.domain.dto.ProntuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
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
    private Boolean hipertensaoArterialSistemica;
    @Column(name = "diabetes")
    private Boolean diabetes;
    @Column(name = "tuberculose")
    private Boolean tuberculose;
    @Column(name = "hanseniase")
    private Boolean hanseniase;
    @Column(name = "gestante")
    private Boolean gestante;
    @Column(name = "puperpera")
    private Boolean puperpera;
    @Column(name = "saude_mental")
    private Boolean saudeMental;
    @OneToOne(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private SinaisVitais sinaisVitais;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    // Campos por perfil profissional
    private String ciap;
    private String cip;             // Para médicos
    private String cipesc;          // Para enfermeiros
    private String cidOdontologico; // Para dentistas
    @Column(name = "ativo")
    private boolean ativo;


    public Prontuario() {
    }

    public Prontuario(Long id, Paciente paciente, Usuario medico, LocalDateTime dataAtendimento,
                      String subjetivo, String objetivo, String avaliacao, String plano,
                      Boolean hipertensaoArterialSistemica, Boolean diabetes, Boolean saudeMental,
                      Boolean tuberculose, Boolean hanseniase, Boolean gestante, Boolean puperpera,
                      LocalDateTime dataCriacao, Boolean ativo, String cdProntuario) {
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

    public Prontuario(ProntuarioRequestDTO dto, Paciente paciente, Usuario medico) {
        this.cdProntuario = dto.cdProntuario();
        this.subjetivo = dto.subjetivo();
        this.objetivo = dto.objetivo();
        this.avaliacao = dto.avaliacao();
        this.plano = dto.plano();
        this.hipertensaoArterialSistemica = dto.hipertensaoArterialSistemica();
        this.diabetes = dto.diabetes();
        this.tuberculose = dto.tuberculose();
        this.hanseniase = dto.hanseniase();
        this.gestante = dto.gestante();
        this.puperpera = dto.puperpera();
        this.saudeMental = dto.saudeMental();
        this.ciap = dto.ciap();
        this.cip = dto.cip();
        this.cipesc = dto.cipesc();
        this.cidOdontologico = dto.cidOdontologico();
        this.medico = medico;
        this.paciente = paciente;

        if (dto.sinaisVitais() != null) {
            this.sinaisVitais = new SinaisVitais(dto.sinaisVitais());
            this.sinaisVitais.setProntuario(this); // 💥 esse é o ponto-chave
        }
    }



    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SinaisVitais getSinaisVitais() {
        return sinaisVitais;
    }

    public void setSinaisVitais(SinaisVitais sinaisVitais) {
        this.sinaisVitais = sinaisVitais;
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

    public Boolean isHipertensaoArterialSistemica() {
        return hipertensaoArterialSistemica;
    }

    public void setHipertensaoArterialSistemica(Boolean hipertensaoArterialSistemica) {
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
    }

    public Boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean isTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(Boolean tuberculose) {
        this.tuberculose = tuberculose;
    }

    public Boolean isHanseniase() {
        return hanseniase;
    }

    public void setHanseniase(Boolean hanseniase) {
        this.hanseniase = hanseniase;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCdProntuario() {
        return cdProntuario;
    }


    public void setCdProntuario(String cdProntuario) {
        this.cdProntuario = cdProntuario;
    }

    public Boolean isGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Boolean isPuperpera() {
        return puperpera;
    }

    public void setPuperpera(Boolean puperpera) {
        this.puperpera = puperpera;
    }

    public Boolean isSaudeMental() {
        return saudeMental;
    }

    public void setSaudeMental(Boolean saudeMental) {
        this.saudeMental = saudeMental;
    }

    public Boolean getHipertensaoArterialSistemica() {
        return hipertensaoArterialSistemica;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public Boolean getTuberculose() {
        return tuberculose;
    }

    public Boolean getHanseniase() {
        return hanseniase;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public Boolean getPuperpera() {
        return puperpera;
    }

    public Boolean getSaudeMental() {
        return saudeMental;
    }

    public String getCiap() {
        return ciap;
    }

    public void setCiap(String ciap) {
        this.ciap = ciap;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCipesc() {
        return cipesc;
    }

    public void setCipesc(String cipesc) {
        this.cipesc = cipesc;
    }

    public String getCidOdontologico() {
        return cidOdontologico;
    }

    public void setCidOdontologico(String cidOdontologico) {
        this.cidOdontologico = cidOdontologico;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}