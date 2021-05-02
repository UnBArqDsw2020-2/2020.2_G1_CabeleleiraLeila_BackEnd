package br.unb.leilas.api.services.calculates;

public abstract class CalcularBase {
    
    public  final double calcular() {
        double valor = 0;

        valor += this.regular();
        valor += this.extras();

        return valor;
    }

    abstract double regular();
    abstract double extras();
}
