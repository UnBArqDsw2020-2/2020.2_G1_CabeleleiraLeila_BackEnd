package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido extends BaseEntity implements Serializable {

  @Column
  private Integer valor;
  private Date data;
  private boolean confirmado;

  @ManyToOne
  @JoinColumn(name="cliente_id", nullable=false)
  public Cliente cliente;

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public Date getData() {
    return this.data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public boolean isConfirmado() {
    return this.confirmado;
  }

  public boolean getConfirmado() {
    return this.confirmado;
  }

  public void setConfirmado(boolean confirmado) {
    this.confirmado = confirmado;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
