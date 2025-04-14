package com.telemedicina.pre_cadastro.domain.Dto;

import com.telemedicina.pre_cadastro.domain.Usuario.*;

import java.util.List;

public record UpdateUsuarioRequestDTO(
        String cns,
        Racas raca,
        String nomeSocial,
        boolean temWhatsapp,
        TiposNacionalidade nacionalidade,
        String nomeMae,
        String nomePai,
        String pisPasep,
        String grauDeInstrucao,
        SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho,
        List<String> ocupacoes,
        boolean infoOrientacao,
        OrientacoesSexuais orientacaoSexual,
        boolean infoIdentidadeGenero,
        IdentidadesGeneros identidadeGenero,
        boolean infoDeficiencia,
        Deficiencias deficiencia,
        boolean planoSaude,
        boolean comunidadeTradicional,
        boolean menorQueDoisAnos,
        boolean hipertensaoArterialSistemica,
        boolean diabetes,
        boolean hanseniase,
        boolean tuberculose,
        boolean doencaMental
) {}
