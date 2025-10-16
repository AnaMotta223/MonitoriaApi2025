package org.serratec.exercicios_aula05.repository;

import org.serratec.exercicios_aula05.domain.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

}

