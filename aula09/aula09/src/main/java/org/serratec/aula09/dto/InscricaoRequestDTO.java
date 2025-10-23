package org.serratec.aula09.dto;

import jakarta.validation.constraints.NotNull;

public class InscricaoRequestDTO {

	@NotNull(message = "idParticipante é obrigatório")
	private Long idParticipante;

	@NotNull(message = "idPalestra é obrigatório")
	private Long idPalestra;

	public InscricaoRequestDTO() {
	}

	public InscricaoRequestDTO(Long idParticipante, Long idPalestra) {
		this.idParticipante = idParticipante;
		this.idPalestra = idPalestra;
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public Long getIdPalestra() {
		return idPalestra;
	}

	public void setIdPalestra(Long idPalestra) {
		this.idPalestra = idPalestra;
	}
}
