package adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {

    static Random random = new Random();
    static int numero = random.nextInt(100) + 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tente adivinha o numero entre 1 e 100");
        boolean acertou = false;
        do {
            System.out.println("Resposta: ");
            int resposta = sc.nextInt();

            if(resposta == numero){
                System.out.println("Acertou!");
                acertou = true;
            } else if(resposta > numero) System.out.println("Muito alto");
            else System.out.println("Muito baixo");
        } while(!acertou);
    }
}
