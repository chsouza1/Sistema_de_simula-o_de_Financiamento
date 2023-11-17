package modelo;
public abstract class Financiamento {
    protected double valorDaCasa;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public void mostrarDados() {
        System.out.println("Valor total do financiamento: " + calcularTotalPagamento());
        System.out.println("Valor do imovel: " + getValorDaCasa());
    }
    public abstract class Financiamento(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorDaCasa = valorDaCasa;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public abstract double calcularTotalPagamento();

    public double getValorDaCasa() {
        return valorDaCasa;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }