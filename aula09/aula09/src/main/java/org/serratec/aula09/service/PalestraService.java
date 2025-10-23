package org.serratec.aula09.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula09.domain.Palestra;
import org.serratec.aula09.dto.PalestraResponseDTO;
import org.serratec.aula09.repository.PalestraRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PalestraService {

    private final PalestraRepository palestraRepository;

    public PalestraService(PalestraRepository palestraRepository) {
        this.palestraRepository = palestraRepository;
    }

    @Transactional
    public Palestra criar(Palestra palestra) {
        return palestraRepository.save(palestra);
    }
    
    public List<PalestraResponseDTO> listarTodas() {
    	 List<Palestra> palestras = palestraRepository.findAll();
         List<PalestraResponseDTO> resposta = new ArrayList<>();
         
         for (Palestra palestra : palestras) {
             resposta.add(new PalestraResponseDTO(palestra));
         }

         return resposta;
    }

    public Palestra buscarPorId(Long id) {
        return palestraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palestra não encontrada."));
    }

//    @Transactional
//    public Palestra atualizar(Long id, Palestra palestraDto) {
//        Palestra palestra = palestraRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Palestra não encontrada."));
//
//        palestra.setTitulo(palestraDto.getTitulo());
//        palestra.setPalestrante(palestraDto.getPalestrante());
//
//        return palestraRepository.save(palestra);
//    }
//
//    @Transactional
//    public void deletar(Long id) {
//        if (!palestraRepository.existsById(id)) {
//            throw new RuntimeException("Palestra não encontrada.");
//        }
//        palestraRepository.deleteById(id);
//    }
}