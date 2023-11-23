package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;
    public Terreno(double valorDoTerreno, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorDoTerreno, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = calcularPagamentoMensal();
        pagamentoMensal += pagamentoMensal * 0.02;
        return pagamentoMensal;
    }

    public String getTipoZona() {
        return tipoZona;
    }
}
