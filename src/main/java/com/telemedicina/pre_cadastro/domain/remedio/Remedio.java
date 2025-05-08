package com.telemedicina.pre_cadastro.domain.remedio;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_remedio")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "remedio_linha_cuidado",
            joinColumns = @JoinColumn(name = "remedio_id"),
            inverseJoinColumns = @JoinColumn(name = "linha_cuidado_id")
    )
    private Set<LinhaDeCuidado> linhasDeCuidado = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "remedio_condicao",
            joinColumns = @JoinColumn(name = "remedio_id"),
            inverseJoinColumns = @JoinColumn(name = "condicao_id")
    )
    private Set<Condicao> condicoes = new HashSet<>();

    // getters e setters
}

