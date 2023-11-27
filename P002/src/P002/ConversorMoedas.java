package P002;

import java.util.Scanner;

public class ConversorMoedas {

	public static void main(String[] args) {
		float vlrDolares, txCambio, valorConvertido;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite seu valor em Dolares: ");
		vlrDolares = entrada.nextFloat();
		
		System.out.println("Digite a taxa de cambio da moeda: ");
		txCambio = entrada.nextFloat();
		
		valorConvertido = txCambio * vlrDolares;
		System.out.println("O valor convertido é: " + valorConvertido);
		
	}

}
