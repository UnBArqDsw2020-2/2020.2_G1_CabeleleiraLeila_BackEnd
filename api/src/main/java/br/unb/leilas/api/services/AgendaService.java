package br.unb.leilas.api.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

   public List<Agenda> getAgendasPorData(String dataInicio, String dataFim) {
      List<Agenda> agenda = this.agendaRepository.findByData(dataInicio);
      System.out.println(agenda);

      return agenda;
   }

   public Map<String, String[]> getDiasEHorarios(String dataInicio, String dataFim, String nomeServico) throws ParseException {
      // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      // Date inicio = formatter.parse(dataInicio);
      // System.out.println(inicio);
      // List<Agenda> agenda = this.agendaRepository.findByData(dataInicio);
      // System.out.println(agenda);
      return null;
   }

   public Agenda save(Agenda agenda) {
      
      return this.agendaRepository.save(agenda);
    }

   // public Agenda[] getAgendasPorData(String dataInicio, String dataFim) {
   //     // buscar no intervalo dataInicio - dataFim as agendas
   //    return null;
   // }

   // public Map<String, String[]> getDiasEHorarios(Agenda[] agendas, String nomeServico) {
   //    // para cada agenda (data), verificar o array de Pedidos
   //       // para cada Pedido, verificar o array de Servico e
   //       // filtrar pelo nomeServico

   //       // verificar os horarios indisponiveis para saber os disponiveis

   //       // adicionar os disponiveis ao array de horarios disponiveis

   //    // retornar o resultado
      
   //    return null;
   // }
   

   
}
