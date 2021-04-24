package br.unb.leilas.api.web.resources;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unb.leilas.api.domain.entities.Agenda;
import br.unb.leilas.api.services.AgendaService;

@RestController // @controller + @ResponseBody
@RequestMapping("/agenda") // localhost:8080/api/servicos
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgendaResource {

   private AgendaService agendaService;

   @GetMapping
   public Map diasEHorarios(String dataInicio, String dataFim, String nomeServico){
      
      Agenda[] agendas = agendaService.getAgendasPorData(dataInicio, dataFim);

      Map<String, String[]> diasEHorarios = agendaService.getDiasEHorarios(agendas, nomeServico);

      return diasEHorarios;
   }
}

/* codigos de apoio - apagaremos depois */

// Map<String, String[]> meumap = new HashMap<String, String[]>();
      // String hora[] = {"16:00", "17:00"};
      // 
      // meumap.put("24/04/2020", hora);

// public class Main {
   // public static void main(String[] argv) {
   //   System.out.println(getDateMap(new Date()));
   // }
//  
   // public static LinkedHashMap<String, Integer> getDateMap(Date date) {
   //   Calendar cal = Calendar.getInstance();
   //   cal.setTime(date);
   //   LinkedHashMap<String, Integer> datemap = new LinkedHashMap<String, Integer>();
   //   datemap.put("year", cal.get(Calendar.YEAR));
   //   datemap.put("month", cal.get(Calendar.MONTH));
   //   datemap.put("day", cal.get(Calendar.DAY_OF_MONTH));
   //   datemap.put("hour", cal.get(Calendar.HOUR_OF_DAY));
   //   datemap.put("minute", cal.get(Calendar.MINUTE));
   //   datemap.put("second", cal.get(Calendar.SECOND));
   //   datemap.put("millisecond", cal.get(Calendar.MILLISECOND));
//  
   //   return datemap;
//  
   // }
//  }