package br.unb.leilas.api.web.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.repositories.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    final private UserRepository repository;

    // private HashData hashData = new HashData();

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (repository.existsByUsername(username)) {

            throw new RuntimeException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        // String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        repository.save(user);
        return true;
    }

}