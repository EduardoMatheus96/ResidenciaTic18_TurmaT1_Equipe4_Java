package redeSocial;

import java.util.Date;

public class Sessao {
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private boolean isLogado;
	private Usuario usuario;
	
	public Sessao(Usuario usuario) {
		super();
		logar(usuario);
	}

	public void logar(Usuario usuario) {
		dataHoraInicio = new Date();
		this.usuario = usuario;
		isLogado = true;
	}
	
	public void deslogar() {
		dataHoraFim = new Date();
		isLogado = false;
	}
	
	public void solicitaAutenticacao() {
		
	}
	
	public void criarAmizade(Usuario amigo) {
		usuario.getAmigos().add(amigo);
		amigo.getAmigos().add(usuario);
	}
	
	public void desfazerAmizade(Usuario amigo) {
		usuario.getAmigos().remove(amigo);
		amigo.getAmigos().remove(usuario);
	}
	
	public void criarPostagem(String post) {
		usuario.novaPostagem(post);
	}
	
	public void listarPostagens() {
		System.out.println("Postagens:");
		for (String post : usuario.getPostagens()) {
			System.out.println("--------------------------");
			System.out.println(post);
		}
		System.out.println("--------------------------");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
