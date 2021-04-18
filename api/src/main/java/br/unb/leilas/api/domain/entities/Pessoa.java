package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
@Table(name = "pessoa")

public class Pessoa extends BaseEntity{
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String rg;
    private String rgEmissor;
    @Column(unique = true)
    private String cpf;
    @Column(insertable=false, updatable=false) // atributo tipo é realmente inalterável?
    private String tipo;
  
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autenticacao_id", referencedColumnName = "id")
    private Autenticacao autenticacao;

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

  // private LocalDate nascimento;
  // private String telefone;
  // private String rg;
  // private String rgEmissor;
  // @Column(unique = true)
  // private String cpf;

  // @Transient ignora ao salvar e é retornado nas requisições

  // @JsonIgnore ignora ao ser passado como json nas requisições mas permite
  // persistir

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
