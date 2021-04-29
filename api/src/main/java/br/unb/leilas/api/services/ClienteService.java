package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Cliente;
import br.unb.leilas.api.domain.entities.dto.ClienteDTO;
import br.unb.leilas.api.domain.entities.RolePermissao;
import br.unb.leilas.api.repositories.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  private final ClienteRepository repository; // classe que implementa a interface p/ crud

  public ClienteService(ClienteRepository repository) { // construtor do service que recebe um CrudRepository
    this.repository = repository;
  }

  public Iterable<Cliente> findAllClientes() { // retorna todos os cliente cadastrados
    return this.repository.findAll(); // método findAll do CrudRepository
  }

  public Cliente findClienteById(Integer id) { // retorna um cliente específico
    if (id != null) {
      Optional<Cliente> opt = this.repository.findById(id);
      if (opt.isPresent()) return opt.get();
    }
    return new Cliente();
  }

  public ClienteDTO save(ClienteDTO dto) { // endpoint post do cliente
    Cliente cliente = dto.paraEntidade();

    List<RolePermissao> roles = new ArrayList<>();
    roles.add(RolePermissao.ROLE_CLIENTE);

    cliente.getAutenticacao().setRoles(roles);
    cliente.getAutenticacao().setLogin(dto.getUsername());
    return ClienteDTO.paraDto(this.repository.save(cliente));
  }

  public Cliente updateCliente(Cliente cliente) { // endpoint update do cliente (put)
    if (cliente.getId() != null) {
      Optional<Cliente> opt = this.repository.findById(cliente.getId());
      opt.get().setInteresses(cliente.getInteresses());
      opt.get().setNascimento(cliente.getNascimento());
      opt.get().setNome(cliente.getNome());
      opt.get().setTelefone(cliente.getTelefone());
      opt.get().setRg(cliente.getRg());
      opt.get().setRgEmissor(cliente.getRgEmissor());
      opt.get().setCpf(cliente.getCpf());
      opt.get().setTipo(cliente.getTipo());
      opt.get().setRgEmissor(cliente.getRgEmissor());
      return this.repository.save(opt.get()); // salvando as alterações no banco
    } else {
      System.out.println("404");
    }
    return new Cliente();
  }

  public void deleteClienteById(Integer id) {
    this.repository.deleteById(id);
  }

  public void deleteAll() {
    this.repository.deleteAll();
  }
}
