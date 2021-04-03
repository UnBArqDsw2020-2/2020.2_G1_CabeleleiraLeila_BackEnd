package br.unb.leilas.api.repositories;

import br.unb.leilas.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
  Boolean existsByUsername(String username);
  User findByUsername(String username);
}
