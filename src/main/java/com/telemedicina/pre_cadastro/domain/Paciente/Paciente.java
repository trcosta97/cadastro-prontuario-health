package com.telemedicina.pre_cadastro.domain.Paciente;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telemedicina.pre_cadastro.domain.Dto.PreSavePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.domain.Paciente.Enums.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cerne_pacientes")
public class Paciente {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    //Campos de pré-cadastro
    private String cpf;
    @Column(name = "fullname")
    private String nomeCompleto;
    @Column(name = "birthdate")
    private LocalDate dataNascimento;
    @Column(name="gender")
    private String sexo;
    @Column(name = "whatsapp")
    private String celular;
    @Column(name="whatsappContactable")
    private Boolean temWhatsapp;
    private String email;
    @Column(name = "password")
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column(name="enabled ")
    private boolean ativo = true;
    @Column(name="dateCreated ")
    private LocalDateTime dataRegistro;
    // Campos de cadastro completo
    private String cns;
    @Enumerated(EnumType.STRING)
    @Column(name="race")
    private Racas raca;
    @Column(name="preferredName")
    private String nomeSocial;
    @Enumerated(EnumType.STRING)
    @Column(name="nationality")
    private TiposNacionalidade nacionalidade;
    @Column(name="motherName")
    private String nomeMae;
    @Column(name="fatherName")
    private String nomePai;
    private String pisPasep;
    @Column(name="levelOfEducation")
    private String grauDeInstrucao;
    @Enumerated(EnumType.STRING)
    @Column(name=" employmentStatus")
    private SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho;
    @Column(name=" ocupations")
    private List<String> ocupacoes;
    // Deu ou não info sobre orientação sexual
    @Column(name=" hasSexualOrientation")
    private Boolean infoOrientacao;
    @Enumerated(EnumType.STRING)
    @Column(name=" sexualOrientation")
    private OrientacoesSexuais orientacaoSexual;
    @Column(name=" hasGenderIdentity")
    private Boolean infoIdentidadeGenero;
    @Enumerated(EnumType.STRING)
    @Column(name=" genderIdentity")
    private IdentidadesGeneros identidadeGenero;
    @Column(name=" hasDisability")
    private Boolean infoDeficiencia;
    @Enumerated(EnumType.STRING)
    @Column(name=" disability")
    private Deficiencias deficiencia;
    @Column(name=" hasHealthPlan")
    private Boolean planoSaude;
    //É membro de povo ou comunidade tradicional ou Campo, Floresta e Águas?
    @Column(name=" isTraditionalCommunity")
    private Boolean comunidadeTradicional;
    @Column(name=" isUnderTwoYearsOld")
    private Boolean menorQueDoisAnos;
    @Column(name=" hasSystemicHypertension")
    private Boolean hipertensaoArterialSistemica;
    @Column(name=" hasDiabetes")
    private Boolean diabetes;
    @Column(name=" hasLeprosy")
    private Boolean hanseniase;
    @Column(name=" hasTuberculosis")
    private Boolean tuberculose;
    @Column(name = "gestante")
    private Boolean gestante;
    @Column(name = "puerperio")
    private Boolean puerperio;
    @Column(name = "saude_mental")
    private Boolean saudeMental;
    // Teve diagnóstico de algum problema de saúde mental por algum profissional de saúde?  (Sim/Não)
    @PrimaryKeyJoinColumn(name=" hasMentalIllness")
    private Boolean transtornoMental;

    public Paciente(Long id, String cpf, String nomeCompleto, LocalDate dataNascimento, String sexo, String celular,
                    Boolean temWhatsapp, String email, String senha, Endereco endereco, Boolean ativo, LocalDateTime dataRegistro,
                    String cns, Racas raca, String nomeSocial, TiposNacionalidade nacionalidade, String nomeMae, String nomePai,
                    String pisPasep, String grauDeInstrucao, SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho, List<String> ocupacoes,
                    Boolean infoOrientacao, OrientacoesSexuais orientacaoSexual, Boolean infoIdentidadeGenero, IdentidadesGeneros identidadeGenero,
                    Boolean infoDeficiencia, Deficiencias deficiencia, Boolean planoSaude, Boolean comunidadeTradicional, Boolean menorQueDoisAnos,
                    Boolean hipertensaoArterialSistemica, Boolean diabetes, Boolean hanseniase, Boolean tuberculose, Boolean transtornoMental,
                    Boolean puperpera, Boolean saudeMental, Boolean gestante) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.celular = celular;
        this.temWhatsapp = temWhatsapp;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.ativo = ativo;
        this.dataRegistro = dataRegistro;
        this.cns = cns;
        this.raca = raca;
        this.nomeSocial = nomeSocial;
        this.nacionalidade = nacionalidade;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.pisPasep = pisPasep;
        this.grauDeInstrucao = grauDeInstrucao;
        this.situacaoMercadoDeTrabalho = situacaoMercadoDeTrabalho;
        this.ocupacoes = ocupacoes;
        this.infoOrientacao = infoOrientacao;
        this.orientacaoSexual = orientacaoSexual;
        this.infoIdentidadeGenero = infoIdentidadeGenero;
        this.identidadeGenero = identidadeGenero;
        this.infoDeficiencia = infoDeficiencia;
        this.deficiencia = deficiencia;
        this.planoSaude = planoSaude;
        this.comunidadeTradicional = comunidadeTradicional;
        this.menorQueDoisAnos = menorQueDoisAnos;
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
        this.diabetes = diabetes;
        this.hanseniase = hanseniase;
        this.tuberculose = tuberculose;
        this.transtornoMental = transtornoMental;
        this.puerperio = puperpera;
        this.saudeMental = saudeMental;
        this.gestante = gestante;
    }

    public Paciente() {
    }

    public Paciente(@Valid PreSavePacienteRequestDTO data) {
        this.cpf = data.cpf();
        this.nomeCompleto = data.nomeCompleto();
        this.dataNascimento = data.dataNascimento();
        this.sexo = data.sexo();
        this.celular = data.celular();
        this.email = data.email();
        this.senha = data.senha();
        this.endereco = new Endereco(data.endereco());

    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCelular() {
        return celular;
    }

    public Boolean isTemWhatsapp() {
        return temWhatsapp;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public String getCns() {
        return cns;
    }

    public Racas getRaca() {
        return raca;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public TiposNacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public String getGrauDeInstrucao() {
        return grauDeInstrucao;
    }

    public SituacaoMercadoDeTrabalho getSituacaoMercadoDeTrabalho() {
        return situacaoMercadoDeTrabalho;
    }

    public List<String> getOcupacoes() {
        return ocupacoes;
    }

    public Boolean isInfoOrientacao() {
        return infoOrientacao;
    }

    public OrientacoesSexuais getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public Boolean isInfoIdentidadeGenero() {
        return infoIdentidadeGenero;
    }

    public IdentidadesGeneros getIdentidadeGenero() {
        return identidadeGenero;
    }

    public Boolean isInfoDeficiencia() {
        return infoDeficiencia;
    }

    public Deficiencias getDeficiencia() {
        return deficiencia;
    }

    public Boolean isPlanoSaude() {
        return planoSaude;
    }

    public Boolean isComunidadeTradicional() {
        return comunidadeTradicional;
    }

    public Boolean isMenorQueDoisAnos() {
        return menorQueDoisAnos;
    }

    public Boolean isHipertensaoArterialSistemica() {
        return hipertensaoArterialSistemica;
    }

    public Boolean isDiabetes() {
        return diabetes;
    }

    public Boolean isHanseniase() {
        return hanseniase;
    }

    public Boolean isTuberculose() {
        return tuberculose;
    }

    public Boolean isDoencaMental() {
        return transtornoMental;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTemWhatsapp(Boolean temWhatsapp) {
        this.temWhatsapp = temWhatsapp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public void setRaca(Racas raca) {
        this.raca = raca;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public void setNacionalidade(TiposNacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public void setGrauDeInstrucao(String grauDeInstrucao) {
        this.grauDeInstrucao = grauDeInstrucao;
    }

    public void setSituacaoMercadoDeTrabalho(SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho) {
        this.situacaoMercadoDeTrabalho = situacaoMercadoDeTrabalho;
    }

    public void setOcupacoes(List<String> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public void setInfoOrientacao(Boolean infoOrientacao) {
        this.infoOrientacao = infoOrientacao;
    }

    public void setOrientacaoSexual(OrientacoesSexuais orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public void setInfoIdentidadeGenero(Boolean infoIdentidadeGenero) {
        this.infoIdentidadeGenero = infoIdentidadeGenero;
    }

    public void setIdentidadeGenero(IdentidadesGeneros identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public void setInfoDeficiencia(Boolean infoDeficiencia) {
        this.infoDeficiencia = infoDeficiencia;
    }

    public void setDeficiencia(Deficiencias deficiencia) {
        this.deficiencia = deficiencia;
    }

    public void setPlanoSaude(Boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setComunidadeTradicional(Boolean comunidadeTradicional) {
        this.comunidadeTradicional = comunidadeTradicional;
    }

    public void setMenorQueDoisAnos(Boolean menorQueDoisAnos) {
        this.menorQueDoisAnos = menorQueDoisAnos;
    }

    public void setHipertensaoArterialSistemica(Boolean hipertensaoArterialSistemica) {
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public void setHanseniase(Boolean hanseniase) {
        this.hanseniase = hanseniase;
    }

    public void setTuberculose(Boolean tuberculose) {
        this.tuberculose = tuberculose;
    }

    public void setTranstornoMental(Boolean transtornoMental) {
        this.transtornoMental = transtornoMental;
    }

    public void setPuerperio(Boolean puerperio) {
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

}
