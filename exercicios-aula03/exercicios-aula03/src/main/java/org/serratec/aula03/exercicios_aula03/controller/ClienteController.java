package org.serratec.aula03.exercicios_aula03.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula03.exercicios_aula03.domain.Cliente;
import org.serratec.aula03.exercicios_aula03.repository.ClienteRepository;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

// Outra forma de injetar o repositório é pelo construtor:
//	private final ClienteRepository clienteRepository;
//
//	public ClienteController(ClienteRepository clienteRepository) {
//		this.clienteRepository = clienteRepository;
//	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
//	Forma mais condensada usando map:
//	 @GetMapping("/{id}")
//	 public ResponseEntity<Cliente> buscar(@PathVariable Long id){
//		 return clienteRepository.findById(id)
//	     .map(cliente -> ResponseEntity.ok(cliente))
//	     .orElse(ResponseEntity.notFound().build());
//	    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		if (clienteRepository.existsById(id)) {
			cliente.setId(id);
			return ResponseEntity.ok(clienteRepository.save(cliente));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}