import java.text.SimpleDateFormat;
import java.util.*;

class Cliente {
	private String nome;
	private String cpf;
	private ArrayList<Imovel> imoveis;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
	}

	// Getters e Setters
	@Override
	public String toString() {
		return "Nome: " + nome + ", CPF: " + cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public void adicionarImovel(Imovel imovel) {
		imoveis.add(imovel);
	}

	public void excluiImovel(Imovel imovel) {
		imoveis.remove(imovel);
	}

}

class Imovel {
	private int matricula;
	private String endereco;
	private int ultimaLeitura;
	private int penultimaLeitura;

	public Imovel(int matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
	}

	// Getters e Setters

	@Override
	public String toString() {
		return "Matrícula: " + matricula + ", Endereço: " + endereco + ", Última Leitura: " + ultimaLeitura
				+ ", Penúltima Leitura: " + penultimaLeitura;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUltimaLeitura(int ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public void setPenultimaLeitura(int penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	public int getPenultimaLeitura() {
		return penultimaLeitura;
	}

}

class Fatura {
	private Long id;
	private Imovel imovel;
	private double ultimaLeitura;
	private double penultimaLeitura;
	private Date dataEmissao;
	private double valorCalculado;
	private boolean quitada;
	private List<Pagamento> pagamentos;

	@Override
	public String toString() {
		return "Matrícula do Imóvel: " + imovel.getMatricula() + "\nData de Emissão: " + dataEmissao
				+ "\nÚltima Leitura: " + ultimaLeitura + "\nPenúltima Leitura: " + penultimaLeitura
				+ "\nValor Calculado: " + valorCalculado + "\nQuitada: " + quitada + "\n---------------------";
	}

	public Fatura(Long id, Imovel imovel, double ultimaLeitura, double penultimaLeitura) {
		this.id = id;
		this.imovel = imovel;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.dataEmissao = new Date();
		this.valorCalculado = calcularValor();
		this.quitada = false;
		pagamentos = new ArrayList<Pagamento>();
	}

	private double calcularValor() {
		// Admitindo um custo de 10 reais por KWh
		return (ultimaLeitura - penultimaLeitura) * 10;
	}

	public void adicionaPagamento(Pagamento pagamento){
		if(quitada){
			System.out.println("A fatura ja esta quitada! Nao foi possivel adicionar um pagamento.");
			return;
		}

		pagamentos.add(pagamento);
		if(valorPago() >= calcularValor()){
			quitada = true;
			if(valorPago() > calcularValor()){
				pagamento.geraReembolso(valorPago() - valorCalculado);
				System.out.printf("O valor total pago ultrapassou o valor da fatura, foi gerado um reembolso no valor de R$%.2f%n", pagamento.getReembolso().getValor());
			}
		}
	}

	public double valorPago(){
		double valor = 0.0f;
		for (var pagamento : pagamentos){
			valor += pagamento.getValor();
		}

		return valor;
	}

	public Long getId() {
		return id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public double getUltimaLeitura() {
		return ultimaLeitura;
	}

	public double getPenultimaLeitura() {
		return penultimaLeitura;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
}

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

	private static ArrayList<Cliente> clientes = new ArrayList<>();
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

	private static void incluirCliente() {
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

	private static void consultarCliente() {
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

	private static void listarClientes() {
		System.out.println("Lista de Clientes:");
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	private static void excluirCliente() {
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

	private static void alterarCliente() {
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

	private static void incluirImovel() {
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

	private static void consultarImovel() {
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

	private static void listarImoveis() {
		System.out.println("Lista de Imóveis:");

		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				System.out.println(imovel);
			}
		}
	}

	private static void excluirImovel() {
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

	private static void alterarImovel() {
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

	static void registrarConsumo() {

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

	static void listarFaturasAbertas() {
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

	static void listarTodasFaturas() {
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

	static void incluirPagamento(){
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

	static void listarPagamentos(){
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

	static void listarPagamentosDeFatura(){
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

	static void listarReembolsos(){
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

	static void exibirReembolsoDeFatura(){
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
		int opcao;
		do {
			System.out.println("----- Menu -----");
			System.out.println("1. Gestão de Clientes");
			System.out.println("2. Gestão de Imóveis");
			System.out.println("3. Gestão de Faturas");
			System.out.println("4. Gestão de Pagamentos");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

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
			case 0:
				System.out.println("Programa Encerrado.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 0);
	}

	private static void menuFaturas() {

		int opcao;
		do {
			System.out.println("\n----- Menu de Faturas -----");
			System.out.println("1. Registrar Consumo");
			System.out.println("2. Listar Faturas Abertas");
			System.out.println("3. Listar Todas as Faturas");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha a opção: ");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				registrarConsumo();
				break;
			case 2:
				listarFaturasAbertas();
				break;
			case 3:
				listarTodasFaturas();
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 0);

	}

	private static void menuClientes() {
		int opcao;
		do {
			System.out.println("\n----- Menu Clientes -----");
			System.out.println("1. Incluir Cliente");
			System.out.println("2. Consultar Cliente");
			System.out.println("3. Listar Clientes");
			System.out.println("4. Excluir Cliente");
			System.out.println("5. Alterar Cliente");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				incluirCliente();
				break;
			case 2:
				consultarCliente();
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				excluirCliente();
				break;
			case 5:
				alterarCliente();
				break;
			case 6:
				System.out.println("Voltando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 0);
	}

	private static void menuImoveis() {
		int opcao;
		do {
			System.out.println("\n----- Menu Imóveis -----");
			System.out.println("1. Incluir Imóvel");
			System.out.println("2. Consultar Imóvel");
			System.out.println("3. Listar Imóveis");
			System.out.println("4. Excluir Imóvel");
			System.out.println("5. Alterar Imóvel");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				incluirImovel();
				break;
			case 2:
				consultarImovel();
				break;
			case 3:
				listarImoveis();
				break;
			case 4:
				excluirImovel();
				break;
			case 5:
				alterarImovel();
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		} while (opcao != 0);
	}

	private static void menuPagamentos(){
		int opcao;
		do {
			System.out.println("\n--------Menu Pagamentos--------");
			System.out.println("1. Incluir pagamento");
			System.out.println("2. Listar pagamentos");
			System.out.println("3. Listar pagamentos de uma fatura");
			System.out.println("4. Listar reembolsos");
			System.out.println("5. Exibir reembolso de uma fatura");
			System.out.println("0. Voltar ao menu anterior");
			System.out.print("\nDigite uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao){
				case 1:
					incluirPagamento();
					break;
				case 2:
					listarPagamentos();
					break;
				case 3:
					listarPagamentosDeFatura();
					break;
				case 4:
					listarReembolsos();
					break;
				case 5:
					exibirReembolsoDeFatura();
					break;
				case 0:
					break;
				default:
					System.out.println("Opcao invalida! Tente novamente");
					break;
			}
		}  while(opcao !=  0);
	}
}
