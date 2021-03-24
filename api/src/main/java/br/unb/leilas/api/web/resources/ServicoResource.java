package br.unb.leilas.api.web.resources;

import org.springframework.web.bind.annotation.RestController;

import br.unb.leilas.api.services.ServicoService;
import br.unb.leilas.api.domain.entities.Servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // @controller + @ResponseBody
@RequestMapping("/servico") // localhost:8080/api/servico
@CrossOrigin(origins = "*", maxAge = 3600)
public class ServicoResource {
  private final ServicoService servico;

  public ServicoResource(ServicoService servico) {
    this.servico = servico;
  }

  // CREATE
  @PostMapping()
  public Servico post(@RequestBody Servico servico) { // espera um body com dados de um servico
    return this.servico.saveService(servico);
  }

  // READ
  @GetMapping()
  public Iterable<Servico> get() {
    return this.servico.findAllServices();
  }

  @GetMapping("{id}") // espera um id como parâmetro
  public Servico get(@PathVariable Integer id) {
    return this.servico.findServiceById(id);
  }

  // UPDATE
  @PutMapping("/update")
  public Servico put(@RequestBody Servico servico) {
    // System.out.println(servico.getNome());
    return this.servico.updateService(servico);
  }

  // DELETE
  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Integer id) {
    this.servico.deleteServiceById(id);
  }

  @DeleteMapping("/delete/all")
  public void delete() {
    this.servico.deleteAll();
  }

  // @DeleteMapping("/delete/{name}")
  // public void delete(@PathVariable String name) {
  // this.servico.deleteServiceByName(name);
  // }

}
