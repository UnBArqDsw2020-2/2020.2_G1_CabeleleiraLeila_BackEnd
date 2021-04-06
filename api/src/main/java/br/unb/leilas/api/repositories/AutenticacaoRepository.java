package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Autenticacao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacaoRepository
  extends CrudRepository<Autenticacao, Integer> {
  boolean existsByLogin(String login);

  Autenticacao findByLogin(String login);

  @Transactional
  void deleteByLogin(String login);
}
