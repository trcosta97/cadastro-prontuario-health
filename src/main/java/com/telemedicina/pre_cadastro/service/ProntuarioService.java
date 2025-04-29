package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.Dto.ProntuarioRequestDTO;
import com.telemedicina.pre_cadastro.domain.Paciente.Paciente;
import com.telemedicina.pre_cadastro.domain.Prontuario;
import com.telemedicina.pre_cadastro.domain.Usuario.Usuario;
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
    public Prontuario criarProntuario(Long medicoId, Long pacienteId, String subjetivo, String objetivo, String avaliacao, String plano) {
        Optional<Usuario> medicoOpt = usuarioRepository.findById(medicoId);
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteId);

        if (medicoOpt.isEmpty() || pacienteOpt.isEmpty()) {
            throw new IllegalArgumentException("Médico ou paciente não encontrado.");
        }

        Usuario medico = medicoOpt.get();
        Paciente paciente = pacienteOpt.get();

        Prontuario prontuario = new Prontuario();
        prontuario.setMedico(medico);
        prontuario.setPaciente(paciente);
        prontuario.setDataAtendimento(LocalDateTime.now());
        prontuario.setSubjetivo(subjetivo);
        prontuario.setObjetivo(objetivo);
        prontuario.setAvaliacao(avaliacao);
        prontuario.setPlano(plano);
        prontuario.setDataCriacao(LocalDateTime.now());
        prontuario.setAtivo(true);  // Se for necessário, ajuste para ser verdadeiro por padrão

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