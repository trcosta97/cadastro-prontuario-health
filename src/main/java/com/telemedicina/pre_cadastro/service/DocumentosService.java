package com.telemedicina.pre_cadastro.service;

import com.telemedicina.pre_cadastro.domain.documentos.Documentos;
import com.telemedicina.pre_cadastro.domain.dto.DocumentosRequestDTO;
import com.telemedicina.pre_cadastro.domain.paciente.Paciente;
import com.telemedicina.pre_cadastro.repository.DocumentosRepository;
import com.telemedicina.pre_cadastro.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentosService {

    @Autowired
    private DocumentosRepository documentosRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Documentos salvarDocumentos(DocumentosRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Documentos documento = new Documentos();
        documento.setPaciente(paciente);
        documento.setTitulo(dto.titulo());

        return documentosRepository.save(documento);
    }
}
