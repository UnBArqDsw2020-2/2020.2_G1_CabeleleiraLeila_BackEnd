package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.repositories.PessoaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  private final PessoaRepository repository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public PessoaService(PessoaRepository repository) {
    this.repository = repository;
  }

  public long count() {
    return this.repository.count();
  }

  public Pessoa save(Pessoa pessoa) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String passwordEncoded = bCryptPasswordEncoder.encode(pessoa.getAutenticacao().getSenha());
    pessoa.getAutenticacao().setSenha(passwordEncoded);

    return this.repository.save(pessoa);
  }

  public Iterable<Pessoa> findAll() {
    return this.repository.findAll();
  }

  public Pessoa findById(Integer id) {
    if (id != null) {
      Optional<Pessoa> opt = this.repository.findById(id);
      if (opt.isPresent())
        return opt.get();
    }
    return new Pessoa();
  }

  public Iterable<Pessoa> saveAll(Iterable<Pessoa> list) {
    return this.repository.saveAll(list);
  }

  public Pessoa getByLogin(String login) {
    Optional<Pessoa> opt = this.repository.findByAutenticacao_login(login);

    if (opt.isPresent()) {
      return opt.get();
    }
    return new Pessoa();
  }

  public void deleteById(Integer id) {
    this.repository.deleteById(id);
  }

}
