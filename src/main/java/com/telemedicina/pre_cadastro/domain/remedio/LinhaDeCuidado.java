package com.telemedicina.pre_cadastro.domain.remedio;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_linha_de_cuidado")
public class LinhaDeCuidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


}

