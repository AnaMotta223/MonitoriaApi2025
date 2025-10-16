package org.serratec.exercicios_aula05.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Gerente extends Funcionario {

	@NotBlank(message = "Preencha o campo setor")
	private String setor;

	public Gerente() {}

	public Gerente(Long id, String nome, String cpf, String turno, Double salario, String setor) {
		super(id, nome, cpf, turno, salario);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
}
