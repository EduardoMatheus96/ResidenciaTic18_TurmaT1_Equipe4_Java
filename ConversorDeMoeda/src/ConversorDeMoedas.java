import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ConversorDeMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try {
            // Pedir ao usuário para inserir a taxa de câmbio
            System.out.print("Insira a taxa de câmbio de uma moeda para outra (quantos reais ou euros valem 1 dólar): ");
            double taxaDeCambio = scanner.nextDouble();

            // Pedir ao usuário para inserir a quantidade em dólares
            System.out.print("Insira a quantidade em dólares: ");
            double quantidadeEmDolares = scanner.nextDouble();

            // Calcular o valor convertido
            double valorConvertido = quantidadeEmDolares * taxaDeCambio;

            // Exibir o valor convertido
            System.out.println("O valor convertido é: " + valorConvertido);
            
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um valor numérico válido.");
        } finally {
            scanner.close();
        }
    }
}
