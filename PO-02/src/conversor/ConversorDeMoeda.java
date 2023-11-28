package conversor;

import java.util.Scanner;

public class ConversorDeMoeda {

    static Scanner sc = new Scanner(System.in);
    private static double valorEmDolar;
    private static double taxaDeCambio;

    public static void main(String[] args) {
        insereInformacoes();
        converteDolarParaMoeda();
    }

    public static void insereInformacoes(){
        System.out.print("Digite a quantidade em dolar: ");
        valorEmDolar = sc.nextDouble();
        System.out.print("Digite a taxa de cambio: ");
        taxaDeCambio = sc.nextDouble();
    }

    public static void converteDolarParaMoeda(){
        double valorConvertido = valorEmDolar * taxaDeCambio;
        System.out.println(valorEmDolar + " convertido para a outra moeda = $" + valorConvertido);
    }
}