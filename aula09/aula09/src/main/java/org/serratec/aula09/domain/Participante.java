package org.serratec.aula09.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 100, message = "Nome deve ter entre {min} e {max} caracteres")
	@Column(nullable = false, length = 100)
	private String nome;

	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Informe um email válido")
	@Column(nullable = false, unique = true, length = 150)
	private String email;

	@NotBlank(message = "Senha é obrigatória")
	private String senha;

	@OneToMany(mappedBy = "id.participante", cascade = CascadeType.ALL)
	private List<Inscricao> inscricoes = new ArrayList<>();

	public Participante() {
	}

	public Participante(Long id, String nome, String email, String senha, List<Inscricao> inscricoes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.inscricoes = inscricoes;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}