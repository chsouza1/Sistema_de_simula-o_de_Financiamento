package modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;
    public double valorDoApartamento;
    public Apartamento(double valorDoApartamento, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem,
                       int numeroAndar) {
        super(valorDoApartamento, prazoFinanciamento, taxaJurosAnual);
        this.valorDoApartamento = valorDoApartamento;
        super.prazoFinanciamento = prazoFinanciamento;
        super.taxaJurosAnual = taxaJurosAnual;
        this.numeroAndar = 0;
        this.valorDoApartamento = valorDoApartamento;
        this.numeroVagasGaragem = 0;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = taxaJurosAnual / 12;
        double meses = prazoFinanciamento * 12;

        return valorDoApartamento * (taxaMensal * (1 + taxaMensal) * meses) / ((1 + taxaMensal) - 1);
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public double getvalorDoApartamento() {
        return valorDoApartamento;
    }
}
