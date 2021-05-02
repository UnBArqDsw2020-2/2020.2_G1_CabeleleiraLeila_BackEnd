package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
  name = "tipo",
  length = 2,
  discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("P")
@Table(name = "pessoa")
public class Pessoa extends BaseEntity {

  private String nome;
  private LocalDate nascimento;
  private String telefone;
  private String rg;
  private String rgEmissor;

  @Column(unique = true)
  private String cpf;

  @Column(insertable = false, updatable = false) // atributo tipo é realmente inalterável?
  private String tipo;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "autenticacao_id", referencedColumnName = "id")
  private Autenticacao autenticacao;

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getRg() {
    return this.rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getRgEmissor() {
    return this.rgEmissor;
  }

  public void setRgEmissor(String rgEmissor) {
    this.rgEmissor = rgEmissor;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getNascimento() {
    return nascimento;
  }

  public void setNascimento(LocalDate nascimento) {
    this.nascimento = nascimento;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) { // atributo tipo é realmente inalterável?
    this.tipo = tipo;
  }

  public Autenticacao getAutenticacao() {
    return autenticacao;
  }

  public void setAutenticacao(Autenticacao autenticacao) {
    this.autenticacao = autenticacao;
  }
}
