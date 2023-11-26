package jogoAdivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int numeroAleatorio = random.nextInt(100) + 1;
		
		System.out.println("Bem vindo ao Jogo de Adivinhacao!");
		System.out.println("Tente adivinhar o número entre 1 e 100.");
		
		int tentativas = 0;
		int palpite;
		
		do {
			System.out.println("Digite seu palpite: ");
			palpite = scanner.nextInt();
			
			if (palpite == numeroAleatorio) {
				System.out.println("Parabens! Voce acertou o numero em: " + (tentativas + 1) + " tentativas.");
				
			} else if(palpite < numeroAleatorio) {
				System.out.println("Muito baixo. Tente novamente.");
			} else {
				System.out.println("Muito alto. Tente novamente.");
			}
			
			tentativas++;
			
		} while (palpite != numeroAleatorio);
	
		scanner.close();
	}
	
}
