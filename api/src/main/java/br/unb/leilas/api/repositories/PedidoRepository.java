package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.Pedido;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> { // tem acesso a métodos pro CRUD

    List<Pedido> findByPessoa_Id(Long id);
}
