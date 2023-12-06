// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class SistemaDistribuicaoEnergia {
//     private static List<Falha> falhas = new ArrayList<>();
//     private static List<Reparo> reparos = new ArrayList<>();
//     private static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         Imovel imovel = criarImovel(); // Método para criar um imóvel (pode ser ajustado conforme necessário)

//         int opcao;
//         do {
//             exibirMenu();
//             System.out.print("Escolha uma opção: ");
//             opcao = scanner.nextInt();

//             switch (opcao) {
//                 case 1:
//                     incluirFalha(imovel);
//                     break;
//                 case 2:
//                     listarReparosEmAberto();
//                     break;
//                 case 3:
//                     encerrarReparo();
//                     break;
//                 case 0:
//                     System.out.println("Saindo do sistema.");
//                     break;
//                 default:
//                     System.out.println("Opção inválida. Tente novamente.");
//             }
//         } while (opcao != 0);

//         scanner.close();
//     }

//     private static void exibirMenu() {
//         System.out.println("\n=== Menu ===");
//         System.out.println("1. Incluir Falhas");
//         System.out.println("2. Listar Reparos em Aberto");
//         System.out.println("3. Encerrar Reparo");
//         System.out.println("0. Sair");
//     }

//     private static void incluirFalha(Imovel imovel) {
//     	scanner.next();
//         System.out.println("\n=== Incluir Falha ===");
//         System.out.print("Descrição da falha: ");
//         String descricao = scanner.nextLine();

//         System.out.print("Previsão da falha (AAAA-MM-DD): ");
//         String previsaoString = scanner.next();
//         LocalDate previsao = LocalDate.parse(previsaoString);

//         System.out.print("A falha é de geração? (S/N): ");
//         boolean falhaGeracao = scanner.next().equalsIgnoreCase("S");

//         Falha falha;
//         if (falhaGeracao) {
//             falha = new FalhaGeracao(imovel, descricao, previsao);
//         } else {
//             falha = new FalhaDistribuicao(imovel, descricao, previsao);
//             reparos.add(new Reparo("Reparo na rede necessário", previsao));
//         }

//         falhas.add(falha);

//         System.out.println("Falha incluída com sucesso!");
//     }

//     private static void listarReparosEmAberto() {
//         System.out.println("\n=== Reparos em Aberto ===");
//         for (Reparo reparo : reparos) {
//             if (!reparo.isResolvido()) {
//                 System.out.println(reparo);
//             }
//         }
//     }

//     private static void encerrarReparo() {
//         System.out.println("\n=== Encerrar Reparo ===");
//         listarReparosEmAberto();

//         System.out.print("Escolha o índice do reparo que deseja encerrar: ");
//         int indiceReparo = scanner.nextInt();

//         if (indiceReparo >= 0 && indiceReparo < reparos.size()) {
//             Reparo reparo = reparos.get(indiceReparo);
//             reparo.finalizarReparo(true);

//             if (!reparo.isResolvido()) {
//                 Reparo novoReparo = new Reparo("Reparo avançado necessário", reparo.getPrevisao());
//                 reparos.add(novoReparo);
//                 System.out.println("Falha não resolvida. Novo reparo criado automaticamente.");
//             }

//             System.out.println("Reparo encerrado.");
//         } else {
//             System.out.println("Índice de reparo inválido.");
//         }
//     }

//     private static Imovel criarImovel() {
//         // Implemente este método para criar um novo imóvel
//         // Você pode usar a entrada do usuário ou fornecer valores fixos
//         System.out.println("\n=== Criar Imóvel ===");
//         System.out.print("Matrícula do imóvel: ");
//         int matricula = scanner.nextInt();

//         System.out.print("Endereço do imóvel: ");
//         String endereco = scanner.next();

//         System.out.print("Última leitura: ");
//         int ultimaLeitura = scanner.nextInt();

//         System.out.print("Penúltima leitura: ");
//         int penultimaLeitura = scanner.nextInt();

//         return new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
//     }
// }
package controller;


