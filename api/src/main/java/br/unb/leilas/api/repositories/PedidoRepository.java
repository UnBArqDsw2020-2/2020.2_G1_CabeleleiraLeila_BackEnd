package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Cliente;
import br.unb.leilas.api.domain.entities.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> { // tem acesso a métodos pro CRUD
  List<Pedido> findByCliente(Cliente cliente);
}
