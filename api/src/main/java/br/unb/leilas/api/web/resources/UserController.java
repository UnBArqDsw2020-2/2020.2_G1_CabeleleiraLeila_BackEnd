package br.unb.leilas.api.web.resources;

import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository repository;

  // private HashData hashData = new HashData();

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Boolean create(@RequestBody PessoaDTO dto)
    throws NoSuchAlgorithmException {
    String username = dto.getUsername();
    if (repository.existsByUsername(username)) {
      throw new RuntimeException("Nome de usuário já utilizado");
    }
    if (!dto.getPassword1().equals(dto.getPassword2())) {
      throw new RuntimeException("Senhas não são iguais");
    }

    String password = dto.getPassword1();
    String encodedPassword = new BCryptPasswordEncoder().encode(password);
    // String hashedPassword = hashData.get_SHA_512_SecurePassword(password);

    User user = User
      .builder()
      .username(username)
      .password(encodedPassword)
      .build();

    repository.save(user);
    return true;
  }
}
