package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.domain.entities.User;
import br.unb.leilas.api.repositories.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(
        "User not found with username: " + username
      );
    }
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      new ArrayList<>()
    );
  }
}
