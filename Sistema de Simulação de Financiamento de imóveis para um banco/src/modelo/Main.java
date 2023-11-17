package modelo;

import java.util.ArrayList;
import util.InterfaceUsuario;
import modelo.Financiamento;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Cria uma ArrayList para armazenar objetos de Financiamento
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Variáveis para armazenar o total dos valores dos imóveis e financiamentos
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        // Pedir informações para o primeiro financiamento
        for (int i = 1; i <= 4; i++) {
            double valorDaCasa = InterfaceUsuario.pedirValorCasa();
            int prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = InterfaceUsuario.pedirTaxaDeJurosAnual();

            // Cria um objeto Financiamento com as informações forncecidas.
            Financiamento financiamento = new Financiamento(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
            financiamentos.add(financiamento);

            // atualiza o total dos valores dos imóveis e financiamentos.
            totalValorImoveis += valorDaCasa;
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();

            // Formata uma string com a informações do financiamento e a imprime
            String financiamentoInfor = String.format("Financiamento %d - valor do imovel: R$ %.2f, valor do financiamento: R$ %.2f",
                    i, valorDaCasa, financiamento.calcularTotalPagamento());

            // imprime as informações dos financiamentos.
            System.out.println(financiamentoInfor);

        }
        // Imprime o total dos valores do imóveis e financiamentos.
        System.out.println("Total de todos os imóveis: R$ " + String.format("%.2f", totalValorImoveis));
        System.out.println("Total de todos os financiamentos: " + String.format("%.2f", totalValorFinanciamentos));

        // Fecha o Scanner.
        InterfaceUsuario.fecharScanner();
    }
}
