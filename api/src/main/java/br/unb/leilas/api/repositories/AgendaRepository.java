package br.unb.leilas.api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.unb.leilas.api.domain.entities.Agenda;

public interface AgendaRepository extends CrudRepository<Agenda, Integer> {
   List<Agenda> findByData(Date data);
}
