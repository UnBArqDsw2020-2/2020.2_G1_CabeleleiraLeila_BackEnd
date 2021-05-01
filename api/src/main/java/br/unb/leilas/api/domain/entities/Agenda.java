package br.unb.leilas.api.domain.entities;

import java.util.Date;

import br.unb.leilas.api.domain.entities.base.BaseEntity;
// import br.unb.leilas.api.domain.entities.Pedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;

import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "S")
@Table(name = "agenda")

public class Agenda extends BaseEntity {
   // private Pedido[] pedidos;
   @Column(unique = true)
   private String data;

   public Agenda(){
      this.data = new Date().toString();
   }

   // public Agenda(){
   //    this.date = new Date();
   // }

   // public Agenda(Date data){
   //    setDate(data);
   // }

   // public Pedido[] getPedidos() {
   //    return pedidos;
   // }

   // public void setPedidos(Pedido[] pedidos) {
   //    this.pedidos = pedidos;
   // }

   public String getDate() {
      return data;
   }

   public void setDate(String data) {
      this.data = data;
   }
   
}
