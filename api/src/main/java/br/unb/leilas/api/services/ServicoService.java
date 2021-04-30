package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Servico;
import br.unb.leilas.api.repositories.ServicoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

  private final ServicoRepository repository; // classe que implementa a interface p/ crud

  public ServicoService(ServicoRepository repository) { // construtor do service que recebe um CrudRepository
    this.repository = repository;
  }

  public Iterable<Servico> findAllServices() { // retorna todos os servicos cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Servico findServiceById(Integer id) { // retorna um servico específico
    if (id != null) {
      Optional<Servico> opt = this.repository.findById(id);
      if (opt.isPresent()) return opt.get();
    }
    return new Servico();
  }

  public Servico saveService(Servico servico) { // endpoint post do serviço
    return this.repository.save(servico);
  }

  public Servico updateService(Servico servico) { // endpoint update do serviço (put)
    if (servico.getId() != null) {
      Optional<Servico> opt = this.repository.findById(servico.getId());
      opt.get().setNome(servico.getNome()); // substituindo os atributos de um serviço salvo por atributos passados no body
      opt.get().setData(servico.getData());
      opt.get().setDescricao(servico.getDescricao());
      opt.get().setImagem(servico.getImagem());
      opt.get().setNota(servico.getNota());
      opt.get().setValor(servico.getValor());
      return this.repository.save(opt.get()); // salvando as alterações no banco
    } else {
      System.out.println("404");
    }
    return new Servico();
  }

  public void deleteServiceById(Integer id) {
    this.repository.deleteById(id);
  }

  public void deleteAll() {
    this.repository.deleteAll();
  }
}
