package br.unb.leilas.api.domain.entities;
import java.util.ArrayList;

import antlr.collections.List;
import br.unb.leilas.api.domain.entities.base.BaseEntity;

public class Servico extends BaseEntity{
  private String nome;
  private String descricao;
  private double valor;
  private ArrayList<String> imagens = new ArrayList();
  private double nota;

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
  public ArrayList<String> getImagens() {
    return this.imagens;
  }
  public String getOneImage(int key) {
    return this.imagens.get(key);
  }
  public void setOneImage(int key, String imagem) {
    this.imagens.add(key, imagem);
  }
  public void setImagens(ArrayList<String> imagens) {
    this.imagens = imagens;
  }
  public double getNota() {
    return this.nota;
  }
  public void setNota(double nota) {
    this.nota = nota;
  }
  
  
}
