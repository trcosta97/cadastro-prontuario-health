package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.dto.AnalyticsResponseDTO;
import com.telemedicina.pre_cadastro.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/analytics")
public class AnalyticsController {

    @Autowired
    AnalyticsService analyticsService;
    /**
     * Endpoint para retornar a contagem de agendamentos e prontuários em um intervalo de tempo específico
     * @param dataInicio Data de início do intervalo
     * @param dataFim Data de fim do intervalo
     * @return Contagem de agendamentos e prontuários no período
     */


    @GetMapping("/count")
    public ResponseEntity<AnalyticsResponseDTO> getCountByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {

        // Validar se a data inicial é anterior à data final
        if (dataInicio.isAfter(dataFim)) {
            return ResponseEntity.badRequest().build();
        }

        // Converter para LocalDateTime para incluir todo o dia final
        LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
        LocalDateTime dataFimDateTime = dataFim.plusDays(1).atStartOfDay();

        AnalyticsResponseDTO response = analyticsService.getCountByDateRange(dataInicioDateTime, dataFimDateTime);
        return ResponseEntity.ok(response);
    }
}
