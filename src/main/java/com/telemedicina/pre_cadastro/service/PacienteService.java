package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.dto.UpdatePacienteRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;



    public Paciente save(Paciente paciente){
        var newPaciente = repository.save(paciente);
        return repository.save(paciente);
    }

    public Paciente get(Long id){
        Optional<Paciente> optionalPaciente = repository.findById(id);
        return optionalPaciente.orElse(null);
    }


    public Iterable<Paciente> getAll(){
        return repository.findAll();
    }

    public Paciente update(Long id, UpdatePacienteRequestDTO data) {
        var paciente = repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setCns(data.cns());
        paciente.setRaca(data.raca());
        paciente.setNomeSocial(data.nomeSocial());
        paciente.setNacionalidade(data.nacionalidade());
        paciente.setNomeMae(data.nomeMae());
        paciente.setNomePai(data.nomePai());
        paciente.setTemWhatsapp(data.temWhatsapp());
        paciente.setPisPasep(data.pisPasep());
        paciente.setGrauDeInstrucao(data.grauDeInstrucao());
        paciente.setSituacaoMercadoDeTrabalho(data.situacaoMercadoDeTrabalho());
        paciente.setOcupacoes(data.ocupacoes());
        paciente.setInfoOrientacao(data.infoOrientacao());
        paciente.setOrientacaoSexual(data.orientacaoSexual());
        paciente.setInfoIdentidadeGenero(data.infoIdentidadeGenero());
        paciente.setIdentidadeGenero(data.identidadeGenero());
        paciente.setInfoDeficiencia(data.infoDeficiencia());
        paciente.setDeficiencia(data.deficiencia());
        paciente.setPlanoSaude(data.planoSaude());
        paciente.setComunidadeTradicional(data.comunidadeTradicional());
        paciente.setMenorQueDoisAnos(data.menorQueDoisAnos());
        paciente.setHipertensaoArterialSistemica(data.hipertensaoArterialSistemica());
        paciente.setDiabetes(data.diabetes());
        paciente.setHanseniase(data.hanseniase());
        paciente.setTuberculose(data.tuberculose());
        paciente.setTranstornoMental(data.transtornoMental());
        paciente.setPuerperio(data.puerperio());

        return repository.save(paciente);
    }


    public Paciente buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public List<Paciente> buscarTodosAtivos() {
        return repository.findAllByAtivoTrue()
                .orElseThrow(() -> new RuntimeException("Nenhum paciente ativo encontrado"));
    }

    public Paciente getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }



}
