package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.atestado.Atestado;
import com.telemedicina.pre_cadastro.domain.dto.AtestadoResponseDTO;
import com.telemedicina.pre_cadastro.repository.AtestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtestadoService {

    @Autowired
    private AtestadoRepository atestadoRepository;

    // Conversão de entidade para DTO de resposta
    public AtestadoResponseDTO toResponseDTO(Atestado atestado) {
        return new AtestadoResponseDTO(
                atestado.getId(),
                atestado.getPaciente() != null ? atestado.getPaciente().getId() : null,
                atestado.getDataInicio(),
                atestado.getDuracaoDias(),
                atestado.getPaciente() != null ? atestado.getPaciente().getNomeCompleto() : null
        );
    }

    // Métodos que retornam listas de DTOs
    public List<AtestadoResponseDTO> getDTOsByPacienteCpf(String cpf) {
        return atestadoRepository.findByPacienteCpf(cpf)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<AtestadoResponseDTO> getDTOsByMedicoCpf(String cpf) {
        return atestadoRepository.findByUsuarioCpf(cpf)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<AtestadoResponseDTO> getDTOById(Long id) {
        return atestadoRepository.findById(id).map(this::toResponseDTO);
    }

    public List<AtestadoResponseDTO> getAllDTOs() {
        return atestadoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Métodos que retornam entidades (caso precise)
    public List<Atestado> getByPacienteCpf(String cpf) {
        return atestadoRepository.findByPacienteCpf(cpf);
    }

    public List<Atestado> getByMedicoCpf(String cpf) {
        return atestadoRepository.findByUsuarioCpf(cpf);
    }

    public Optional<Atestado> getById(Long id) {
        return atestadoRepository.findById(id);
    }

    public List<Atestado> getAll() {
        return atestadoRepository.findAll();
    }

    public Atestado save(Atestado atestado) {
        return atestadoRepository.save(atestado);
    }
}
