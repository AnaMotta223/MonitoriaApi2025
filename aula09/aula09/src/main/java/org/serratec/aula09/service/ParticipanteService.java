package org.serratec.aula09.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula09.domain.Inscricao;
import org.serratec.aula09.domain.Participante;
import org.serratec.aula09.dto.ParticipanteRequestDTO;
import org.serratec.aula09.dto.ParticipanteResponseDTO;
import org.serratec.aula09.exception.EmailJaCadastradoException;
import org.serratec.aula09.exception.SenhaInvalidaException;
import org.serratec.aula09.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Transactional
    public ParticipanteResponseDTO criarParticipante(ParticipanteRequestDTO participanteRequestDTO) {
        if (participanteRepository.findByEmail(participanteRequestDTO.getEmail()) != null) {
            throw new EmailJaCadastradoException("O e-mail informado já está cadastrado.");
        }

        if (!participanteRequestDTO.getSenha().equals(participanteRequestDTO.getConfirmaSenha())) {
            throw new SenhaInvalidaException("As senhas não coincidem.");
        }
        
        Participante participante = new Participante();
        participante.setNome(participanteRequestDTO.getNome());
        participante.setEmail(participanteRequestDTO.getEmail());
        participante.setSenha(participanteRequestDTO.getSenha());
        
        List<Inscricao> palestras = new ArrayList<>();
        participante.setInscricoes(palestras);

        Participante resposta = participanteRepository.save(participante);
        return new ParticipanteResponseDTO(resposta);
    }

    public List<ParticipanteResponseDTO> listarTodos() {
        List<Participante> participantes = participanteRepository.findAll();
        List<ParticipanteResponseDTO> resposta = new ArrayList<>();

        for (Participante participante : participantes) {
            resposta.add(new ParticipanteResponseDTO(participante));
        }

        return resposta;
    }

    public ParticipanteResponseDTO buscarPorId(Long id) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));
        return new ParticipanteResponseDTO(participante);
    }

//    @Transactional
//    public ParticipanteResponseDTO atualizar(Long id, ParticipanteRequestDTO participanteRequestDTO) {
//        Participante participante = participanteRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));
//
//        participante.setNome(participanteRequestDTO.getNome());
//        participante.setEmail(participanteRequestDTO.getEmail());
//        participante.setSenha(participanteRequestDTO.getSenha());
//
//        Participante participanteAtualizado = participanteRepository.save(participante);
//        return new ParticipanteResponseDTO(participanteAtualizado.getId(), participanteAtualizado.getNome(), participanteAtualizado.getEmail());
//    }
//
//    @Transactional
//    public void deletar(Long id) {
//        if (!participanteRepository.existsById(id)) {
//            throw new RuntimeException("Participante não encontrado.");
//        }
//        participanteRepository.deleteById(id);
//    }
}