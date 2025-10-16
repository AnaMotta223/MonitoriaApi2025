package org.serratec.exercicios_aula05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicios_aula05.domain.Gerente;
import org.serratec.exercicios_aula05.repository.GerenteRepository;
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
@RequestMapping("/gerentes")
public class GerenteController {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	@GetMapping
	public List<Gerente> listar(){
		return gerenteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gerente> buscar(@PathVariable Long id){
		Optional<Gerente> gerente = gerenteRepository.findById(id);
		if(gerente.isPresent()) {
			return ResponseEntity.ok(gerente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gerente criar(@Valid @RequestBody Gerente Gerente) {
        return gerenteRepository.save(Gerente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> atualizar(@PathVariable Long id, @Valid @RequestBody Gerente Gerente) {
        if (gerenteRepository.existsById(id)) {
            Gerente.setId(id);
            return ResponseEntity.ok(gerenteRepository.save(Gerente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (gerenteRepository.existsById(id)) {
            gerenteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}