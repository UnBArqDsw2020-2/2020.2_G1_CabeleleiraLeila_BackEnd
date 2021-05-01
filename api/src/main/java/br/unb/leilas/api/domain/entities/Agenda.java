package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;
// import br.unb.leilas.api.domain.entities.Pedido;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "S")
@Table(
  name = "agenda",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "data", "hora" }) }
)
public class Agenda extends BaseEntity {

  private String data;
  private Integer hora;

  @OneToOne
  @JoinColumn(name = "servico_id")
  private Servico servico;

  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Integer getHora() {
    return this.hora;
  }

  public void setHora(Integer hora) {
    this.hora = hora;
  }

  public Servico getServico() {
    return this.servico;
  }

  public void setServico(Servico servico) {
    this.servico = servico;
  }
}
