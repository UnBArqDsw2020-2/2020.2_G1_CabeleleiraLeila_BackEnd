package br.unb.leilas.api.security;

import org.springframework.stereotype.Service;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.repositories.PessoaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class LeilasUserDetails implements UserDetailsService {

    @Autowired
    private PessoaRepository userRepository;
  
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Optional<Pessoa> opt = userRepository.findByAutenticacao_login(email);
  
      if (!opt.isPresent()) {
        throw new UsernameNotFoundException("User '" + email + "' not found");
      }
  
      return org.springframework.security.core.userdetails.User//
          .withUsername(opt.get().getAutenticacao().getEmail())//
          .password(opt.get().getAutenticacao().getSenha())//
          .authorities("ADMIN")//
          .accountExpired(false)//
          .accountLocked(false)//
          .credentialsExpired(false)//
          .disabled(false)//
          .build();
    }
  
  }