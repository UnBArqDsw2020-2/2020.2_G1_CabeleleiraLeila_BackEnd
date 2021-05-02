package br.unb.leilas.api.domain.entities.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unb.leilas.api.domain.entities.Autenticacao;
import br.unb.leilas.api.domain.entities.Cliente;

public class ClienteDTO extends BaseDTO<Cliente>{

  private String username;
  private String password1;
  private String password2;

  private String email;
  private String nome;
  private LocalDate nascimento;
  private String telefone;
  private String rg;
  private String cpf;
  
  private Autenticacao autenticacao;

  public String getUsername() {
    return username;
  }

  public Autenticacao getAutenticacao() {
    return autenticacao;
  }

  public void setAutenticacao(Autenticacao autenticacao) {
    this.autenticacao = autenticacao;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword1() {
    return password1;
  }

  public void setPassword1(String password1) {
    this.password1 = password1;
  }

  public String getPassword2() {
    return password2;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Cliente paraEntidade() {

    Cliente cliente = new Cliente();

    cliente.setAutenticacao(autenticacao);
    cliente.setNome(nome);
    cliente.setId(getId());
    cliente.setNascimento(nascimento);
    cliente.setTelefone(telefone);
    cliente.setCpf(cpf);

    return cliente;
  }

  public static ClienteDTO paraDto(Cliente cliente){
    ClienteDTO dto = new ClienteDTO();
    dto.setId(cliente.getId());
    dto.setNome(cliente.getNome());
    dto.setNascimento(cliente.getNascimento());

    Autenticacao autenticacao = new Autenticacao();
    autenticacao.setRoles(cliente.getAutenticacao().getRoles());
    autenticacao.setLogin(cliente.getAutenticacao().getLogin());
    dto.setAutenticacao(autenticacao);
    return dto;
  }

  public static List<ClienteDTO> paraDto(List<Cliente> lista){
      List<ClienteDTO> dtos = new ArrayList<>();
      lista
        .stream()
        .forEach(cliente-> dtos.add(ClienteDTO.paraDto(cliente)));
      return dtos;
  }
}
