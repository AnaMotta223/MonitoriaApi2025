package org.serratec.aula09.repository;

import org.serratec.aula09.domain.Inscricao;
import org.serratec.aula09.domain.InscricaoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, InscricaoPK>{

}
