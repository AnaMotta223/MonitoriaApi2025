package org.serratec.aula09.dto;

import org.serratec.aula09.domain.Participante;

public class InscricaoParticipanteResponseDTO {
	private Long idParticipante;
	private String nome;
	
	public InscricaoParticipanteResponseDTO() {
	}

	public InscricaoParticipanteResponseDTO(Participante participante) {
		this.idParticipante = participante.getId();
		this.nome = participante.getNome();
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
