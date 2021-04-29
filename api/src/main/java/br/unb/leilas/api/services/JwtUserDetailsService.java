package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.repositories.PessoaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {
  @Autowired
  private PessoaRepository pRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    Pessoa pessoa= pRepository.findByAutenticacao_login(username).get();
    if (pessoa == null) {
      throw new UsernameNotFoundException(
        "User not found with username: " + username
      );
    }
    return new org.springframework.security.core.userdetails.User(
      pessoa.getAutenticacao().getLogin(),
      pessoa.getAutenticacao().getSenha(),
      pessoa.getAutenticacao().getRoles()
    );
  }
}
