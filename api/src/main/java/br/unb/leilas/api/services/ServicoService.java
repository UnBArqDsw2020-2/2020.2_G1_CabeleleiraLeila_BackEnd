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

  public Iterable<Servico> findAll() {  
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Servico findById(Integer id) {
    if (id != null) {
      Optional<Servico> opt = this.repository.findById(id);
      if (opt.isPresent())
        return opt.get();
    }
    return new Servico();
  }

}
