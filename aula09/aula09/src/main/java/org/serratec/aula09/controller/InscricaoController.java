package org.serratec.aula09.controller;

import org.serratec.aula09.dto.InscricaoRequestDTO;
import org.serratec.aula09.service.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<InscricaoRequestDTO> inscrever(@Valid @RequestBody InscricaoRequestDTO inscricaoRequestDTO) {
        InscricaoRequestDTO inscricao = inscricaoService.inscrever(inscricaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }
}