package org.serratec.aula09.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class InscricaoPK implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "id_participante")
    private Participante participante;
    
    @ManyToOne
    @JoinColumn(name = "id_palestra")
    private Palestra palestra;

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participante, palestra);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InscricaoPK other = (InscricaoPK) obj;
        return Objects.equals(participante, other.participante)
                && Objects.equals(palestra, other.palestra);
    }
}
