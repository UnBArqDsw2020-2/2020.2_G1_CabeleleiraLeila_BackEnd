package br.unb.leilas.api.services;

import br.unb.leilas.api.domain.entities.Autenticacao;
import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.domain.entities.RolePermissao;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.repositories.AutenticacaoRepository;
import br.unb.leilas.api.repositories.PessoaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  private final PessoaRepository repository;

  private final AutenticacaoRepository autenticacaoRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;


  public long count() {
    return this.repository.count();
  }

  public PessoaDTO save(PessoaDTO dto) {
    Pessoa pessoa = dto.paraEntidade();
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String passwordEncoded = bCryptPasswordEncoder.encode(pessoa.getAutenticacao().getSenha());
    pessoa.getAutenticacao().setSenha(passwordEncoded);

    List<RolePermissao> roles = new ArrayList<>();
    roles.add(RolePermissao.ROLE_CLIENTE);

    pessoa.getAutenticacao().setRoles(roles);
    pessoa.getAutenticacao().setSenha(passwordEncoded);
    

    return PessoaDTO.paraDto(this.repository.save(pessoa));
  }

  public List<PessoaDTO> findAll() {
    return PessoaDTO.paraDto(this.repository.findAll());
  }

  public PessoaDTO findById(Integer id) {
    if (id != null) {
      Optional<Pessoa> opt = this.repository.findById(id);
      if (opt.isPresent())
        return PessoaDTO.paraDto(opt.get());
    }
    return PessoaDTO.paraDto(new Pessoa());
  }

  public List<PessoaDTO> saveAll(List<PessoaDTO> dtos) {
    List<Pessoa> pessoas = new ArrayList<>();
    dtos.stream().forEach( dto -> pessoas.add(dto.paraEntidade()));
    return PessoaDTO.paraDto(this.repository.saveAll(pessoas));
  }

  public PessoaDTO getByLogin(String login) {
    Optional<Pessoa> opt = this.repository.findByAutenticacao_login(login);

    if (opt.isPresent()) {
      return PessoaDTO.paraDto(opt.get());
    }
    return PessoaDTO.paraDto(new Pessoa());
  }

  public void deleteById(Integer id) {
    this.repository.deleteById(id);
  }

  public PessoaService(PessoaRepository repository, AutenticacaoRepository autenticacaoRepository) {
    this.repository = repository;
    this.autenticacaoRepository = autenticacaoRepository;
  }

}
