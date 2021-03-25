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

  public Iterable<Servico> findAllServices() { // retorna todos os servicos cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Servico findServiceById(Integer id) { // retorna um servico específico
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

  public Servico updateService(Servico servico) { // endpoint update do serviço (put)
    if(servico.getNome() != null) {
      List<Servico> listServico = this.repository.findByNome(servico.getNome());
      // System.out.println(listServico.);
      if (!listServico.isEmpty()) {
        Optional<Servico> optServico = listServico.stream().findFirst();
          optServico.get().setDescricao(servico.getDescricao()); // substituindo os atributos de um serviço salvo por atributos passados no body
          optServico.get().setImagem(servico.getImagem());
          optServico.get().setNota(servico.getNota());
          optServico.get().setValor(servico.getValor());

          return this.repository.save(optServico.get()); // salvando as alterações no banco 
      } else {
        System.out.println("404");
      }
    }
    return new Servico();
  }

  public void deleteServiceById(Integer id) {
    this.repository.deleteById(id);
  }

  public void deleteAll() {
    this.repository.deleteAll();
  }

  // public void deleteServiceByName(String nome) {
  //   this.repository.deleteByName(nome);
  // }

  

}
