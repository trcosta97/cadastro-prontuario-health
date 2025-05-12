package com.telemedicina.pre_cadastro.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telemedicina.pre_cadastro.domain.dto.SinaisVitaisRequestDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_sinais_vitais")
public class SinaisVitais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pressao_arterial")
    private String pressaoArterial; // formato: "120x80"

    @Column(name = "frequencia_respiratoria")
    private Integer frequenciaRespiratoria;

    @Column(name = "frequencia_cardiaca")
    private Integer frequenciaCardiaca;

    @Column(name = "temperatura_corporea")
    private BigDecimal temperaturaCorporea;

    @Column(name = "escala_dor")
    private Integer escalaDor; // 0 a 10

    @OneToOne
    @JoinColumn(name = "prontuario_id", referencedColumnName = "id")
    @JsonBackReference
    private Prontuario prontuario;



    public SinaisVitais(SinaisVitaisRequestDTO sinaisVitaisRequestDTO) {
        if (sinaisVitaisRequestDTO != null) {
            this.pressaoArterial = sinaisVitaisRequestDTO.pressaoArterial();
            this.frequenciaRespiratoria = sinaisVitaisRequestDTO.frequenciaRespiratoria();
            this.frequenciaCardiaca = sinaisVitaisRequestDTO.frequenciaCardiaca();
            this.temperaturaCorporea = sinaisVitaisRequestDTO.temperatura();
            this.escalaDor = sinaisVitaisRequestDTO.escalaDor();
        }
    }

    public SinaisVitais(){}

    public SinaisVitais(Long id, String pressaoArterial,Integer frequenciaRespiratoria, Integer frequenciaCardiaca, BigDecimal temperaturaCorporea, Integer escalaDor, Prontuario prontuario) {
        this.id = id;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaRespiratoria = frequenciaRespiratoria;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperaturaCorporea = temperaturaCorporea;
        this.escalaDor = escalaDor;
        this.prontuario = prontuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public Integer getFrequenciaRespiratoria() {
        return frequenciaRespiratoria;
    }

    public void setFrequenciaRespiratoria(Integer frequenciaRespiratoria) {
        this.frequenciaRespiratoria = frequenciaRespiratoria;
    }

    public Integer getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Integer frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public BigDecimal getTemperaturaCorporea() {
        return temperaturaCorporea;
    }

    public void setTemperaturaCorporea(BigDecimal temperaturaCorporea) {
        this.temperaturaCorporea = temperaturaCorporea;
    }

    public Integer getEscalaDor() {
        return escalaDor;
    }

    public void setEscalaDor(Integer escalaDor) {
        this.escalaDor = escalaDor;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
