package br.unb.leilas.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unb.leilas.api.domain.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    Boolean existsByUsername(String username);
    User findByUsername(String username);

}