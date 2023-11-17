package modelo;

public class Apartamento extends Financiamento {
    public double valorDoApartamento;
    public Apartamento(double valorDoApartamento, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorDoApartamento, prazoFinanciamento, taxaJurosAnual);
        this.valorDoApartamento = valorDoApartamento;
        super.prazoFinanciamento = prazoFinanciamento;
        super.taxaJurosAnual = taxaJurosAnual;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = taxaJurosAnual / 12;
        double meses = prazoFinanciamento * 12;

        return valorDoApartamento * (taxaMensal * (1 + taxaMensal) * meses) / ((1 + taxaMensal) - 1);
    }
}
