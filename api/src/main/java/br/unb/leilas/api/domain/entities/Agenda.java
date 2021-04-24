package br.unb.leilas.api.domain.entities;

import java.util.Date;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

public class Agenda extends BaseEntity {
   private Pedido[] pedidos;
   private Date date;

   public Agenda(){
      this.date = new Date();
   }

   public Agenda(Date data){
      setDate(data);
   }

   public Pedido[] getPedidos() {
      return pedidos;
   }

   public void setPedidos(Pedido[] pedidos) {
      this.pedidos = pedidos;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }
   
}
