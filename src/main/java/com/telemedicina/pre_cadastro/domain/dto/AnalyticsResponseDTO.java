package com.telemedicina.pre_cadastro.domain.dto;

public class AnalyticsResponseDTO {
    private Long totalAgendamentos;
    private Long totalProntuarios;

    public AnalyticsResponseDTO() {
    }

    public AnalyticsResponseDTO(Long totalAgendamentos, Long totalProntuarios) {
        this.totalAgendamentos = totalAgendamentos;
        this.totalProntuarios = totalProntuarios;
    }

    public Long getTotalAgendamentos() {
        return totalAgendamentos;
    }

    public void setTotalAgendamentos(Long totalAgendamentos) {
        this.totalAgendamentos = totalAgendamentos;
    }

    public Long getTotalProntuarios() {
        return totalProntuarios;
    }

    public void setTotalProntuarios(Long totalProntuarios) {
        this.totalProntuarios = totalProntuarios;
    }
}
