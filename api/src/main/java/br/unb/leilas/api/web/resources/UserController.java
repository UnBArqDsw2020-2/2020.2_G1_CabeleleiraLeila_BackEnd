package br.unb.leilas.api.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.repositories.UserRepository;

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

    // private HashData hashData = new HashData();

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

    @PostMapping()
    public Boolean create(@RequestBody PessoaDTO dto) throws NoSuchAlgorithmException {
        String username = dto.getUsername();
        if (repository.existsByUsername(username)) {
            throw new RuntimeException("Nome de usuário já utilizado");
        }
        if (!dto.getPassword1().equals(dto.getPassword2())) {
            throw new RuntimeException("Senhas não são iguais");
        }

        String password = dto.getPassword1();
        String encodedPassword = passwordEncoder.encode(password);
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
