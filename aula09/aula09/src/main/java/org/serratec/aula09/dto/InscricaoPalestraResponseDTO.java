package org.serratec.aula09.dto;

import org.serratec.aula09.domain.Palestra;

public class InscricaoPalestraResponseDTO {
	private Long idPalestra;
	private String titulo;
	private String palestrante;
	
	public InscricaoPalestraResponseDTO() {
	}

	public InscricaoPalestraResponseDTO(Palestra palestra) {
		this.idPalestra = palestra.getId();
		this.titulo = palestra.getTitulo();
		this.palestrante = palestra.getPalestrante();
	}

	public Long getIdPalestra() {
		return idPalestra;
	}

	public void setIdPalestra(Long idPalestra) {
		this.idPalestra = idPalestra;
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
}
