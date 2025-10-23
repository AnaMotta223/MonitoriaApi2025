package org.serratec.aula09.controller;

import java.util.List;

import org.serratec.aula09.dto.ParticipanteRequestDTO;
import org.serratec.aula09.dto.ParticipanteResponseDTO;
import org.serratec.aula09.service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> criar(@Valid @RequestBody ParticipanteRequestDTO participante){
    	ParticipanteResponseDTO resposta = participanteService.criarParticipante(participante);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ParticipanteResponseDTO>> listarTodos() {
        List<ParticipanteResponseDTO> participantes = participanteService.listarTodos();
        return ResponseEntity.ok(participantes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> buscar(@PathVariable Long id){
    	ParticipanteResponseDTO participante = participanteService.buscarPorId(id);
    	return ResponseEntity.ok(participante);
    }
}
