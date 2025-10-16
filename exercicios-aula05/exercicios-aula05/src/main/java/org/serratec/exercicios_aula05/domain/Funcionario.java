package org.serratec.exercicios_aula05.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NotBlank(message = "Preencha o campo nome")
	@Size(max = 60, message = "O nome deve ter até 60 caracteres")
	protected String nome;
	
	@CPF(message = "Insira um cpf válido")
	@NotBlank(message = "Preencha o campo CPF")
	protected String cpf;
	
	@NotBlank(message = "Preencha o campo turno")
	protected String turno;
	
	@NotNull(message = "Preencha o campo salário")
	@Positive(message = "O salário deve ser um valor positivo")
	protected double salario;

	public Funcionario() {
		
	}
	
	public Funcionario(Long id, String nome,
			 String cpf,
			 String turno,
			double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.turno = turno;
		this.salario = salario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
