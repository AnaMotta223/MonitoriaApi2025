package org.serratec.aula09.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula09.domain.Inscricao;
import org.serratec.aula09.domain.Palestra;

public class PalestraResponseDTO {
	private Long id;
	private String titulo;
	private String palestrante;
	private List<InscricaoParticipanteResponseDTO> participantes;

	public PalestraResponseDTO() {
	}

	public PalestraResponseDTO(Palestra palestra) {
		this.id = palestra.getId();
		this.titulo = palestra.getTitulo();
		this.palestrante = palestra.getPalestrante();
		this.participantes = new ArrayList<>();
		
		for (Inscricao inscricoes : palestra.getInscricoes()) {
			this.participantes.add(new InscricaoParticipanteResponseDTO(inscricoes.getId().getParticipante()));
		}
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

	public List<InscricaoParticipanteResponseDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<InscricaoParticipanteResponseDTO> participantes) {
		this.participantes = participantes;
	}
}
