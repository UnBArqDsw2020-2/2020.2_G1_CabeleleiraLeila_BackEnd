package br.unb.leilas.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unb.leilas.api.domain.entities.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

    // List<Pessoa> findByCpf(String cpf);    

    Optional<Pessoa> findByAutenticacao_login(String login);
}
