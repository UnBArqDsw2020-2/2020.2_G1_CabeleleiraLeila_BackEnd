package br.unb.leilas.api.web.resources;

import br.unb.leilas.api.domain.entities.Cliente;
import br.unb.leilas.api.services.ClienteService;
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
@RequestMapping("/clientes") // localhost:8080/api/clientes
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteResource {

  private final ClienteService cliente;

  public ClienteResource(ClienteService cliente) {
    this.cliente = cliente;
  }

  // CREATE
  // @PostMapping
  // public Cliente post(@RequestBody Cliente cliente) { // espera um body com dados de um cliente
  //   return this.cliente.saveCliente(cliente);
  // }

  // READ
  @GetMapping
  public Iterable<Cliente> get() {
    return this.cliente.findAllClientes();
  }

  @GetMapping("{id}") // espera um id como parâmetro
  public Cliente get(@PathVariable Integer id) {
    return this.cliente.findClienteById(id);
  }

  // UPDATE
  @PutMapping
  public Cliente put(@RequestBody Cliente cliente) {
    return this.cliente.updateCliente(cliente);
  }

  // DELETE
  @DeleteMapping("{id}")
  public void delete(@PathVariable Integer id) {
    this.cliente.deleteClienteById(id);
  }
}
