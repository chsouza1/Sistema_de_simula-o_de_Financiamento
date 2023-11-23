package modelo;

import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import util.InterfaceUsuario;
import modelo.Financiamento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ClassNotFoundException;

import java.util.Scanner;

import javax.swing.*;

public class Main {

    public class SalvarFinanciamentos {
        public static void main(String[] args) {

            // Cria uma ArrayList para armazenar objetos de Financiamento
            ArrayList<Financiamento> financiamentos = new ArrayList<>();

            salvarFinanciamento(financiamentos);
            ArrayList<Financiamento> financiamentosLidos = lerFinanciamentos();

            for (Financiamento financiamento : financiamentosLidos) {
                System.out.println(financiamento);
            }


            financiamentos.add(new Terreno(5000, 15, 0.05, "Rural"));
            financiamentos.add(new Apartamento(7000, 20, 0.07, 2, 4));

            try {
                File file = new File("financiamentos.txt");
                FileWriter writer = new FileWriter(file);

                for (Financiamento financiamento : financiamentos) {
                    String dadosFinanciamento = financiamento.getValorDaCasa() + " " + " " + financiamento.getTaxaJurosAnual() + " " + financiamento.getPrazoFinanciamento();
                    if (financiamento instanceof Terreno) {
                        Terreno terreno = (Terreno) financiamento;
                        dadosFinanciamento += " " + terreno.getTipoZona();
                    } else if (financiamento instanceof Apartamento) {
                        Apartamento apartamento = (Apartamento) financiamento;
                        dadosFinanciamento += " " + apartamento.getNumeroAndar();
                    }
                    writer.write(dadosFinanciamento + "\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Erro ao salvar os dados de financiamento");
                e.printStackTrace();
            }
            try {
                File file = new File("financiamentos.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String[] dados = scanner.nextLine().split(" ");
                    double valorDaCasa = Double.parseDouble(dados[0]);
                    double taxaJurosAnual = Double.parseDouble(dados[1]);
                    int prazoFinanciamento = Integer.parseInt(dados[3]);

                    if (dados.length == 5) {
                        Terreno terreno = new Terreno(valorDaCasa, prazoFinanciamento, taxaJurosAnual, dados[4]);
                        System.out.println(terreno);
                    } else if (dados.length == 6) {
                        Apartamento apartamento = new Apartamento(valorDaCasa, prazoFinanciamento, taxaJurosAnual, 0, 0);
                        System.out.println(apartamento);
                    }
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler os dados de financiamento.");
                e.printStackTrace();
            }
            // Variáveis para armazenar o total dos valores dos imóveis e financiamentos
            double totalValorImoveis = 0;
            double totalValorFinanciamentos = 0;

            // Pedir informações para o primeiro financiamento
            for (int i = 1; i <= 4; i++) {
                double valorDaCasa = InterfaceUsuario.pedirValorCasa();
                int prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
                double taxaJurosAnual = InterfaceUsuario.pedirTaxaDeJurosAnual();

                Financiamento financiamento = null;

                String tipoFinanciamento = InterfaceUsuario.pedirTipoFinanciamento().toLowerCase();

                switch (tipoFinanciamento) {
                    case "casa":
                        double tamanhoAreaConstruida = InterfaceUsuario.pedirTamanhoAreaConstruida();
                        double tamanhoTerreno = InterfaceUsuario.pedirTamanhoTerreno();
                        financiamento = new Casa(valorDaCasa, prazoFinanciamento, taxaJurosAnual,
                                tamanhoAreaConstruida, tamanhoTerreno);
                        break;

                    case "terreno":
                        String tipoZona = InterfaceUsuario.pedirTipoZona();
                        financiamento = new Terreno(valorDaCasa, prazoFinanciamento, taxaJurosAnual, tipoZona);
                        break;

                    case "apartamento":
                        int numeroVagasGaragem = InterfaceUsuario.pedirnumeroVagasGaragem();
                        int numeroAndar = InterfaceUsuario.pedirnumeroAndar();
                        financiamento = new Apartamento(valorDaCasa, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem,
                                numeroAndar);
                        break;

                    default:
                        System.out.println("Tipo de financiamento inválido. Tente novamente.");
                        i--;
                        break;
                }
                if (financiamento != null) {
                    financiamentos.add(financiamento);
                    totalValorImoveis += valorDaCasa;
                    totalValorFinanciamentos += financiamento.calcularTotalPagamento();

                    String financiamentoInfo = String.format("Financiamento %d - valor do Imóvel: R$ %.2f, valor do financiamento: R$ %.2f",
                            i, valorDaCasa, financiamento.calcularPagamentoMensal());
                    System.out.println(financiamentoInfo);

                }

            }

            // Imprime o total dos valores do imóveis e financiamentos.
            System.out.println("Total de todos os imóveis: R$ " + String.format("%.2f", totalValorImoveis));
            System.out.println("Total de todos os financiamentos: " + String.format("%.2f", totalValorFinanciamentos));

            // Fecha o Scanner.
            InterfaceUsuario.fecharScanner();
        }

        private static void salvarFinanciamento(ArrayList<Financiamento> financiamentos) {
            try {
                FileInputStream fileIn = new FileInputStream("financiamento.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                ArrayList<Financiamento> financiamentosSalvos = (ArrayList<Financiamento>) in.readObject();
                in.close();
                fileIn.close();
                System.out.print("Financiamentos desserializados com sucesso");
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.print("Classe não encontrada");
                c.printStackTrace();
            }
        }

        private static ArrayList<Financiamento> lerFinanciamentos() {
            ArrayList<Financiamento> financiamentosLidos = new ArrayList<>();
            try (FileInputStream fileIn = new FileInputStream("caminho/do/arquivo.txt")) {

            } catch (IOException e) {
                e.printStackTrace();
            }
            return financiamentosLidos;
        }
    }

}
