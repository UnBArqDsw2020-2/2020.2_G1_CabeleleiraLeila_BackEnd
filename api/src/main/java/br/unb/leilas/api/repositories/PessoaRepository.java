package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Pessoa;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

  Optional<Pessoa> findByAutenticacao_login(String login);
  List<Pessoa> findByCpf(String cpf);
}
