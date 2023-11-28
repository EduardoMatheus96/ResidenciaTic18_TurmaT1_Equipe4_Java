package manipulaArray;

import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = sc.nextInt();

        var vetorDigitado = criaVetor(tamanho);
        var vetorAleatorio = criaVetorAleatorio(tamanho);

        System.out.println("Vetor criado com valores inseridos:");
        for(int i = 0; i < tamanho; i++){
            System.out.print(vetorDigitado[i] + " ");
        }
        System.out.println();

        System.out.println("Vetor criado com valores aleatorios:");
        for(int i = 0; i < tamanho; i++){
            System.out.print(vetorAleatorio[i] + " ");
        }
        System.out.println();

        int somaVetorDigitado = somaElementos(vetorDigitado);
        int somaVetorAleatorio = somaElementos(vetorAleatorio);
        System.out.println("Soma dos elementos do vetor digitado: " + somaVetorDigitado);
        System.out.println("Soma dos elementos do vetor aleatorio: " + somaVetorAleatorio);

        int maiorElementoVetorDigitado = maiorElemento(vetorDigitado);
        int maiorElementoVetorAleatorio = maiorElemento(vetorAleatorio);
        System.out.println("Maior elemento do vetor digitado eh: " + maiorElementoVetorDigitado);
        System.out.println("Maior elemento do vetor aleatorio eh: " + maiorElementoVetorAleatorio);

        int menorElementoVetorDigitado = menorElemento(vetorDigitado);
        int menorElementoVetorAleatorio = menorElemento(vetorAleatorio);
        System.out.println("Menor elemento do vetor digitado eh: " + menorElementoVetorDigitado);
        System.out.println("Menor elemento do vetor aleatorio eh: " + menorElementoVetorAleatorio);

    }

    public static int[] criaVetor(int tamanho){
        int[] vetor = new int[tamanho];
        System.out.println("Digite os valores do vetor:");
        for(int i = 0; i < tamanho; i++){
            System.out.print("Valor " + i + ": ");
            vetor[i] = sc.nextInt();
        }

        return vetor;
    }

    public static int[] criaVetorAleatorio(int tamanho){
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for(int i = 0; i < tamanho; i++){
            vetor[i] = random.nextInt(1000) + 1;
        }

        return vetor;
    }

    public static int somaElementos(int[] vetor){
        int soma = 0;

        for(int elemento : vetor){
            soma += elemento;
        }

        return soma;
    }

    public static int maiorElemento(int[] vetor){
        int maior = vetor[0];

        for(int elemento : vetor) {
            if(elemento > maior) maior = elemento;
        }

        return maior;
    }

    public static int menorElemento(int[] vetor){
        int menor = vetor[0];

        for(int elemento : vetor) {
            if(elemento < menor) menor = elemento;
        }

        return menor;
    }
}
