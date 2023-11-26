package conversor_Moeda;

import java.util.Scanner;

public class Conversor_Moeda {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira a taxa de cambio: ");
		double taxaDeCambio = scanner.nextDouble();
		
		System.out.println("Insira a quantidade em dolares: ");
		double quantidadeEmDolares = scanner.nextDouble();
		
		double valorConvertido = quantidadeEmDolares * taxaDeCambio;
		
		System.out.println("O valor convertido eh: " + valorConvertido);
		
	}
}
