package org.serratec.aula03.exercicios_aula03.repository;

import org.serratec.aula03.exercicios_aula03.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
