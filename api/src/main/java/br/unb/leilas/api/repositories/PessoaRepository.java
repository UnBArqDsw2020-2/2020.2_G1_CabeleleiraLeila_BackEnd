package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Pessoa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
  List<Pessoa> findByCpf(String cpf);
}
