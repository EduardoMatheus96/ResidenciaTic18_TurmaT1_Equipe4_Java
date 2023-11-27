package redeSocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	static ListaUsuarios listaUsuarios = new ListaUsuarios();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Sessao> listaSessoes = new ArrayList<Sessao>();
		int escolha;
		String email, senha;
		Usuario usuario;
		
		do {
			escolha = menu();
			
			switch (escolha) {
				case 1:
					System.out.print("Nome do usuario: ");
					String nome = sc.nextLine();
					System.out.println("Username do usuario");
					String nomeUsuario = sc.nextLine();
					System.out.print("Email do usuario: ");
					email = sc.nextLine();
					System.out.print("Senha do usuario: ");
					senha = sc.nextLine();
					usuario = new Usuario(nome, nomeUsuario, email, senha);
					listaUsuarios.criarUsuario(usuario);
					break;
				case 2:
					System.out.print("Email do usuario: ");
					email = sc.nextLine();
					System.out.print("Senha do usuario: ");
					senha = sc.nextLine();
					usuario = listaUsuarios.existeUsuario(email, senha);
					if(usuario != null) {
						Sessao sessao = new Sessao(usuario);
						for (Usuario amigo : sessao.getUsuario().getAmigos()) {
							sessao.desfazerAmizade(amigo);
						}
						
						listaUsuarios.removerUsuario(usuario);
					}
					break;
				case 3:
					System.out.print("Email do usuario: ");
					email = sc.nextLine();
					System.out.print("Senha do usuario: ");
					senha = sc.nextLine();
					Usuario user = listaUsuarios.existeUsuario(email, senha);
					if(user != null) {
						Sessao sessao = new Sessao(user);
						listaSessoes.add(sessao);
						menuSessao(sessao);
					}
					break;
				case 0:
					System.out.println("Programa encerrado");
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
			}
		} while(escolha != 0);

	}
	
	static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("### MENU ###");
		System.out.println("1 - Criar usuario");
		System.out.println("2 - Remover usuario");
		System.out.println("3 - Logar");
		System.out.println("0 - Sair");
		
		System.out.print("Digite uma opcao: ");
		
		int op = sc.nextInt();
		
		return op;
	}
	
	static void menuSessao(Sessao sessao) {
		Scanner sc = new Scanner(System.in);
		int escolha;
		String username;
		Usuario amigo;
		
		System.out.println("### SESSAO ###");
		System.out.println("1 - Listar postagens");
		System.out.println("2 - Criar postagem");
		System.out.println("3 - Criar amizade :)");
		System.out.println("4 - desfazer amizade >:(");
		System.out.println("0 - Voltar ao menu anterior");
		
		do {
			escolha = sc.nextInt();
			switch (escolha) {
				case 1:
					sessao.listarPostagens();
					break;
				case 2:
					System.out.println("Escreva a postagem:");
					String post = sc.nextLine();
					sessao.criarPostagem(post);
					break;
				case 3:
					System.out.print("Escreva o username para adicionar como amigo: ");
					username = sc.nextLine();
					amigo = listaUsuarios.existeUsuarioComUserName(username);
					if(amigo != null) {
						if(!sessao.getUsuario().getAmigos().contains(amigo)) {
							sessao.criarAmizade(amigo);
						} else {
							System.out.println(amigo.getNomeUsuario() + " ja eh seu amigo!");
						}
					} else {
						System.out.println("Nao existe um usuario com esse username!");
					}
					break;
				case 4:
					System.out.print("Escreva o username do amigo para remover de sua vida: ");
					username = sc.nextLine();
					amigo = listaUsuarios.existeUsuarioComUserName(username);
					if(amigo != null) {
						if(sessao.getUsuario().getAmigos().contains(amigo)) {
							sessao.desfazerAmizade(amigo);
						} else {
							System.out.println("Voce ja nao eh amigo de " + amigo.getNomeUsuario() + "!");
						}
					} else {
						System.out.println("Nao existe um usuario com esse username!");
					}
					break;
				case 0:
					sessao.deslogar();
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
			}
		} while(escolha != 0);
		
	}

}
