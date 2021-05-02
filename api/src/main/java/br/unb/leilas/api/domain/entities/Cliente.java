package br.unb.leilas.api.domain.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name="cliente_id")
public class Cliente extends Pessoa {

  @ElementCollection
  private List<String> interesses = new ArrayList<>();

  @ElementCollection
  private List<String> observacoes = new ArrayList<>();

  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos;

  public List<String> getInteresses() {
    return interesses;
  }

  public void setInteresses(List<String> interesses) {
    this.interesses = interesses;
  }

  public List<String> getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(List<String> observacoes) {
    this.observacoes = observacoes;
  }
}
