package br.unb.leilas.api.repositories;
import br.unb.leilas.api.domain.entities.Servico;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, Integer> { // tem acesso a métodos pro CRUD
  List<Servico> findByNome(String nome); 
}
