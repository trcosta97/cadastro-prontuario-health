package com.telemedicina.pre_cadastro.domain.Dto;

import com.telemedicina.pre_cadastro.domain.Usuario.Enums.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdateUsuarioRequestDTO(

        @Pattern(regexp = "\\d{15}", message = "O CNS deve conter 15 dígitos numéricos")
        String cns,
        Racas raca,
        @Size(max = 100, message = "O nome social deve ter no máximo 100 caracteres")
        String nomeSocial,
        boolean temWhatsapp,
        TiposNacionalidade nacionalidade,
        @Size(max = 100, message = "O nome da mãe deve ter no máximo 100 caracteres")
        String nomeMae,
        @Size(max = 100, message = "O nome do pai deve ter no máximo 100 caracteres")
        String nomePai,
        @Pattern(regexp = "\\d{11}", message = "O PIS/PASEP deve conter 11 dígitos numéricos")
        String pisPasep,
        @Size(max = 50, message = "O grau de instrução deve ter no máximo 50 caracteres")
        String grauDeInstrucao,
        SituacaoMercadoDeTrabalho situacaoMercadoDeTrabalho,
        @Size(max = 5, message = "É possível selecionar até 5 ocupações")
        List<@Size(max = 100, message = "Cada ocupação pode ter no máximo 100 caracteres") String> ocupacoes,
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
