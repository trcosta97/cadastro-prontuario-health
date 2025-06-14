package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.agendamento.Agendamento;
import com.telemedicina.pre_cadastro.domain.agendamento.StatusAgendamento;
import com.telemedicina.pre_cadastro.domain.dto.AgendamentoRequestDTO;
import com.telemedicina.pre_cadastro.repository.AgendamentoRepository;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import com.telemedicina.pre_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Agendamento save(AgendamentoRequestDTO data) {

        var paciente = pacienteRepository.findByCpf(data.cpfPaciente());
        if (paciente == null) {
            throw new RuntimeException("Paciente não encontrado");
        }
        var medico = usuarioRepository.findByCpf(data.cpfMedico());
        if (medico == null) {
            throw new RuntimeException("Médico não encontrado");
        }


        var agendamento = new Agendamento(data);
        agendamento.setPaciente(paciente.get());
        agendamento.setMedico(medico);
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> getByPacienteCpf(String cpf) {
        return agendamentoRepository.findByPacienteCpf(cpf);
    }

    public List<Agendamento> getByMedicoCpf(String cpf) {
        return agendamentoRepository.findByMedicoCpf(cpf);
    }

    public List<Agendamento> getAll() {
        return agendamentoRepository.findAll();
    }

    public Agendamento cancelarAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        agendamento.setStatusAgendamento(StatusAgendamento.CANCELADO);
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento confirmarAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        agendamento.setStatusAgendamento(StatusAgendamento.CONFIRMADO);
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento naoCompareceu(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        agendamento.setStatusAgendamento(StatusAgendamento.NAO_COMPARECEU);
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento agendamentoRealizado(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        agendamento.setStatusAgendamento(StatusAgendamento.REALIZADO);
        return agendamentoRepository.save(agendamento);
    }
}
