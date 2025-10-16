package org.serratec.exercicios_aula06.repository;

import org.serratec.exercicios_aula06.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
