package org.serratec.exercicios_aula02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos/v2")
public class VeiculoControllerV2 {
	private final List<Veiculo> veiculos = new ArrayList<>();

	@PostMapping
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		veiculos.add(veiculo);
		return veiculo;
	}

	@GetMapping
	public List<Veiculo> listar() {
		return veiculos;
	}

	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
//		Usando expressao lambda:
//		return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst()
//				.orElse(null);
		
		for (int i=0; i<veiculos.size(); i++) {
			if (veiculos.get(i).getId().equals(id)) {
				return veiculos.get(i);
			}
		}
		return null;
	}

	@PutMapping("/{id}")
	public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
//		Usando expressao lambda:
//		Veiculo veiculoNovo = veiculos.stream().filter(v -> v.getId().equals(id)).findFirst().get();
//		veiculoNovo.setMarca(veiculo.getMarca());
//		veiculoNovo.setModelo(veiculo.getModelo());
//		return veiculoNovo;
		
		for (Veiculo v : veiculos) {
			if (v.getId().equals(id)) {
				v.setMarca(veiculo.getMarca());
				v.setModelo(veiculo.getModelo());
				return v;
			}
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id) {
		boolean removido = veiculos.removeIf(v -> v.getId().equals(id));
		if (removido) {
			return "Veículo removido com sucesso";
		}
		return null;
	}
}
