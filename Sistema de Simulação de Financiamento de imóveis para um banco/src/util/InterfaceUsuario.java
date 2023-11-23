package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private static Scanner scanner = new Scanner(System.in);

    public static String pedirTipoFinanciamento() {
        try {
            System.out.print("Informe o tipo de financiamento (casa, apartamento, terreno): ");
            return scanner.next();
        }catch (InputMismatchException e) {
            System.out.println("Entrada inválida. O tipo de financiamento deve ser uma string.");
            scanner.nextLine();
            return pedirTipoFinanciamento();
        }
    }

    public static double pedirTamanhoAreaConstruida() {
        try {
            System.out.println("Informe o tamanho da área construída: ");
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor insira um número.");
            scanner.nextLine();
            return pedirTamanhoAreaConstruida();
        }
    }
    public static double pedirTamanhoTerreno() {
        try {
            System.out.println("Informe o tamanho do terreno: ");
            return scanner.nextDouble();
        }catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor insira um número.");
            scanner.nextLine();
            return pedirTamanhoTerreno();
        }
    }

    public static String pedirTipoZona() {
        try {
            System.out.println("Informe o tipo da zona: ");
            return scanner.next();
        } catch (InputMismatchException e){
            System.out.println("Entrada inválida. O tipo da zona deve ser uma string.");
            scanner.nextLine();
            return pedirTipoZona();
        }
    }

    public static int pedirnumeroVagasGaragem() {
        try {
            System.out.println("Informe o Numero de Garagem que deseja: ");
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            scanner.nextLine();
            return pedirnumeroVagasGaragem();
        }
    }
    public static int pedirnumeroAndar() {
        try {
            System.out.println("Informe o numero de Andar: ");
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            scanner.nextLine();
            return pedirnumeroAndar();
        }
    }

    public static double pedirValorCasa() {
        double valorDaCasa;
        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorDaCasa = scanner.nextDouble();
                if (valorDaCasa <= 0) {
                    System.out.println("O valor do imóvel deve ser um número positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
                valorDaCasa = -1;
            }
        } while (valorDaCasa <= 0);
        return valorDaCasa;
    }

    public static int pedirPrazoFinanciamento() {
        int prazoFinanciamento;
        do {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0) {
                    System.out.println("O prazo de financiamento deve ser um número positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpar o buffer do scanner
                prazoFinanciamento = -1; // Definir um valor inválido para forçar a repetição do loop
            }
        } while (prazoFinanciamento <= 0);
        return prazoFinanciamento;
    }


    public static double pedirTaxaDeJurosAnual() {
        double taxaDeJuros;
        do {
            try {
                System.out.print("Digite a taxa de juros anual: ");
                taxaDeJuros = scanner.nextDouble();
                if (taxaDeJuros <= 0) {
                    System.out.println("A taxa de juros anual deve ser um número positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                taxaDeJuros = -1; // Definir um valor inválido para forçar a repetição do loop
            }
        } while (taxaDeJuros <= 0);
        return taxaDeJuros;

    }
    public static void fecharScanner() {
        scanner.close();
    }
}
