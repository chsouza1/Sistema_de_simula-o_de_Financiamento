package util;
import java.util.Scanner;

public class InterfaceUsuario {
    private static Scanner scanner = new Scanner(System.in);

    public static double pedirValorCasa() {
        double valorDaCasa;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valorDaCasa = scanner.nextDouble();
            if (valorDaCasa <= 0) {
                System.out.println("O valor do imóvel deve ser um número positivo. Tente novamente.");
            }
        } while (valorDaCasa <= 0);
        return valorDaCasa;
    }

    public static int pedirPrazoFinanciamento() {
        int prazoFinanciamento;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazoFinanciamento = scanner.nextInt();
            if (prazoFinanciamento <= 0) {
                System.out.println("O prazo de financiamento deve ser um número positivo. Tente novamente.");
            }
        } while (prazoFinanciamento <= 0);
        return prazoFinanciamento;
    }


    public static double pedirTaxaDeJurosAnual() {
        double taxaDeJuros;
        do {
            System.out.print("Digite a taxa de juros anual: ");
            taxaDeJuros = scanner.nextDouble();
            if (taxaDeJuros <= 0) {
                System.out.println("A taxa de juros anual deve ser um número positivo. Tente novamente.");
            }
        } while (taxaDeJuros <= 0);
        return taxaDeJuros;
    }
    public static  void fecharScanner() {
        scanner.close();
    }
}
