package view;
import controller.EnergiaCoelho;

import controller.EnergiaCoelho;
import java.util.ArrayList;

import java.util.Scanner;


public class Interface {
	static Scanner scanner = new Scanner(System.in);
	
	public static void SystemClear() {
		 
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
	}
		 
	public static int MontarMenu(ArrayList<String> menu, String titulo) {
        int opcao;
        do {
            System.out.println(titulo);
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i + 1 + ". " + menu.get(i));
            }

            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer de entrada
            }
            opcao = scanner.nextInt();

            if (opcao < 1 || opcao > menu.size()) {
                System.out.println("Opção inválida. Escolha uma opção dentro do intervalo disponível.");
            }
            
        } while (opcao < 1 || opcao > menu.size());

        return opcao;
    }
	
	public static void Sistema() {
		//Menu Principal
		int opcao;
		
		ArrayList<String> menu = new ArrayList<>();
        menu.add("Gestão de Clientes");
        menu.add("Gestão de Imóveis");
        menu.add("Gestão de Faturas");
        menu.add("Gestão de Pagamentos");
        menu.add("Sair");	
		
		do {
			opcao = MontarMenu(menu,"Sistema Energia Coelho");
			
			switch (opcao) {
				case 1:
					menuClientes();
					break;
				case 2:
					menuImoveis();
					break;
				case 3:
					menuFaturas();
					break;
				case 4:
					menuPagamentos();
					break;
				case 5:
					System.out.println("Programa Encerrado.");
					break;
				default:
					System.out.println("Opção inválida. Escolha novamente.");
					break;
			}
			
		} while (opcao != 5);
	}


	private static void menuFaturas() {
		int opcao;
		ArrayList<String> menu = new ArrayList<>();        
		menu.add("Registrar Consumo");
        menu.add("Listar Faturas Abertas");
        menu.add("Listar Todas as Faturas");
        menu.add("Sair");	
		  
		do {
			opcao = MontarMenu(menu,"Sistema de Gerenciamento de Faturas");
			
			switch (opcao) {
				case 1:
					EnergiaCoelho.registrarConsumo();
					break;
				case 2:
					EnergiaCoelho.listarFaturasAbertas();
					break;
				case 3:
					EnergiaCoelho.listarTodasFaturas();
					break;
				case 4:
					System.out.println("Voltando ao Menu Principal.");
					break;
				default:
					System.out.println("Opção inválida. Escolha novamente.");
					break;
			}
			
		} while (opcao != 4);
	}

	private static void menuClientes() {
		int opcao;
		ArrayList<String> menu = new ArrayList<>();        
		menu.add("Incluir Cliente");
        menu.add("Consultar Cliente");
        menu.add("Listar Clientes");
        menu.add("Excluir Cliente");
        menu.add("Alterar Cliente");
        menu.add("Sair");	
        
		do {
			opcao = MontarMenu(menu,"Sistema de Gerenciamento de Clientes");
			
			switch (opcao) {
			case 1:
				EnergiaCoelho.incluirCliente();
				break;
			case 2:
				EnergiaCoelho.consultarCliente();
				break;
			case 3:
				EnergiaCoelho.listarClientes();
				break;
			case 4:
				EnergiaCoelho.excluirCliente();
				break;
			case 5:
				EnergiaCoelho.alterarCliente();
				break;
			case 6:
				System.out.println("Voltando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 6);
	}

	private static void menuImoveis() {
		int opcao;
		ArrayList<String> menu = new ArrayList<>();        
		menu.add("Incluir Imóvel");
        menu.add("Consultar Imóvel");
        menu.add("Listar Imóveis");
        menu.add("Excluir Imóvel");
        menu.add("Alterar Imóvel");
        menu.add("Sair");	
        
		do {
			opcao = MontarMenu(menu,"Sistema de Gerenciamento de Imoveis");
		
			switch (opcao) {
			case 1:
				EnergiaCoelho.incluirImovel();
				break;
			case 2:
				EnergiaCoelho.consultarImovel();
				break;
			case 3:
				EnergiaCoelho.listarImoveis();
				break;
			case 4:
				EnergiaCoelho.excluirImovel();
				break;
			case 5:
				EnergiaCoelho.alterarImovel();
				break;
			case 6:
				System.out.println("Voltando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 6);
	}

	private static void menuPagamentos(){
		ArrayList<String> menu = new ArrayList<>();        
		menu.add("Incluir pagamento");
        menu.add("Listar pagamentos");
        menu.add("Listar pagamentos de uma fatura");
        menu.add("Listar pagamentos de uma fatura");
        menu.add("Exibir reembolso de uma fatura");
        menu.add("Sair");	
        
		int opcao;
		do {
			opcao = MontarMenu(menu, "Sistema de Gerenciamento de Imoveis");
		
			switch (opcao){
				case 1:
					EnergiaCoelho.incluirPagamento();
					break;
				case 2:
					EnergiaCoelho.listarPagamentos();
					break;
				case 3:
					EnergiaCoelho.listarPagamentosDeFatura();
					break;
				case 4:
					EnergiaCoelho.listarReembolsos();
					break;
				case 5:
					EnergiaCoelho.exibirReembolsoDeFatura();
					break;
				case 6:
					break;
				default:
					System.out.println("Opcao invalida! Tente novamente");
					break;
			}
		}  while(opcao !=  6);
	}
}
