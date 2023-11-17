package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorDoTerreno, int prazoFinanciamento, double taxaJurosAnual ) {
        super(valorDoTerreno, prazoFinanciamento, taxaJurosAnual);
    }
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = super.calcularPagamentoMensal();
        pagamentoMensal += pagamentoMensal * 0.02;
        return pagamentoMensal;
    }
}
