import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário
        Random random = new Random(); // Gera um número aleatório entre 0 e 99

        int numeroAleatorio = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100 
        int tentativas = 0;
        int palpite;

        System.out.println("Bem-vindo ao Jogo de Adivinhação!"); 
        System.out.println("Tente adivinhar o número entre 1 e 100.");
        
        do {
            System.out.print("Insira seu palpite: ");
            palpite = scanner.nextInt(); // Recebe o palpite do usuário
            tentativas++; // Incrementa o número de tentativas

            if (palpite > numeroAleatorio) {
                System.out.println("Alto! Tente um número mais baixo.");
            } else if (palpite < numeroAleatorio) {
                System.out.println("Baixo! Tente um número mais alto.");
            } else {
                System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas.");
            }
            if (tentativas == 3) {
                System.out.println("Dica: Divida o número por 2 até a menor fração. De alta ou de baixa!");
            }
        } while (palpite != numeroAleatorio); // Enquanto o palpite for diferente do número

        scanner.close(); // Fecha o objeto Scanner
    }
}
