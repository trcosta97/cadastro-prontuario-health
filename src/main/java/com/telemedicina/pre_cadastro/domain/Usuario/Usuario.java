package com.telemedicina.pre_cadastro.domain.Usuario;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telemedicina.pre_cadastro.domain.Dto.LoginRequest;
import com.telemedicina.pre_cadastro.domain.Dto.PreSaveUsuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Endereco;
import com.telemedicina.pre_cadastro.domain.Usuario.Enums.*;
import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_users")
public class Usuario {
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
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column(name="enabled ")
    private boolean ativo;
    @Column(name="dateCreated ")
    private LocalDateTime dataRegistro;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Roles> roles;
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

    public Usuario() {
    }

    public Usuario(Long id, String cpf, String nomeCompleto, LocalDate dataNascimento, String sexo, String celular, boolean temWhatsapp, String email, String password, Endereco endereco, boolean ativo, LocalDateTime dataRegistro, Set<Roles> roles, String cns, Racas raca, String nomeSocial, TiposNacionalidade nacionalidade, String nomeMae, String nomePai, String pisPasep, String grauDeInstrução, SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho, List<String> ocupacoes, boolean infoOrientacao, OrientacoesSexuais orientacaoSexual, boolean infoIdentidadeGenero, IdentidadesGeneros identidadeGenero, boolean infoDeficiencia, Deficiencias deficiencia, boolean planoSaude, boolean comunidadeTradicional, boolean menorQueDoisAnos, boolean hipertensaoArterialSistemica, boolean diabetes, boolean hanseniase, boolean tuberculose, boolean doencaMental) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.celular = celular;
        this.temWhatsapp = temWhatsapp;
        this.email = email;
        this.password = password;
        this.endereco = endereco;
        this.ativo = ativo;
        this.dataRegistro = dataRegistro;
        this.roles = roles;
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

    public Usuario(PreSaveUsuarioRequestDTO data) {
        this.nomeCompleto = data.nomeCompleto();
        this.cpf = data.cpf();
        this.dataNascimento = getDataNascimento();
        this.sexo = data.sexo();
        this.celular = data.sexo();
        this.email = data.email();
        this.password = data.senha();
        this.ativo = true;
        this.dataRegistro = LocalDateTime.now();
        this.adicionarEndereco(new Endereco(data.endereco()));
    }

    public void adicionarEndereco(Endereco endereco) {
        this.endereco = endereco;
        endereco.setUsuario(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isTemWhatsapp() {
        return temWhatsapp;
    }

    public void setTemWhatsapp(boolean temWhatsapp) {
        this.temWhatsapp = temWhatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRole(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public Racas getRaca() {
        return raca;
    }

    public void setRaca(Racas raca) {
        this.raca = raca;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public TiposNacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(TiposNacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getGrauDeInstrução() {
        return grauDeInstrução;
    }

    public void setGrauDeInstrução(String grauDeInstrução) {
        this.grauDeInstrução = grauDeInstrução;
    }

    public SituacaoMercadoDeTrabalho getSituacaoMercadoDeTrabalho() {
        return situacaoMercadoDeTrabalho;
    }

    public void setSituacaoMercadoDeTrabalho(SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho) {
        this.situacaoMercadoDeTrabalho = situacaoMercadoDeTrabalho;
    }

    public List<String> getOcupacoes() {
        return ocupacoes;
    }

    public void setOcupacoes(List<String> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public boolean isInfoOrientacao() {
        return infoOrientacao;
    }

    public void setInfoOrientacao(boolean infoOrientacao) {
        this.infoOrientacao = infoOrientacao;
    }

    public OrientacoesSexuais getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(OrientacoesSexuais orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public boolean isInfoIdentidadeGenero() {
        return infoIdentidadeGenero;
    }

    public void setInfoIdentidadeGenero(boolean infoIdentidadeGenero) {
        this.infoIdentidadeGenero = infoIdentidadeGenero;
    }

    public IdentidadesGeneros getIdentidadeGenero() {
        return identidadeGenero;
    }

    public void setIdentidadeGenero(IdentidadesGeneros identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public boolean isInfoDeficiencia() {
        return infoDeficiencia;
    }

    public void setInfoDeficiencia(boolean infoDeficiencia) {
        this.infoDeficiencia = infoDeficiencia;
    }

    public Deficiencias getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Deficiencias deficiencia) {
        this.deficiencia = deficiencia;
    }

    public boolean isPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public boolean isComunidadeTradicional() {
        return comunidadeTradicional;
    }

    public void setComunidadeTradicional(boolean comunidadeTradicional) {
        this.comunidadeTradicional = comunidadeTradicional;
    }

    public boolean isMenorQueDoisAnos() {
        return menorQueDoisAnos;
    }

    public void setMenorQueDoisAnos(boolean menorQueDoisAnos) {
        this.menorQueDoisAnos = menorQueDoisAnos;
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

    public boolean isHanseniase() {
        return hanseniase;
    }

    public void setHanseniase(boolean hanseniase) {
        this.hanseniase = hanseniase;
    }

    public boolean isTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(boolean tuberculose) {
        this.tuberculose = tuberculose;
    }

    public boolean isDoencaMental() {
        return doencaMental;
    }

    public void setDoencaMental(boolean doencaMental) {
        this.doencaMental = doencaMental;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}
