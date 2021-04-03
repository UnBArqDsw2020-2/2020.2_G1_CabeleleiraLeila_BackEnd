package br.unb.leilas.api.domain.entities;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "autenticacao")
public class Autenticacao extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  private String login;
  private String senha;
  private String email;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
    name = "autenticacao_permissao",
    joinColumns = {
      @JoinColumn(name = "autenticacao_id", referencedColumnName = "id"),
    },
    inverseJoinColumns = { @JoinColumn(name = "permissao_descricao") }
  )
  private Set<Permissao> permissoes = new HashSet<>();

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
