package org.serratec.aula09.service;

import java.time.LocalDateTime;

import org.serratec.aula09.domain.Inscricao;
import org.serratec.aula09.domain.InscricaoPK;
import org.serratec.aula09.domain.Palestra;
import org.serratec.aula09.domain.Participante;
import org.serratec.aula09.dto.InscricaoRequestDTO;
import org.serratec.aula09.exception.InscricaoDuplicadaException;
import org.serratec.aula09.repository.InscricaoRepository;
import org.serratec.aula09.repository.PalestraRepository;
import org.serratec.aula09.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class InscricaoService {

	@Autowired
    private InscricaoRepository inscricaoRepository;
	@Autowired
    private ParticipanteRepository participanteRepository;
	@Autowired
    private PalestraRepository palestraRepository;

    @Transactional
    public InscricaoRequestDTO inscrever(InscricaoRequestDTO dto) {
        Participante participante = participanteRepository.findById(dto.getIdParticipante())
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));
        Palestra palestra = palestraRepository.findById(dto.getIdPalestra())
                .orElseThrow(() -> new RuntimeException("Palestra não encontrada."));

        InscricaoPK pk = new InscricaoPK();
        pk.setParticipante(participante);
        pk.setPalestra(palestra);

        if (inscricaoRepository.findById(pk).isPresent()) {
            throw new InscricaoDuplicadaException("O participante já está inscrito nesta palestra.");
        }

        Inscricao inscricao = new Inscricao(participante, palestra, LocalDateTime.now());
        inscricaoRepository.save(inscricao);
        InscricaoRequestDTO resposta = new InscricaoRequestDTO(inscricao.getId().getParticipante().getId(), inscricao.getId().getPalestra().getId());
        return resposta;
    }
}