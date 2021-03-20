package br.unb.leilas.api.services;
import br.unb.leilas.api.domain.entities.Servico;
import br.unb.leilas.api.repositories.ServicoRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
 
  private final ServicoRepository repository; // classe que implementa a interface p/ crud

  public ServicoService(ServicoRepository repository) { // construtor do service que recebe um CrudRepository
    this.repository = repository;
  }

  public Iterable<Servico> findAll() { // retorna todos os servicos cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Servico findById(Integer id) { // retorna um servico específico
    if (id != null) {
      Optional<Servico> opt = this.repository.findById(id);
      if (opt.isPresent())
        return opt.get();
    }
    return new Servico();
  }

  public Servico saveService(Servico servico) { // endpoint post do serviço
    if (servico.getNome() != null) {
      List<Servico> listName = this.repository.findByNome(servico.getNome());
      if (listName.isEmpty()) {
        return this.repository.save(servico);
      }
    }
    return new Servico();
  }

}
