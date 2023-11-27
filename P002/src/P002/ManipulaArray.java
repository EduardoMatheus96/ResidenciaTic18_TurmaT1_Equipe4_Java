package P002;

import java.util.Scanner;

public class ManipulaArray {
	
	
	public static int[] criarArrayDadosDigitados() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o tamanho do array: ");
	    int tamanho = entrada.nextInt();

	    int[] array = new int[tamanho];
	    System.out.println("Informe os elementos do array:");

	    for (int i = 0; i < tamanho; i++) {
	    	System.out.print("Elemento " + (i + 1) + ": ");
	        array[i] = entrada.nextInt();
	     }
	    entrada.close();
	    return array;
	}
	

	public static int[] criarArrayDadosAleatorios(int tamanho) {
		int[] array = new int[tamanho];

	    for (int i = 0; i < tamanho; i++) {
	    	array[i] =  (int)(Math.random() * 100) + 1;
	    }
	    return array;
	}
	
	public static int somaElementos(int[] array){
		int soma = 0;
        for (int elemento : array) {
            soma += elemento;
        }
        
        return soma;
	}
	public static void exibirElementos(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
		}
		System.out.println("]");
	}
	public static int maiorValor(int[] array) {
        int maior = array[0];
        for (int elemento : array) {
            if (elemento > maior) {
                maior = elemento;
            }
        }
        return maior;
    }

    public static int menorValor(int[] array) {
        int menor = array[0];
        for (int elemento : array) {
            if (elemento < menor) {
                menor = elemento;
            }
        }
        return menor;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arrayUsuario = criarArrayDadosDigitados();
        int[] arrayAleatorios = criarArrayDadosAleatorios(10);
        
        System.out.println("Array de números inteiros lidos do usuário:");
        exibirElementos(arrayUsuario);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Soma dos elementos: " + somaElementos(arrayUsuario));
        System.out.println("Maior valor do array: " + maiorValor(arrayUsuario));
        System.out.println("Menor valor do array: " + menorValor(arrayUsuario));
        
        System.out.println("Array de números inteiros aleatorios:");
        exibirElementos(arrayAleatorios);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Soma dos elementos: " + somaElementos(arrayAleatorios));
        System.out.println("Maior valor: " + maiorValor(arrayAleatorios));
        System.out.println("Menor valor: " + menorValor(arrayAleatorios));
	}

}
