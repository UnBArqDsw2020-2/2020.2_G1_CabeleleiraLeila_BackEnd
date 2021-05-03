package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Agendamento;
import br.unb.leilas.api.repositories.AgendamentoRepository;
import java.lang.Iterable;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

  private final AgendamentoRepository repository; // classe que implementa a interface p/ crud

  public AgendamentoService(AgendamentoRepository repository) { // construtor do service que recebe um CrudRepository
    this.repository = repository;
  }

  public Iterable<Agendamento> findAllServices() { // retorna todos os Agendamentos cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Agendamento findAgendamentoById(Integer id) { // retorna um Agendamento específico
    if (id != null) {
      Optional<Agendamento> opt = this.repository.findById(id);
      if (opt.isPresent()) return opt.get();
    }
    return new Agendamento();
  }

  public Agendamento saveAgendamento(Agendamento agendamento) { // endpoint post do serviço
    return this.repository.save(agendamento);
  }

  public Iterable<Agendamento> saveAgendamentos(Iterable<Agendamento> agendamentos) { // endpoint post do serviço
    return this.repository.saveAll(agendamentos);
  }

  public Agendamento updateAgendamento(Agendamento agendamento) { // endpoint update do serviço (put)
    if (agendamento.getId() != null) {
      Optional<Agendamento> opt = this.repository.findById(agendamento.getId());
      opt.get().setData(agendamento.getData()); // substituindo os atributos de um serviço salvo por atributos passados no body
      opt.get().setHora(agendamento.getHora());
      opt.get().setServico(agendamento.getServico());
      return this.repository.save(opt.get()); // salvando as alterações no banco
    } else {
      System.out.println("404");
    }
    return new Agendamento();
  }

  public void deleteAgendamentoById(Integer id) {
    this.repository.deleteById(id);
  }

  public void deleteAll() {
    this.repository.deleteAll();
  }
}
