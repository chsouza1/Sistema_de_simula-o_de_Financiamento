package modelo;

public class Casa extends Financiamento {

    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorDaCasa,prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = super.calcularPagamentoMensal();
        pagamentoMensal += 80;
        return pagamentoMensal;
    }
}