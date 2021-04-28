package br.unb.leilas.api.web.resources;

import br.unb.leilas.api.domain.entities.Pedido;
import br.unb.leilas.api.services.PedidoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @controller + @ResponseBody
@RequestMapping("/pedidos") // localhost:8080/api/pedidos
@CrossOrigin(origins = "*", maxAge = 3600)
public class PedidoResource {

  private final PedidoService pedido;

  public PedidoResource(PedidoService pedido) {
    this.pedido = pedido;
  }

  // CREATE
  @PostMapping
  public Pedido post(@RequestBody Pedido pedido) { // espera um body com dados de um pedido
    return this.pedido.savePedido(pedido);
  }

  // READ
  @GetMapping
  public Iterable<Pedido> get() {
    return this.pedido.findAllPedidos();
  }

  @GetMapping("{id}") // espera um id como parâmetro
  public Pedido get(@PathVariable Integer id) {
    return this.pedido.findPedidoById(id);
  }

  // UPDATE
  @PutMapping
  public Pedido put(@RequestBody Pedido pedido) {
    return this.pedido.updatePedido(pedido);
  }

  // DELETE
  @DeleteMapping("{id}")
  public void delete(@PathVariable Integer id) {
    this.pedido.deletePedidoById(id);
  }
}
