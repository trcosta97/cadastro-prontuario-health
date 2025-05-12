package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.dto.ProntuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Prontuario;
import com.telemedicina.pre_cadastro.domain.usuario.Usuario;
import com.telemedicina.pre_cadastro.repository.ProntuarioRepository;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Prontuario> listarProntuariosPorPaciente(Long pacienteId) {
        return prontuarioRepository.findByPacienteIdAndAtivoTrue(pacienteId);
    }

    public List<Prontuario> listarProntuariosPorMedico(Long medicoId) {
        return prontuarioRepository.findByMedicoIdAndAtivoTrue(medicoId);
    }

    public List<Prontuario> listarProntuariosPorMedicoEData(Long medicoId, LocalDateTime inicio, LocalDateTime fim) {
        return prontuarioRepository.findByMedicoIdAndDataAtendimentoBetween(medicoId, inicio, fim);
    }

    public Prontuario buscarProntuario(Long id) {
        return prontuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Prontuário não encontrado com ID: " + id));
    }

    public List<Prontuario> getAll() {
        return prontuarioRepository.findAll();
    }

    @Transactional
    public Prontuario criarProntuario(Prontuario prontuario) {
        var paciente = prontuario.getPaciente();
        if (paciente != null){
            prontuario.setDiabetes(Boolean.TRUE.equals(paciente.isDiabetes()));
            prontuario.setHanseniase(Boolean.TRUE.equals(paciente.isHanseniase()));
            prontuario.setSaudeMental(Boolean.TRUE.equals(paciente.isTranstornoMental()));
            prontuario.setHipertensaoArterialSistemica(Boolean.TRUE.equals(paciente.isHipertensaoArterialSistemica()));
            prontuario.setGestante(Boolean.TRUE.equals(paciente.getGestante()));
            prontuario.setPuperpera(Boolean.TRUE.equals(paciente.getPuerperio()));
        }

        return prontuarioRepository.save(prontuario);
    }

    @Transactional
    public Prontuario atualizarProntuario(Long id, ProntuarioRequestDTO dto) {
        Prontuario prontuario = buscarProntuario(id);

        prontuario.setSubjetivo(dto.subjetivo());
        prontuario.setObjetivo(dto.objetivo());
        prontuario.setAvaliacao(dto.avaliacao());
        prontuario.setPlano(dto.plano());

        prontuario.setHipertensaoArterialSistemica(dto.hipertensaoArterialSistemica());
        prontuario.setDiabetes(dto.diabetes());
        prontuario.setTuberculose(dto.tuberculose());
        prontuario.setHanseniase(dto.hanseniase());

        // Atualiza também no perfil do paciente
        Paciente paciente = prontuario.getPaciente();
        paciente.setHipertensaoArterialSistemica(dto.hipertensaoArterialSistemica());
        paciente.setDiabetes(dto.diabetes());
        paciente.setTuberculose(dto.tuberculose());
        paciente.setHanseniase(dto.hanseniase());

        pacienteRepository.save(paciente);
        return prontuarioRepository.save(prontuario);
    }

    @Transactional
    public void desativarProntuario(Long id) {
        Prontuario prontuario = buscarProntuario(id);
        prontuario.setAtivo(false);
        prontuarioRepository.save(prontuario);
    }


}