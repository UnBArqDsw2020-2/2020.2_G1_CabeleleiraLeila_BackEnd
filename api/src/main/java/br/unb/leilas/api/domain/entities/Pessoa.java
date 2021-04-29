package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.DiscriminatorType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
@Table(name = "pessoa")

public class Pessoa extends BaseEntity{

    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String rg;
    @Column(name ="rg_emissor")
    private String rgEmissor;
    @Column(unique = true)
    private String cpf;
    @Column(insertable=false, updatable=false) // atributo tipo é realmente inalterável?
    private String tipo;
    private String cnpj;
    private String alvara;

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

  
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autenticacao_id", referencedColumnName = "id")
    private Autenticacao autenticacao;


    @ElementCollection
    private List<String> interesses = new ArrayList<>();
  
    @ElementCollection
    private List<String> observacoes = new ArrayList<>();
  
    @OneToMany(mappedBy = "pessoa")
    private List<Pedido> pedidos;

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

    public String getTelefone() {
      return telefone;
    }

    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }

    public String getRg() {
      return rg;
    }

    public void setRg(String rg) {
      this.rg = rg;
    }

    public String getRgEmissor() {
      return rgEmissor;
    }

    public void setRgEmissor(String rgEmissor) {
      this.rgEmissor = rgEmissor;
    }

    public String getCpf() {
      return cpf;
    }

    public void setCpf(String cpf) {
      this.cpf = cpf;
    }

    public String getTipo() {
      return tipo;
    }

    public void setTipo(String tipo) {
      this.tipo = tipo;
    }

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

    public Autenticacao getAutenticacao() {
      return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
      this.autenticacao = autenticacao;
    }

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

    public List<Pedido> getPedidos() {
      return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
      this.pedidos = pedidos;
    }
  

}
