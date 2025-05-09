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
    @JoinColumn(name = "prontuario_id")
    @JsonBackReference
    private Prontuario prontuario;

    public SinaisVitais(SinaisVitaisRequestDTO sinaisVitaisRequestDTO) {
        this.pressaoArterial = sinaisVitaisRequestDTO.pressaoArterial();
        this.frequenciaRespiratoria = sinaisVitaisRequestDTO.frequenciaRespiratoria();
        this.frequenciaCardiaca = sinaisVitaisRequestDTO.frequenciaCardiaca();
        this.temperaturaCorporea = sinaisVitaisRequestDTO.temperatura();
        this.escalaDor = sinaisVitaisRequestDTO.escalaDor();
    }
}
