package com.telemedicina.pre_cadastro.domain.dto;

import com.telemedicina.pre_cadastro.domain.declaracao.MotivoDeclaracao;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public record DeclaracaoRequestDTO(Long pacienteId,
                                   Long usuarioId,
                                   LocalDateTime entrada,
                                   LocalDateTime saida,
                                   List<MotivoDeclaracao> motivos) { }
