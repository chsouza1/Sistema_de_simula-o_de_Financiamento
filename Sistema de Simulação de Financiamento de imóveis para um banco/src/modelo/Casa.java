package modelo;

public class Casa extends Financiamento {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida,
                double tamanhoTerreno) {
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoTerreno = tamanhoTerreno;
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = calcularPagamentoMensal();
        pagamentoMensal += 80;
        return pagamentoMensal;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }
}
