package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Agendamento;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> { // tem acesso a métodos pro CRUD
}
