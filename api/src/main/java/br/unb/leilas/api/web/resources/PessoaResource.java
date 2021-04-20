package br.unb.leilas.api.web.resources;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.domain.entities.dto.PessoaDTO;
import br.unb.leilas.api.services.PessoaService;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

  private final PessoaService service;

  public PessoaResource(PessoaService service) {
    this.service = service;
  }

  @GetMapping
  public List<PessoaDTO> get() {
    return this.service.findAll();
  }

  @GetMapping("{id}")
  public PessoaDTO get(@PathVariable Integer id) {
    return this.service.findById(id);
  }

  @PostMapping
  public PessoaDTO post(@RequestBody PessoaDTO pessoa) {
    return this.service.save(pessoa);
  }

  @PostMapping("/all")
  public List<PessoaDTO> post(@RequestBody List<PessoaDTO> list) {
    return this.service.saveAll(list);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    this.service.deleteById(id);
  }

  @PostMapping("/login")
  public PessoaDTO getByLogin(@RequestBody String login) {
    return this.service.getByLogin(login);
  }
}
