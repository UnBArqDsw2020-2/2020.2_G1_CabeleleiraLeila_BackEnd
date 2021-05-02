package br.unb.leilas.api.web.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.unb.leilas.api.domain.entities.Agenda;
import br.unb.leilas.api.services.AgendaService;

@RestController // @controller + @ResponseBody
@RequestMapping("/agenda") // localhost:8080/api/servicos
@CrossOrigin(origins = "*", maxAge = 3600)

public class AgendaResource {

   private AgendaService agendaService;
   
   public AgendaResource(AgendaService agendaService) {
      this.agendaService = agendaService;
   }

   @GetMapping
   public Iterable<Agenda> getAll() {
      return this.agendaService.findAll();
   }

   @GetMapping("findByDataServicoId/{data}/{idServico}")
   public Iterable<Agenda> findByDataServicoId(@PathVariable String data, @PathVariable Integer idServico) {
      LocalDate localDate = LocalDate.parse(data);
      List<Agenda> agendas = agendaService.getAgendasPorDataServicoId(localDate, idServico);
      return agendas;
   }

   @PostMapping
   public Agenda postAgenda(@RequestBody Agenda agenda) {
      return this.agendaService.save(agenda);
   }
}
