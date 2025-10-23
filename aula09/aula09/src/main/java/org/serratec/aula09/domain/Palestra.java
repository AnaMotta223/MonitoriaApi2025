package org.serratec.aula09.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Palestra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Título é obrigatório")
	@Size(min = 3, max = 150, message = "Título deve ter entre {min} e {max} caracteres")
	private String titulo;

	@NotBlank(message = "Palestrante é obrigatório")
	@Size(min = 3, max = 100)
	private String palestrante;

	@OneToMany(mappedBy = "id.palestra", cascade = CascadeType.ALL)
	private List<Inscricao> inscricoes = new ArrayList<>();

	public Palestra() {
	}

	public Palestra(Long id, String titulo, String palestrante, List<Inscricao> inscricoes) {
		this.id = id;
		this.titulo = titulo;
		this.palestrante = palestrante;
		this.inscricoes = inscricoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
