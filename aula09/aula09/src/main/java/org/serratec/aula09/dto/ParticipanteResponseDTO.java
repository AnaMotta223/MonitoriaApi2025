package org.serratec.aula09.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula09.domain.Inscricao;
import org.serratec.aula09.domain.Participante;

public class ParticipanteResponseDTO {

	private Long id;
	private String nome;
	private String email;
	private List<InscricaoPalestraResponseDTO> palestras;

	public ParticipanteResponseDTO() {
	}

	public ParticipanteResponseDTO(Participante participante) {
		this.id = participante.getId();
		this.nome = participante.getNome();
		this.email = participante.getEmail();
		this.palestras = new ArrayList<>();
		
		for (Inscricao inscricoes : participante.getInscricoes()) {
			this.palestras.add(new InscricaoPalestraResponseDTO(inscricoes.getId().getPalestra()));
		}
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
}
