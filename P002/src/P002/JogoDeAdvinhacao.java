package P002;
import java.lang.Math;
import java.util.Scanner;

public class JogoDeAdvinhacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int numRandom = (int)(Math.random() * 100) + 1;
        int numeroDoUsuario;
        int tentativas=0;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Tente adivinhar qual é meu numero aleatorio. Entre 1 e 100. Digite -1 para desistir.");
			numeroDoUsuario = entrada.nextInt();
			tentativas++;
			
			if (numeroDoUsuario != -1) {
				if (numeroDoUsuario == numRandom) {
					System.out.println("Parabens! Você acertou!!! Quantidade de tentativas: " + tentativas);
					break;
				}else if (numeroDoUsuario>numRandom) {
					System.out.println("O numero " + numeroDoUsuario + " é muito alto!!!!");
				}else {
					System.out.println("O numero " + numeroDoUsuario + " é muito baixo!!!! ");
				}
			}
		} while (numeroDoUsuario != -1);
		if(numeroDoUsuario==-1) {
			System.out.println("Que pena! Você desistiu!!! Meu numero aleatorio era: " + numRandom);
			
		}
		
		entrada.close();
	}

}
