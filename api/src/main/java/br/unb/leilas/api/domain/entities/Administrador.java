package br.unb.leilas.api.domain.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Funcionario {

  private String cnpj;
  private String alvara;

  @Column(name = "inscricao_estadual")
  private String inscricaoEstadual;

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getAlvara() {
    return alvara;
  }

  public void setAlvara(String alvara) {
    this.alvara = alvara;
  }

  public String getInscricaoEstadual() {
    return inscricaoEstadual;
  }

  public void setInscricaoEstadual(String inscricaoEstadual) {
    this.inscricaoEstadual = inscricaoEstadual;
  }
}
