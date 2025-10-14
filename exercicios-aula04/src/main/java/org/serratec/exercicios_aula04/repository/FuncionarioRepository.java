package org.serratec.exercicios_aula04.repository;

import org.serratec.exercicios_aula04.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
