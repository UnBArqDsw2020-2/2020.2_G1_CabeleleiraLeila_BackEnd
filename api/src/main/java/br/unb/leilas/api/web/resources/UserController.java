package br.unb.leilas.api.web.resources;

import org.springframework.beans.factory.annotation.Autowired;

import br.unb.leilas.api.domain.entities.Autenticacao;
import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.domain.entities.dto.ClienteDTO;
import br.unb.leilas.api.repositories.UserRepository;
import br.unb.leilas.api.services.ClienteService;
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
  private final ClienteService clienteService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  public UserController(UserRepository repository, ClienteService clienteService) {
    this.repository = repository;
    this.clienteService = clienteService;
  }

  @PostMapping()
  public ClienteDTO create(@RequestBody ClienteDTO dto) throws NoSuchAlgorithmException {

    new ClientProcess().validate(dto);

    if (this.repository.existsByUsername(dto.getUsername())) {
      throw new RuntimeException("Nome de usuário já utilizado");
    }
    dto.setAutenticacao(new Autenticacao());
    dto.getAutenticacao().setLogin(dto.getUsername());
    dto.getAutenticacao().setSenha(passwordEncoder.encode(dto.getPassword1()));
    dto.setPassword1("");
    dto.setPassword2("");

    return  this.clienteService.save(dto);  
  }

}
