package br.unb.leilas.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unb.leilas.api.domain.entities.Servico;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, Integer> { // tem acesso a métodos pro CRUD
  
}
