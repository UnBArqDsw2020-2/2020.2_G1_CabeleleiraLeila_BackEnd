package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Agendamento;
import java.lang.Iterable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> { // tem acesso a métodos pro CRUD
    Iterable<Agendamento> findByDataAndServicoId(LocalDate data, Integer id);
}
