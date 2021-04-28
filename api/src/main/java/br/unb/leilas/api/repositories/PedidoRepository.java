package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> { // tem acesso a métodos pro CRUD
}
