package org.serratec.exercicios_aula04.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicios_aula04.domain.Funcionario;
import org.serratec.exercicios_aula04.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id){
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario criar(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
		if (funcionarioRepository.existsById(id)) {
			funcionario.setId(id);
	        return ResponseEntity.ok(funcionarioRepository.save(funcionario));
	    }
	    return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (funcionarioRepository.existsById(id)) {
			funcionarioRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.notFound().build();
	}
}
