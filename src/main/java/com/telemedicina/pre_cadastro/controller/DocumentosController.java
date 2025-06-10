package com.telemedicina.pre_cadastro.controller;

import com.telemedicina.pre_cadastro.domain.documentos.Documentos;
import com.telemedicina.pre_cadastro.domain.dto.DocumentosRequestDTO;
import com.telemedicina.pre_cadastro.service.DocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentos")
public class DocumentosController {

    @Autowired
    private DocumentosService documentosService;

    @PostMapping
    public Documentos salvarDocumento(@RequestBody DocumentosRequestDTO documentoDTO) {
        return documentosService.salvarDocumentos(documentoDTO);
    }
}
