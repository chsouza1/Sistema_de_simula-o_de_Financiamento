package modelo;

public abstract class Financiamento {
    protected double valorDaCasa;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    protected double tamanhoAreaConstruida;
    protected double tamanhoTerreno;


    public Financiamento(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorDaCasa = valorDaCasa;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public double getValorDaCasa() {
        return valorDaCasa;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
}