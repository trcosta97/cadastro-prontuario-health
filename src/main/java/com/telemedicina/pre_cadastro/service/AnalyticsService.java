package com.telemedicina.pre_cadastro.service;

;
import com.telemedicina.pre_cadastro.domain.dto.AnalyticsResponseDTO;
import com.telemedicina.pre_cadastro.repository.AgendamentoRepository;
import com.telemedicina.pre_cadastro.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnalyticsService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    /**
     * Busca a contagem de agendamentos e prontuários em um intervalo de tempo
     *
     * @param dataInicio Data e hora inicial do intervalo
     * @param dataFim Data e hora final do intervalo
     * @return DTO com a contagem de agendamentos e prontuários
     */
    public AnalyticsResponseDTO getCountByDateRange(LocalDateTime dataInicio, LocalDateTime dataFim) {
        Long totalAgendamentos = agendamentoRepository.countByDataCriacaoBetween(dataInicio, dataFim);
        Long totalProntuarios = prontuarioRepository.countByDataCriacaoBetween(dataInicio, dataFim);

        return new AnalyticsResponseDTO(totalAgendamentos, totalProntuarios);
    }
}