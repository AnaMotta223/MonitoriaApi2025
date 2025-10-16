package org.serratec.exercicios_aula06.controller;

import java.util.List;

import org.serratec.exercicios_aula06.domain.Endereco;
import org.serratec.exercicios_aula06.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
	}

	@GetMapping
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
}