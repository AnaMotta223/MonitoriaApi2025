package org.serratec.aula09.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParticipanteRequestDTO {

	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 100)
	private String nome;

	@NotBlank(message = "Email obrigatório")
	@Email(message = "Informe um email válido")
	private String email;

	@NotBlank(message = "Senha obrigatória")
	@Size(min = 6, message = "Senha deve ter pelo menos {min} caracteres")
	private String senha;

	@NotBlank(message = "Confirmação de senha obrigatória")
	private String confirmaSenha;

	public ParticipanteRequestDTO() {
	}

	public ParticipanteRequestDTO(String nome, String email, String senha, String confirmaSenha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
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

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
