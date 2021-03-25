package br.unb.leilas.api.domain.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorValue(value = "S")

public class Servico extends BaseEntity{
  private String descricao;
  private double valor;
  private String imagem;
  private double nota;
  @Column(unique = true)
  private String nome;

  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getDescricao() {
    return this.descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public double getValor() {
    return this.valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }
  public String getImagem() {
    return this.imagem;
  }
  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  public double getNota() {
    return this.nota;
  }
  public void setNota(double nota) {
    this.nota = nota;
  }
  
}
