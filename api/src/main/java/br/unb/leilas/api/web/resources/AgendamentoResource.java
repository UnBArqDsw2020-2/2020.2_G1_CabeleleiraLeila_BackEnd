package br.unb.leilas.api.web.resources;

import br.unb.leilas.api.domain.entities.Agendamento;
import br.unb.leilas.api.services.AgendamentoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Iterable;
import java.time.LocalDate;

@RestController // @controller + @ResponseBody
@RequestMapping("/agendamentos") // localhost:8080/api/servicos
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgendamentoResource {

  private final AgendamentoService agendamento;

  public AgendamentoResource(AgendamentoService agendamento) {
    this.agendamento = agendamento;
  }

  // CREATE
  @PostMapping
  public Agendamento post(@RequestBody Agendamento agendamento) { // espera um body com dados de um servico
    return this.agendamento.saveAgendamento(agendamento);
  }

  @PostMapping("list")
  public Iterable<Agendamento> postAgendamentos(@RequestBody Iterable<Agendamento> agendamentos) { // espera um body com dados de um servico
    return this.agendamento.saveAgendamentos(agendamentos);
  }

  // READ
  @GetMapping
  public Iterable<Agendamento> get() {
    return this.agendamento.findAllAgendamentos();
  }

  @GetMapping("{id}") // espera um id como parâmetro
  public Agendamento get(@PathVariable Integer id) {
    return this.agendamento.findAgendamentoById(id);
  }

  // UPDATE
  @PutMapping
  public Agendamento put(@RequestBody Agendamento agendamento) {
    return this.agendamento.updateAgendamento(agendamento);
  }

  // DELETE
  @DeleteMapping("{id}")
  public void delete(@PathVariable Integer id) {
    this.agendamento.deleteAgendamentoById(id);
  }

  @GetMapping("findByDataServicoId/{data}/{idServico}")
  public Iterable<Agendamento> findByDataServicoId(@PathVariable String data, @PathVariable Integer idServico) {
     LocalDate localDate = LocalDate.parse(data);
     Iterable<Agendamento> agendamentos = agendamento.getAgendamentoPorDataServicoId(localDate, idServico);
     return agendamentos;
  }
}
