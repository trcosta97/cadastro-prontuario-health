package com.telemedicina.pre_cadastro.domain.Usuario.Enums;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        ADMIN(1L),
        USUARIO(2L),
        RECEPCIONISTA(3L),
        AGENTE_COMUNITARIO(4L),
        ASSISTENTE_ADMINISTRATIVO(5L),
        GERENCIA_DA_UNIDADE(6L),
        MEDICO(7L),
        ENFERMEIRO(8L),
        EQUIPE_ENFERMAGEM(9L),
        EQUIPE_MULTIDICIPLINAR(10L),
        DENTISTA(11L);

        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }

        public long getRoleId() {
            return roleId;
        }
    }
}




