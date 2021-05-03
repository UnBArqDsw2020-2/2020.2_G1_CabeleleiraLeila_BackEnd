package br.unb.leilas.api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.unb.leilas.api.domain.entities.Agenda;
import br.unb.leilas.api.repositories.AgendaRepository;

@Service
public class AgendaService {

   private AgendaRepository agendaRepository;

   public AgendaService(AgendaRepository agendaRepository) {
      this.agendaRepository = agendaRepository;
   }

   public Iterable<Agenda> findAll() {
     return this.agendaRepository.findAll();
   }

   public Iterable<Agenda> saveAgendas(Iterable<Agenda> agendas) { // endpoint post do serviço
      return this.agendaRepository.saveAll(agendas);
   }

   public List<Agenda> getAgendasPorDataServicoId(LocalDate data, Integer idServico) {
      List<Agenda> agenda = this.agendaRepository.findByDataAndServicoId(data, idServico);
      System.out.println(agenda);

      return agenda;
   }

   public Agenda save(Agenda agenda) {
      
      return this.agendaRepository.save(agenda);
   }
   
}
