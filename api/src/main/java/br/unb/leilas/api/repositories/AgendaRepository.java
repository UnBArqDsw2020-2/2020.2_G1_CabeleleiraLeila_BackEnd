package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Agenda;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {
   
   List<Agenda> findByData(String data);
   
}
