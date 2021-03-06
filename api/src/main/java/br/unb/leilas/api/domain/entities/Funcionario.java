package br.unb.leilas.api.domain.entities;

import java.util.*;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class Funcionario extends Pessoa {

  private String foto;

  @ElementCollection
  private Set<String> especialidades = new HashSet<>();

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Set<String> getEspecialidades() {
    return especialidades;
  }

  public void setEspecialidades(Set<String> especialidades) {
    this.especialidades = especialidades;
  }
}
