package com.telemedicina.pre_cadastro.domain.remedio;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_condicao")
public class Condicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


}

