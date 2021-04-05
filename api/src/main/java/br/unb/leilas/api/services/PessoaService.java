package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.repositories.PessoaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  private final PessoaRepository repository;

  public PessoaService(PessoaRepository repository) {
    this.repository = repository;
  }

  public long count() {
    return this.repository.count();
  }

  public Pessoa save(Pessoa pessoa) {
    // if (pessoa.getCpf() != null) {
    //     List<Pessoa> list = this.repository.findByCpf(pessoa.getCpf());
    //     if (list.isEmpty()) {
    //         return this.repository.save(pessoa);
    //     } else {
    //         Optional<Pessoa> opt = list.stream().findFirst();
    //         //atualização de dados
    //         opt.get().setNome(pessoa.getNome());

    //         //salvando o dado atualizado
    //         return repository.save(opt.get());
    //     }
    // }
    // return new Pessoa();
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String passwordEncoded = bCryptPasswordEncoder.encode(
      pessoa.getAutenticacao().getSenha()
    );
    pessoa.getAutenticacao().setSenha(passwordEncoded);

    return this.repository.save(pessoa);
  }

  public Iterable<Pessoa> findAll() {
    return this.repository.findAll();
  }

  public Pessoa findById(Integer id) {
    if (id != null) {
      Optional<Pessoa> opt = this.repository.findById(id);
      if (opt.isPresent()) return opt.get();
    }
    return new Pessoa();
  }

  public void deleteById(Integer id) {
    this.repository.deleteById(id);
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

}
