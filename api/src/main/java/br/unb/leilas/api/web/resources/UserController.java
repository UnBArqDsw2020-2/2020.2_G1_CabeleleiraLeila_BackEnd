package br.unb.leilas.api.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.repositories.UserRepository;
import br.unb.leilas.api.services.validator.ClientProcess;

import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository repository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @PostMapping()
  public Boolean create(@RequestBody PessoaDTO dto) throws NoSuchAlgorithmException {

    new ClientProcess().validate(dto);

    if (this.repository.existsByUsername(dto.getUsername())) {
      throw new RuntimeException("Nome de usuário já utilizado");
    }

    User user = User.builder().username(dto.getUsername()).password(passwordEncoder.encode(dto.getPassword1())).build();

    repository.save(user);
    return true;
  }
}
