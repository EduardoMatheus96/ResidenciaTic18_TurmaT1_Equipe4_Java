package manipulaArray;

import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {
	public static int[] criarArrayDoUsuario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o tamanho do Array: ");
		int tamanho = scanner.nextInt();
		
		int[] array = new int[tamanho];
		
		System.out.println("Digite os elementos do array");
		
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Elemento " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
		}
		
		return array;
	}
	
	public static int[] criarArrayAleatorio(int tamanho, int valorMinimo, int valorMaximo) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
        }

        return array;
    }
	
	public static int calcularSoma(int[] array) {
        int soma = 0;

        for (int elemento : array) {
            soma += elemento;
        }

        return soma;
    }
	
	 public static int encontrarMaiorValor(int[] array) {
	        int maior = array[0];

	        for (int elemento : array) {
	            if (elemento > maior) {
	                maior = elemento;
	            }
	        }

	        return maior;
	    }
	 
	 public static int encontrarMenorValor(int[] array) {
	        int menor = array[0];

	        for (int elemento : array) {
	            if (elemento < menor) {
	                menor = elemento;
	            }
	        }

	        return menor;
	    }
	 
	 public static void exibirArray(String mensagem, int[] array) {
	        System.out.println(mensagem);
	        for (int elemento : array) {
	            System.out.print(elemento + " ");
	        }
	        System.out.println();
	    }
	 
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Testando a criação de array lido do usuário
	        int[] arrayUsuario = criarArrayDoUsuario();
	        exibirArray("Array lido do usuario:", arrayUsuario);

	        // Testando a criação de array aleatório
	        int[] arrayAleatorio = criarArrayAleatorio(5, 1, 100);
	        exibirArray("Array aleatorio:", arrayAleatorio);

	        // Testando a soma dos elementos do array
	        int soma = calcularSoma(arrayUsuario);
	        System.out.println("A soma dos elementos do array lido do usuario eh: " + soma);

	        // Testando o maior e menor valor do array
	        int maiorValor = encontrarMaiorValor(arrayUsuario);
	        int menorValor = encontrarMenorValor(arrayUsuario);

	        System.out.println("O maior valor do array lido do usuario eh: " + maiorValor);
	        System.out.println("O menor valor do array lido do usuario eh: " + menorValor);

	        scanner.close();
	    }
	
}
