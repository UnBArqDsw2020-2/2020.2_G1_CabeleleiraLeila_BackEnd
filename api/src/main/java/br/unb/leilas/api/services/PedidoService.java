package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Pedido;
import br.unb.leilas.api.domain.entities.Cliente;
import br.unb.leilas.api.repositories.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PedidoService {

  private final PedidoRepository repository; // classe que implementa a interface p/ crud

  public PedidoService(PedidoRepository repository) { // construtor do service que recebe um CrudRepository
    this.repository = repository;
  }

  public Iterable<Pedido> findAllPedidos() { // retorna todos os servicos cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Pedido findPedidoById(Integer id) { // retorna um pedido específico
    if (id != null) {
      Optional<Pedido> opt = this.repository.findById(id);
      if (opt.isPresent()) return opt.get();
    }
    return new Pedido();
  }

  public List<Pedido> findByClienteId(Integer id) {
    return this.repository.findByClienteId(id);
  }

  public Pedido savePedido(Pedido pedido) { // endpoint post do pedido
    return this.repository.save(pedido);
  }

  public Pedido updatePedido(Pedido pedido) { // endpoint update do pedido (put)
    if (pedido.getId() != null) {
      Optional<Pedido> opt = this.repository.findById(pedido.getId());
      opt.get().setValor(pedido.getValor()); // substituindo os atributos de um pedido salvo por atributos passados no body
      opt.get().setData(pedido.getData());
      opt.get().setConfirmado(pedido.getConfirmado());
      opt.get().setCliente(pedido.getCliente());
      return this.repository.save(opt.get()); // salvando as alterações no banco
    } else {
      System.out.println("404");
    }
    return new Pedido();
  }

  public void deletePedidoById(Integer id) {
    this.repository.deleteById(id);
  }

  public void deleteAll() {
    this.repository.deleteAll();
  }
}
