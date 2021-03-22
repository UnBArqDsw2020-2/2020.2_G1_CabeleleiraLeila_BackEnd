package br.unb.leilas.api.web.resources;

import org.springframework.web.bind.annotation.RestController;

import br.unb.leilas.api.services.ServicoService;
import br.unb.leilas.api.domain.entities.Servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // @controller + @ResponseBody
@RequestMapping("/servico") // localhost:8080/api/servico

public class ServicoResource {
  private final ServicoService servico; 

  public ServicoResource(ServicoService servico) {
    this.servico = servico;  
  }

  @GetMapping() // faz um get na raiz
  public Iterable<Servico> get() {  
    return this.servico.findAll();  
  }

  @GetMapping("{id}") // espera um id na requisição
  public Servico get(@PathVariable Integer id) {
    return this.servico.findById(id);
  }

  @PostMapping()
  public Servico post(@RequestBody Servico servico) { // espera um body com dados de um servico
    return this.servico.saveService(servico);
  }

  @PutMapping("/update")
  public Servico put(@RequestBody Servico servico) {
    // System.out.println(servico.getNome());
    return this.servico.updateService(servico);
  }


}
