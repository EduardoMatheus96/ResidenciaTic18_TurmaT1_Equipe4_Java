package redeSocial;

import java.util.ArrayList;

public class ListaUsuarios {
	private String nomeLista;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void criarUsuario(Usuario usuario) {
		for (Usuario u : usuarios) {
			if(u.getEmail().equals(usuario.getEmail())) {
				System.out.println("Ja existe um usuario com esse email!");
				return;
			}
			
			if(u.getNome().equals(usuario.getNome())) {
				System.out.println("Ja existe um usuario com esse nome de usuario!");
			}
		}
		usuarios.add(usuario);
	}
	
	public void removerUsuario(Usuario usuario) {
		if(usuario != null) {
			for (Usuario amigo : usuario.getAmigos()) {
				
			}
			usuarios.remove(usuario);
			System.out.println("Usuario removido com sucesso!");
		}
	}
	
	public Usuario existeUsuario(String email, String senha) {
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		System.out.println("Usuario nao encontrado!");
		return null;
	}
	
	public Usuario existeUsuarioComUserName(String userName) {
		for (Usuario usuario : usuarios) {
			if(usuario.getNomeUsuario().equals(userName)) return usuario;
		}
		
		return null;
	}
}
