package redeSocial;

import java.util.ArrayList;
import java.util.UUID;

public class Usuario {
	
	private String id;
	private String nome;
	private String nomeUsuario;
	private String email;
	private String senha;
	private ArrayList<String> postagens;
	private ArrayList<Sessao> sessoes;
	private ArrayList<Usuario> amigos;
	
	public Usuario(String nome, String nomeUsuario, String email, String senha) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.postagens = new ArrayList<String>();
		this.sessoes = new ArrayList<Sessao>();
	}

	public String getNome() {
		return nome;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public ArrayList<String> getPostagens() {
		return postagens;
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}
	
	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}
	
	public void novaPostagem(String post) {
		postagens.add(post);
	}
	
	public void logar() {
		
	}
	
	public void deslogar(Sessao sessao) {
		
	}
}
