package controller;

import model.*;
import view.Interface;

import java.text.SimpleDateFormat;
import java.util.*;

public class EnergiaCoelho {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Long idsFatura = 0L;
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		EnergiaCoelho.clientes = clientes;
	}

	public static void setScanner(Scanner scanner) {
		EnergiaCoelho.scanner = scanner;
	}

	public static ArrayList<Fatura> getFaturas() {
		return faturas;
	}

	public static void setFaturas(ArrayList<Fatura> faturas) {
		EnergiaCoelho.faturas = faturas;
	}

	private static ArrayList<Cliente> clientes = new ArrayList<>() {{
        add(new Cliente("João", "12345678900"));
        add(new Cliente("Maria", "98765432100"));
    }};
    
	private static ArrayList<Fatura> faturas = new ArrayList<>();
	
	private static Scanner scanner = new Scanner(System.in);

	static Imovel buscarImovelPorMatricula(int matricula) {
		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				if (imovel.getMatricula() == matricula) {
					return imovel;
				}
			}
		}
		return null;
	}

	static Cliente buscarClientePorCPF(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	static Fatura buscarFaturaPorId(Long id){
		for(var fatura : faturas){
			if(fatura.getId().equals(id)){
				return fatura;
			}
		}

		return null;
	}

	static Imovel buscarImovelPorMatriculaPorCliente(int matricula, Cliente cliente) {
		for (Imovel imovel : cliente.getImoveis()) {
			if (imovel.getMatricula() == matricula) {
				return imovel;
			}
		}
		return null;
	}

	public static void incluirCliente() {
		System.out.println("Incluir Cliente:");
		System.out.print("Nome: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente
		String nome = scanner.nextLine();
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();

		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				System.out.println("Não é possivel incluir. Motivo CPF: " + cpf + " já existe!");
				return;
			}
		}

		Cliente novoCliente = new Cliente(nome, cpf);

		clientes.add(novoCliente);
		System.out.println("Cliente incluído com sucesso!");
	}

	public static void consultarCliente() {
		System.out.println("Consultar Cliente:");
		System.out.print("Digite o CPF do cliente a ser consultado: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente
		String cpfConsulta = scanner.nextLine();

		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpfConsulta)) {
				System.out.println("Cliente encontrado:");
				System.out.println(cliente);
				return;
			}
		}
		System.out.println("Cliente não encontrado.");
	}

	public static void listarClientes() {
		System.out.println("Lista de Clientes:");
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	public static void excluirCliente() {
		System.out.println("Excluir Cliente:");
		System.out.print("Digite o CPF do cliente a ser excluído: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente
		String cpfExclusao = scanner.nextLine();

		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpfExclusao)) {
				clientes.remove(cliente);
				System.out.println("Cliente excluído com sucesso.");
				return;
			}
		}
		System.out.println("Cliente não encontrado para exclusão.");
	}

	public static void alterarCliente() {
		System.out.println("Alterar Cliente:");
		System.out.print("Digite o CPF do cliente a ser alterado: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente
		String cpfAlteracao = scanner.nextLine();

		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpfAlteracao)) {
				System.out.println("Digite o novo nome: ");
				String novoNome = scanner.nextLine();
				System.out.println("Digite o novo CPF: ");
				String novoCpf = scanner.nextLine();
				// Precisa verificar se o novo CPF existe no ArrayList
				for (Cliente verificarCliente : clientes) {
					if (verificarCliente.getCpf().equals(novoCpf)) {
						System.out.println("Não é possivel alterar. Motivo CPF: " + novoCpf + " já existe!");
						return;
					}
				}
				cliente.setNome(novoNome);
				cliente.setCpf(novoCpf);
				System.out.println("Cliente alterado com sucesso.");
				return;
			}
		}
		System.out.println("Cliente não encontrado para alteração.");
	}

	public static void incluirImovel() {
		System.out.println("Incluir Imóvel:");
		System.out.println("Informe o CPF do cliente: ");
		String cpfCliente = scanner.next();

		Cliente cliente = buscarClientePorCPF(cpfCliente);

		if (cliente == null) {
			System.out.println("Cliente não encontrado para inclusao de Imovel.");
			return;
		}
		System.out.print("Matrícula: ");
		int matricula = scanner.nextInt();
		Imovel existeImovelMatricula = buscarImovelPorMatricula(matricula);
		if (existeImovelMatricula != null) {
			System.out.println("Não é possivel incluir o imovel. Motivo matricula: " + matricula + " já existe!");
			return;
		}

		System.out.print("Endereço: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente
		String endereco = scanner.nextLine();
		System.out.print("Última Leitura: ");
		int ultimaLeitura = scanner.nextInt();
		System.out.print("Penúltima Leitura: ");
		int penultimaLeitura = scanner.nextInt();

		Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);

		cliente.adicionarImovel(novoImovel);
		System.out.println("Imóvel incluído com sucesso!");
	}

	public static void consultarImovel() {
		System.out.println("Consultar Imóvel:");
		System.out.print("Digite a Matrícula do imóvel a ser consultado: ");
		int matriculaConsulta = scanner.nextInt();
		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				if (imovel.getMatricula() == matriculaConsulta) {
					System.out.println("Imóvel encontrado:");
					System.out.println(imovel);
					return;
				}
			}

		}
		System.out.println("Imóvel não encontrado.");
	}

	public static void listarImoveis() {
		System.out.println("Lista de Imóveis:");

		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				System.out.println(imovel);
			}
		}
	}

	public static void excluirImovel() {
		System.out.println("Excluir Imóvel:");

		System.out.print("Digite a Matrícula do imóvel a ser excluído: ");
		int matriculaExclusao = scanner.nextInt();
		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				if (imovel.getMatricula() == matriculaExclusao) {
					cliente.excluiImovel(imovel);
					System.out.println("Imóvel removido com sucesso.");
					return;
				}
			}
		}
		System.out.println("Imóvel não encontrado para exclusão.");
	}

	public static void alterarImovel() {
		System.out.println("Alterar Imóvel:");
		System.out.print("Digite a Matrícula do imóvel a ser alterado: ");
		int matriculaAlteracao = scanner.nextInt();

		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				if (imovel.getMatricula() == matriculaAlteracao) {
					System.out.println("Digite o novo endereço: ");
					scanner.nextLine(); // Consumir a quebra de linha pendente
					String novoEndereco = scanner.nextLine();
					System.out.println("Digite a última leitura: ");
					int novaUltimaLeitura = scanner.nextInt();
					System.out.println("Digite a penúltima leitura: ");
					int novaPenultimaLeitura = scanner.nextInt();

					imovel.setEndereco(novoEndereco);
					imovel.setUltimaLeitura(novaUltimaLeitura);
					imovel.setPenultimaLeitura(novaPenultimaLeitura);
					System.out.println("Imóvel alterado com sucesso.");
					return;
				}
			}
		}
		System.out.println("Imóvel não encontrado para alteração.");
	}

	public static void registrarConsumo() {

		System.out.println("Informe a matrícula do imóvel: ");
		int matricula = scanner.nextInt();

		Imovel imovel = buscarImovelPorMatricula(matricula);

		if (imovel != null) {
			System.out.println("Informe a leitura atual: ");
			int leituraAtual = scanner.nextInt();

			int ultimaLeitura = imovel.getUltimaLeitura();
			int penultimaLeitura = imovel.getPenultimaLeitura();

			Fatura novaFatura = new Fatura(idsFatura, imovel, leituraAtual, penultimaLeitura);
			faturas.add(novaFatura);
			idsFatura++;

			// Atualiza a última leitura no imóvel
			imovel.setPenultimaLeitura(ultimaLeitura);
			imovel.setUltimaLeitura(leituraAtual);

			System.out.println("Fatura registrada com sucesso!");
		} else {
			System.out.println("Imóvel não encontrado.");
		}
	}

	public static void listarFaturasAbertas() {
		System.out.println("Faturas Abertas (Não Pagas):");
		for (Fatura fatura : faturas) {
			if (!fatura.isQuitada()) {
				System.out.println("Matrícula: " + fatura.getImovel().getMatricula());
				System.out.println("Valor: " + fatura.getValorCalculado());
				System.out.println("Data de Emissão: " + fatura.getDataEmissao());
				System.out.println("Quitada: " + fatura.isQuitada());
				System.out.println("------");
			}
		}
	}

	public static void listarTodasFaturas() {
		System.out.println("Todas as Faturas:");
		for (Fatura fatura : faturas) {
			System.out.println("Id: " + fatura.getId());
			System.out.println("Matrícula: " + fatura.getImovel().getMatricula());
			System.out.println("Valor: " + fatura.getValorCalculado());
			System.out.println("Data de Emissão: " + fatura.getDataEmissao());
			System.out.println("Quitada: " + fatura.isQuitada());
			System.out.println("------");
		}
	}

	public static void incluirPagamento(){
		System.out.println("Informe o CPF do cliente: ");
		String cpfCliente = scanner.next();

		Cliente cliente = buscarClientePorCPF(cpfCliente);

		if (cliente == null) {
			System.out.println("Cliente não encontrado para efetuar pagamento.");
			return;
		}

		System.out.printf("Digite a matrícula do imovel de %s para gerar o pagamento da fatura:%n", cliente.getNome());
		int matricula = scanner.nextInt();;
		for(var imovel : cliente.getImoveis()){
			if(imovel.getMatricula() == matricula){
				System.out.println("Digite o valor do pagamento:");
				double valor = scanner.nextDouble();
				var pagamento = new Pagamento(valor);

				for(var fatura : faturas){
					if(fatura.getImovel().equals(imovel)){
						fatura.adicionaPagamento(pagamento);
						System.out.println("Pagamento efetuado com sucesso!");
						return;
					}
				}
			}
		}
	}

	public static void listarPagamentos(){
		System.out.println("Lista de pagamentos:");
		int i = 1;
		for(var fatura : faturas){
			System.out.println("--------------");
			System.out.println("Fatura nº: " + i);
			System.out.println("Imovel: " + fatura.getImovel());
			System.out.println("Pagamentos");
			for(var pagamento : fatura.getPagamentos()){
				System.out.println("---------------");
				System.out.println("Data: " + sdf.format(pagamento.getData()));
				System.out.printf("Valor: R$%.2f%n", pagamento.getValor());
				if(pagamento.getReembolso() != null){
					System.out.println("Reembolso:");
					System.out.println("Data: " + pagamento.getReembolso().getData());
					System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
				}
			}
		}
		System.out.println("---------------");
	}

	public static void listarPagamentosDeFatura(){
		listarTodasFaturas();
		System.out.println("\nDigite o id da fatura que deseja listar os pagamentos:");
		Long idFatura = scanner.nextLong();
		var fatura = buscarFaturaPorId(idFatura);

		if(fatura != null){
			System.out.printf("Pagamentos da fatura de id %d:%n", fatura.getId());
			for(var pagamento : fatura.getPagamentos()){
				System.out.println("Data: " + sdf.format(pagamento.getData()));
				System.out.printf("Valor: R$%.2f%n", pagamento.getValor());
			}
			System.out.println("---------------");
		} else {
			System.out.println("Nao existe uma fatura com esse id!");
		}
	}

	public static void listarReembolsos(){
		System.out.println("Lista de reembolsos:");
		for(var fatura : faturas){
			if(!fatura.getPagamentos().isEmpty()){
				for(var pagamento : fatura.getPagamentos()){
					if(pagamento.getReembolso() != null){
						System.out.println("Data: " + sdf.format(pagamento.getReembolso().getData()));
						System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
					}
				}
			}
		}
	}

	public static void exibirReembolsoDeFatura(){
		listarTodasFaturas();
		System.out.println("\nDigite o id da fatura que deseja exibir o reembolso:");
		Long idFatura = scanner.nextLong();
		var fatura = buscarFaturaPorId(idFatura);

		if(fatura != null){
			if(!fatura.getPagamentos().isEmpty()){
				for(var pagamento : fatura.getPagamentos()){
					if(pagamento.getReembolso() != null){
						System.out.println("Reembolso:");
						System.out.println("Data: " + sdf.format(pagamento.getReembolso().getData()));
						System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
						return;
					}
				}
				System.out.println("Nao existe reembolsos relacionados a essa fatura!");
			} else {
				System.out.println("Nao existe pagamentos relacionados a essa fatura, portanto nao ha reembolso!");
			}
		} else {
			System.out.println("Nao existe uma fatura com esse id!");
		}
	}

	public static void main(String[] args) {
		Interface.Sistema();
	}
}
