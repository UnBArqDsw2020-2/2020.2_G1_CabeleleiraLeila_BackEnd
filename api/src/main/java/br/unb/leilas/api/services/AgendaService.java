package br.unb.leilas.api.services;

import java.util.Map;

import br.unb.leilas.api.domain.entities.Agenda;
import br.unb.leilas.api.repositories.AgendaRepository;

public class AgendaService {

   private AgendaRepository agendaRepository;

   public Agenda[] getAgendasPorData(String dataInicio, String dataFim) {
       // buscar no intervalo dataInicio - dataFim as agendas
      return null;
   }

   public Map<String, String[]> getDiasEHorarios(Agenda[] agendas, String nomeServico) {
      // para cada agenda (data), verificar o array de Pedidos
         // para cada Pedido, verificar o array de Servico e
         // filtrar pelo nomeServico

         // verificar os horarios indisponiveis para saber os disponiveis

         // adicionar os disponiveis ao array de horarios disponiveis

      // retornar o resultado
      
      return null;
   }
   
}
