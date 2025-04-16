package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.Dto.UpdateUsuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Usuario.Enums.Roles;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;



    public Usuario save(Usuario usuario){
        var newUsuario = repository.save(usuario);
        return repository.save(usuario);
    }

    public Usuario get(Long id){
        Optional<Usuario> optionalUsuario = repository.findById(id);
        return optionalUsuario.orElse(null);
    }


    public Iterable<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario update(Long id, UpdateUsuarioRequestDTO data) {
        var usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setCns(data.cns());
        usuario.setRaca(data.raca());
        usuario.setNomeSocial(data.nomeSocial());
        usuario.setNacionalidade(data.nacionalidade());
        usuario.setNomeMae(data.nomeMae());
        usuario.setNomePai(data.nomePai());
        usuario.setTemWhatsapp(data.temWhatsapp());
        usuario.setPisPasep(data.pisPasep());
        usuario.setGrauDeInstrução(data.grauDeInstrucao());
        usuario.setSituacaoMercadoDeTrabalho(data.situacaoMercadoDeTrabalho());
        usuario.setOcupacoes(data.ocupacoes());
        usuario.setInfoOrientacao(data.infoOrientacao());
        usuario.setOrientacaoSexual(data.orientacaoSexual());
        usuario.setInfoIdentidadeGenero(data.infoIdentidadeGenero());
        usuario.setIdentidadeGenero(data.identidadeGenero());
        usuario.setInfoDeficiencia(data.infoDeficiencia());
        usuario.setDeficiencia(data.deficiencia());
        usuario.setPlanoSaude(data.planoSaude());
        usuario.setComunidadeTradicional(data.comunidadeTradicional());
        usuario.setMenorQueDoisAnos(data.menorQueDoisAnos());
        usuario.setHipertensaoArterialSistemica(data.hipertensaoArterialSistemica());
        usuario.setDiabetes(data.diabetes());
        usuario.setHanseniase(data.hanseniase());
        usuario.setTuberculose(data.tuberculose());
        usuario.setDoencaMental(data.doencaMental());

        return repository.save(usuario);
    }

    public Usuario setRole(Long id, Set<Roles> roles) {
        var usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setRole(roles);
        return repository.save(usuario);
    }




}
