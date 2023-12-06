package controller;

import model.*;
import view.Interface;

import java.text.SimpleDateFormat;
import java.util.*;

public class EnergiaCoelho {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
		// Clientes com imóvel
		add(criarClienteComImovel("João", "12345678900", 100, "Rua A, lot 58", 10, 0));
        add(criarClienteComImovel("Maria", "98765432100", 101, "Av Brasil, 1500", 5, 3));
        add(criarClienteComImovel("Lorena", "00352442590", 102, "Rua Major Deocleciano, 58", 5, 0));
    }};
    
    private static Cliente criarClienteComImovel(String nome, String cpf, int matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
        Cliente novoCliente = new Cliente(nome, cpf);
        Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
        novoCliente.adicionarImovel(novoImovel);
        return novoCliente;
    }
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
		
		scanner.nextLine(); // Consumir a quebra de linha pendente
		System.out.print("CPF: ");
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

		int ultimaLeitura = 0;
		int penultimaLeitura = 0;
		do {
			System.out.println("Digite a última leitura: ");
			ultimaLeitura = scanner.nextInt();
			System.out.println("Digite a penúltima leitura: ");
			penultimaLeitura = scanner.nextInt();
			if(ultimaLeitura < penultimaLeitura) {
				System.out.println("Ultima leitura deve ser maior que penúltima leitura. Tente novamente. ");	
			}
		} while (ultimaLeitura < penultimaLeitura); 
		
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
					int novaUltimaLeitura = 0;
					int novaPenultimaLeitura = 0;
					do {
						System.out.println("Digite a última leitura: ");
						novaUltimaLeitura = scanner.nextInt();
						System.out.println("Digite a penúltima leitura: ");
						novaPenultimaLeitura = scanner.nextInt();
						if(novaUltimaLeitura < novaPenultimaLeitura) {
							System.out.println("Ultima leitura deve ser maior que penúltima leitura. Tente novamente. ");	
						}
					} while (novaUltimaLeitura < novaPenultimaLeitura); 
					
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
			int leituraAtual = 0;

			int ultimaLeitura = imovel.getUltimaLeitura();
			int penultimaLeitura = imovel.getPenultimaLeitura();
			do {
				System.out.println("Informe a leitura atual: ");
				leituraAtual = scanner.nextInt();
				if(leituraAtual < ultimaLeitura) {
					System.out.println("A leitura atual deve ser maior que a ultima leitura: " + ultimaLeitura + ". Tente novamente. ");	
				}
			} while (leituraAtual < ultimaLeitura); 


			Fatura novaFatura = new Fatura(imovel, ultimaLeitura, penultimaLeitura);
			faturas.add(novaFatura);

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
                System.out.println(fatura.toString());
			}
		}
	}

	public static void listarTodasFaturas() {
		System.out.println("Todas as Faturas:");
		for (Fatura fatura : faturas) {
            System.out.println(fatura.toString());
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
		int matricula = scanner.nextInt();
		for(var imovel : cliente.getImoveis()){
			if(imovel.getMatricula() == matricula){
				int quantasFaturas = 0;
				long idFatura = 0;
				// Mostrar as faturas vinculadas ao imóvel
	            System.out.println("Faturas vinculadas ao imóvel:");
	            for (var fatura : faturas) {
	                if (fatura.getImovel().equals(imovel)) {
	                	quantasFaturas++;
	                	idFatura = fatura.getId();
	                    System.out.println(fatura.toString());
	                }
	            }
	            //Se existir mais de uma fatura
		        if(quantasFaturas>1) {
					System.out.println("Digite o Id da fatura para efetuar o pagamento:");
					long id = scanner.nextLong();
					idFatura = id;
	            }

				for(var fatura : faturas){
					if(fatura.getId().equals(idFatura)){
						System.out.println("Digite o valor do pagamento:");
						double valor = scanner.nextDouble();
						var pagamento = new Pagamento(valor);
						
						fatura.adicionaPagamento(pagamento);
						System.out.println("Pagamento efetuado com sucesso!");
						return;
					}
				}
				System.out.println("Id da fatura não encontrado. O pagamento não efetuado.");
			}
			
		}
	}

	public static void listarPagamentos(){
		System.out.println("Lista de pagamentos:");
		for(var fatura : faturas){
			System.out.println("--------------");
			System.out.println("Fatura nº: " + fatura.getId());
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
