package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(
  name = "agendamento",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "data", "hora" }) }
)
public class Agendamento extends BaseEntity {

  @Column(nullable=false)
  private LocalDate data;
  @Column(nullable=false)
  private Integer hora;

  @OneToOne
  @JoinColumn(name = "servico_id")
  private Servico servico;

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
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
