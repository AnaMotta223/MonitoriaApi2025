package org.serratec.aula09.controller;

import java.util.List;

import org.serratec.aula09.domain.Palestra;
import org.serratec.aula09.dto.PalestraResponseDTO;
import org.serratec.aula09.service.PalestraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/palestras")
public class PalestraController {

    private final PalestraService palestraService;

    public PalestraController(PalestraService palestraService) {
        this.palestraService = palestraService;
    }

    @PostMapping
    public ResponseEntity<Palestra> criar(@Valid @RequestBody Palestra palestra) {
        Palestra resposta = palestraService.criar(palestra);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<PalestraResponseDTO>> listar() {
        return ResponseEntity.ok(palestraService.listarTodas());
    }
}