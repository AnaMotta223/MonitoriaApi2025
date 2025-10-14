package org.serratec.exercicios_aula04.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long id;
	
	@Column(length = 100, nullable = false)
	@NotBlank(message = "Preencha o campo nome")
	@Size(min = 3, max = 100, message = "O nome deve ter de 3 a 100 caracteres")
	private String nome;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotBlank(message = "Preencha o campo CPF")
	@CPF(message = "O CPF deve ser válido")
	private String cpf;
	
	@Column(nullable = false)
	@NotNull(message = "Preencha o campo salário")
	@Positive(message = "O salário deve ter um valor positivo")
	private BigDecimal salario;
	
	@Column(name = "data_admissao", nullable = false)
	@PastOrPresent(message = "A data de admissão deve ser no passado ou no presente")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull(message = "A data de admissão é obrigatória")
	private LocalDate dataAdmissao;

	public Funcionario() {
	}

	public Funcionario(Long id,
			String nome,
			String cpf,
			BigDecimal salario,
			LocalDate dataAdmissao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
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

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
