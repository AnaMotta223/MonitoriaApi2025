package org.serratec.aula09.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Inscricao {

    @EmbeddedId
    private InscricaoPK id = new InscricaoPK();

    @Column(name = "data_inscricao", nullable = false)
    private LocalDateTime dataInscricao;

    public Inscricao() {
    }

    public Inscricao(Participante participante, Palestra palestra, LocalDateTime dataInscricao) {
        this.id.setParticipante(participante);
        this.id.setPalestra(palestra);
        this.dataInscricao = dataInscricao;
    }

    public InscricaoPK getId() {
        return id;
    }

    public void setId(InscricaoPK id) {
        this.id = id;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public void setParticipante(Participante participante) {
        this.id.setParticipante(participante);
    }

    public void setPalestra(Palestra palestra) {
        this.id.setPalestra(palestra);
    }

    public Participante getParticipante() {
        return this.id.getParticipante();
    }

    public Palestra getPalestra() {
        return this.id.getPalestra();
    }
}