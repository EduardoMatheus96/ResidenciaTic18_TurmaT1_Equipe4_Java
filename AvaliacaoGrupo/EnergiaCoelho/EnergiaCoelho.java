import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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
        return "Matrícula: " + matricula + ", Endereço: " + endereco +
                ", Última Leitura: " + ultimaLeitura + ", Penúltima Leitura: " + penultimaLeitura;
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

public class EnergiaCoelho {
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        EnergiaCoelho.clientes = clientes;
    }

    public static void setImoveis(ArrayList<Imovel> imoveis) {
        EnergiaCoelho.imoveis = imoveis;
    }

    public static void setScanner(Scanner scanner) {
        EnergiaCoelho.scanner = scanner;
    }

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void incluirCliente() {
        System.out.println("Incluir Cliente:");
        System.out.print("Nome: ");
        scanner.nextLine(); // Consumir a quebra de linha pendente
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
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
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        System.out.print("Endereço: ");
        scanner.nextLine(); // Consumir a quebra de linha pendente
        String endereco = scanner.nextLine();
        System.out.print("Última Leitura: ");
        int ultimaLeitura = scanner.nextInt();
        System.out.print("Penúltima Leitura: ");
        int penultimaLeitura = scanner.nextInt();
    
        Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
        imoveis.add(novoImovel);
        System.out.println("Imóvel incluído com sucesso!");
    }

    private static void consultarImovel() {
        System.out.println("Consultar Imóvel:");
        System.out.print("Digite a Matrícula do imóvel a ser consultado: ");
        int matriculaConsulta = scanner.nextInt();
    
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matriculaConsulta) {
                System.out.println("Imóvel encontrado:");
                System.out.println(imovel);
                return;
            }
        }
        System.out.println("Imóvel não encontrado.");
    }

    private static void listarImoveis() {
        System.out.println("Lista de Imóveis:");
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }

    private static void excluirImovel() {
        System.out.println("Excluir Imóvel:");
        System.out.print("Digite a Matrícula do imóvel a ser excluído: ");
        int matriculaExclusao = scanner.nextInt();
    
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula() == matriculaExclusao) {
                imoveis.remove(imovel);
                System.out.println("Imóvel excluído com sucesso.");
                return;
            }
        }
        System.out.println("Imóvel não encontrado para exclusão.");
    }

    private static void alterarImovel() {
        System.out.println("Alterar Imóvel:");
        System.out.print("Digite a Matrícula do imóvel a ser alterado: ");
        int matriculaAlteracao = scanner.nextInt();
    
        for (Imovel imovel : imoveis) {
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
        System.out.println("Imóvel não encontrado para alteração.");
    }
    

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Sair");
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
                    System.out.println("Programa Encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 3);
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
        } while (opcao != 6);
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
                case 6:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 6);
    }
}
