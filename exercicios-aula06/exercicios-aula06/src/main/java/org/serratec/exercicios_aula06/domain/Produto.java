package org.serratec.exercicios_aula06.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o campo descricao")
	@Size(min = 3, max = 100, message = "O descricao deve ter entre {min} e {max} caracteres")
	@Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    
    @NotNull(message = "Preencha o campo valor")
    @Positive(message = "O valor deve ser positivo")
    @Column(name = "valor", nullable = false)
    private Double valor;

	public Produto() {
	}

	public Produto(Long id, String descricao, Double valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}