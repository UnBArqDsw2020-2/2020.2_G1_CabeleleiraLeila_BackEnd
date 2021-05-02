package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido extends BaseEntity implements Serializable {

  @Column(nullable = false)
  private Integer valor;

  @Column(nullable = false)
  private Date data;

  @Column(nullable = false)
  private boolean confirmado;

  @JsonIgnoreProperties(
    {
      "autenticacao", "interesses", "nascimento", "nome", "observacoes", "tipo", "telefone", "rg", "rgEmissor" , "cpf"
    }
  )
  @ManyToOne
  @JoinColumn(name = "cliente", nullable = false)
  private Cliente cliente;

  @ManyToMany
  @JoinTable(
    name = "pedido_tem_servico",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "servico_id")
  )
  private List<Servico> servicos;

  public List<Servico> getServicos() {
    return this.servicos;
  }

  public void setServicos(List<Servico> servicos) {
    this.servicos = servicos;
  }

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
