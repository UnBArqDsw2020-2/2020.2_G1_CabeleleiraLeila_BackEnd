package br.unb.leilas.api.web.resources;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unb.leilas.api.domain.entities.Pessoa;
import br.unb.leilas.api.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    private final PessoaService service;

    public PessoaResource(PessoaService service) {
        this.service = service;
    }

    @GetMapping()
    public Iterable<Pessoa> get() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Pessoa get(@PathVariable Integer id) {
        return this.service.findById(id);
    }

    @PostMapping()
    public Pessoa post(@RequestBody Pessoa pessoa) {
        return this.service.save(pessoa);
    }

    @PostMapping("/all")
    public Iterable<Pessoa> post(@RequestBody Iterable<Pessoa> list) {
        return this.service.saveAll(list);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.deleteById(id);
    }

}
