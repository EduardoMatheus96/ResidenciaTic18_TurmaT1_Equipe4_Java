package validator;

public class Validacoes {
	public static boolean validaCpf(String cpf) {
		if(cpf.isBlank()) return false;
		if(cpf.length() != 11) return false;
		if(!cpf.matches("[0-9]+")) return false;
		
		return true;
	}
}
