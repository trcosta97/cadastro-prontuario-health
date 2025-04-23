package com.telemedicina.pre_cadastro.domain.Paciente;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telemedicina.pre_cadastro.domain.Dto.PreSavePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.domain.Usuario.Enums.*;
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
    private boolean temWhatsapp;
    private String email;
    @Column(name = "password")
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column(name="enabled ")
    private boolean ativo;
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
    private String grauDeInstrução;
    @Enumerated(EnumType.STRING)
    @Column(name=" employmentStatus")
    private SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho;
    @Column(name=" ocupations")
    private List<String> ocupacoes;
    // Deu ou não info sobre orientação sexual
    @Column(name=" hasSexualOrientation")
    private boolean infoOrientacao;
    @Enumerated(EnumType.STRING)
    @Column(name=" sexualOrientation")
    private OrientacoesSexuais orientacaoSexual;
    @Column(name=" hasGenderIdentity")
    private boolean infoIdentidadeGenero;
    @Enumerated(EnumType.STRING)
    @Column(name=" genderIdentity")
    private IdentidadesGeneros identidadeGenero;
    @Column(name=" hasDisability")
    private boolean infoDeficiencia;
    @Enumerated(EnumType.STRING)
    @Column(name=" disability")
    private Deficiencias deficiencia;
    @Column(name=" hasHealthPlan")
    private boolean planoSaude;
    //É membro de povo ou comunidade tradicional ou Campo, Floresta e Águas?
    @Column(name=" isTraditionalCommunity")
    private boolean comunidadeTradicional;
    @Column(name=" isUnderTwoYearsOld")
    private boolean menorQueDoisAnos;
    @Column(name=" hasSystemicHypertension")
    private boolean hipertensaoArterialSistemica;
    @Column(name=" hasDiabetes")
    private boolean diabetes;
    @Column(name=" hasLeprosy")
    private boolean hanseniase;
    @Column(name=" hasTuberculosis")
    private boolean tuberculose;
    // Teve diagnóstico de algum problema de saúde mental por algum profissional de saúde?  (Sim/Não)
    @PrimaryKeyJoinColumn(name=" hasMentalIllness")
    private boolean doencaMental;

    public Paciente(Long id, String cpf, String nomeCompleto, LocalDate dataNascimento, String sexo, String celular, boolean temWhatsapp, String email, String senha, Endereco endereco, boolean ativo, LocalDateTime dataRegistro, String cns, Racas raca, String nomeSocial, TiposNacionalidade nacionalidade, String nomeMae, String nomePai, String pisPasep, String grauDeInstrução, SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho, List<String> ocupacoes, boolean infoOrientacao, OrientacoesSexuais orientacaoSexual, boolean infoIdentidadeGenero, IdentidadesGeneros identidadeGenero, boolean infoDeficiencia, Deficiencias deficiencia, boolean planoSaude, boolean comunidadeTradicional, boolean menorQueDoisAnos, boolean hipertensaoArterialSistemica, boolean diabetes, boolean hanseniase, boolean tuberculose, boolean doencaMental) {
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
        this.grauDeInstrução = grauDeInstrução;
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
        this.doencaMental = doencaMental;
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

    public boolean isTemWhatsapp() {
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

    public boolean isAtivo() {
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

    public String getGrauDeInstrução() {
        return grauDeInstrução;
    }

    public SituacaoMercadoDeTrabalho getSituacaoMercadoDeTrabalho() {
        return situacaoMercadoDeTrabalho;
    }

    public List<String> getOcupacoes() {
        return ocupacoes;
    }

    public boolean isInfoOrientacao() {
        return infoOrientacao;
    }

    public OrientacoesSexuais getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public boolean isInfoIdentidadeGenero() {
        return infoIdentidadeGenero;
    }

    public IdentidadesGeneros getIdentidadeGenero() {
        return identidadeGenero;
    }

    public boolean isInfoDeficiencia() {
        return infoDeficiencia;
    }

    public Deficiencias getDeficiencia() {
        return deficiencia;
    }

    public boolean isPlanoSaude() {
        return planoSaude;
    }

    public boolean isComunidadeTradicional() {
        return comunidadeTradicional;
    }

    public boolean isMenorQueDoisAnos() {
        return menorQueDoisAnos;
    }

    public boolean isHipertensaoArterialSistemica() {
        return hipertensaoArterialSistemica;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public boolean isHanseniase() {
        return hanseniase;
    }

    public boolean isTuberculose() {
        return tuberculose;
    }

    public boolean isDoencaMental() {
        return doencaMental;
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

    public void setTemWhatsapp(boolean temWhatsapp) {
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

    public void setAtivo(boolean ativo) {
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

    public void setGrauDeInstrução(String grauDeInstrução) {
        this.grauDeInstrução = grauDeInstrução;
    }

    public void setSituacaoMercadoDeTrabalho(SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho) {
        this.situacaoMercadoDeTrabalho = situacaoMercadoDeTrabalho;
    }

    public void setOcupacoes(List<String> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public void setInfoOrientacao(boolean infoOrientacao) {
        this.infoOrientacao = infoOrientacao;
    }

    public void setOrientacaoSexual(OrientacoesSexuais orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public void setInfoIdentidadeGenero(boolean infoIdentidadeGenero) {
        this.infoIdentidadeGenero = infoIdentidadeGenero;
    }

    public void setIdentidadeGenero(IdentidadesGeneros identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public void setInfoDeficiencia(boolean infoDeficiencia) {
        this.infoDeficiencia = infoDeficiencia;
    }

    public void setDeficiencia(Deficiencias deficiencia) {
        this.deficiencia = deficiencia;
    }

    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setComunidadeTradicional(boolean comunidadeTradicional) {
        this.comunidadeTradicional = comunidadeTradicional;
    }

    public void setMenorQueDoisAnos(boolean menorQueDoisAnos) {
        this.menorQueDoisAnos = menorQueDoisAnos;
    }

    public void setHipertensaoArterialSistemica(boolean hipertensaoArterialSistemica) {
        this.hipertensaoArterialSistemica = hipertensaoArterialSistemica;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public void setHanseniase(boolean hanseniase) {
        this.hanseniase = hanseniase;
    }

    public void setTuberculose(boolean tuberculose) {
        this.tuberculose = tuberculose;
    }

    public void setDoencaMental(boolean doencaMental) {
        this.doencaMental = doencaMental;
    }
}
