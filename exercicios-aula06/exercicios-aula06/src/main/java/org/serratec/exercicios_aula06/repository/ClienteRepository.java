package org.serratec.exercicios_aula06.repository;

import org.serratec.exercicios_aula06.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
