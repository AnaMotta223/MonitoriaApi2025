package org.serratec.aula09.repository;

import org.serratec.aula09.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
	 Participante findByEmail(String email); 
}
