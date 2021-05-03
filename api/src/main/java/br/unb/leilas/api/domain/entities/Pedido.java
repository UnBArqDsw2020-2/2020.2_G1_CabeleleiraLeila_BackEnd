package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido extends BaseEntity implements Serializable {

  @Column(nullable = false)
  private Integer valor;

  @Column(nullable = false)
  private LocalDate data;

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
    name = "pedido_tem_agendamento",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "agendamento_id")
  )
  private List<Agendamento> agendamentos;

  public List<Agendamento> getAgendamentos() {
    return this.agendamentos;
  }

  public void setAgendamentos(List<Agendamento> agendamentos) {
    this.agendamentos = agendamentos;
  }

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
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
