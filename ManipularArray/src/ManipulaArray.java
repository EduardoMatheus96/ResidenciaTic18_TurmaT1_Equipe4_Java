import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayLido = lerArrayDoUsuario(scanner); // Método para criar um array lido do usuário

        System.out.println("\nArray lido do usuário:");
        imprimirArray(arrayLido);

        preencherComValoresAleatorios(arrayLido); // Preencher o restante do array com valores aleatórios
        System.out.println("\nArray com valores aleatórios gerados:");
        imprimirArray(arrayLido);

        // Calculando a soma de todos os elementos em cada array
        int somaArrayLido = calcularSoma(arrayLido);

        System.out.println("\nSoma dos elementos do array final: " + somaArrayLido);

        // Encontrando o maior e o menor valor no array
        int maiorArrayLido = encontrarMaiorValor(arrayLido);
        int menorArrayLido = encontrarMenorValor(arrayLido);

        System.out.println("\nMaior valor no array final: " + maiorArrayLido);
        System.out.println("Menor valor no array final: " + menorArrayLido);

        scanner.close();
    }
      // Método para imprimir o array
      public static void imprimirArray(ArrayList<Integer> array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // Método para calcular a soma de todos os elementos do array
    public static int calcularSoma(ArrayList<Integer> array) {
        int soma = 0;
        for (int num : array) {
            soma += num;
        }
        return soma;
    }

    // Método para encontrar o maior valor no array
    public static int encontrarMaiorValor(ArrayList<Integer> array) {
        int maior = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > maior) {
                maior = array.get(i);
            }
        }
        return maior;
    }

    // Método para encontrar o menor valor no array
    public static int encontrarMenorValor(ArrayList<Integer> array) {
        int menor = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < menor) {
                menor = array.get(i);
            }
        }
        return menor;
    }


    // Método para ler um array do usuário
    public static ArrayList<Integer> lerArrayDoUsuario(Scanner scanner) {
        ArrayList<Integer> array = new ArrayList<>();
        boolean continuar = true;

        System.out.println("Digite os elementos do array (digite '0' para parar):");
        while (continuar) {
            System.out.print("Digite um número (ou 0 para parar): ");
            int num = scanner.nextInt();
            
            if (num == 0) {
                continuar = false;
            } else {
                array.add(num);
            }
        }

        return array;
    }

    // Método para preencher o restante do array com valores aleatórios
    public static void preencherComValoresAleatorios(ArrayList<Integer> array) {
        Random random = new Random();
        int tamanhoOriginal = array.size();
        int tamanhoFinal = 10; // Define o tamanho final do array

        for (int i = tamanhoOriginal; i < tamanhoFinal; i++) {
            array.add(random.nextInt(100)); // Preencher o restante do array com valores aleatórios
        }
    }

    // Métodos para cálculo da soma, encontrar o maior e o menor valor permanecem iguais...
}
