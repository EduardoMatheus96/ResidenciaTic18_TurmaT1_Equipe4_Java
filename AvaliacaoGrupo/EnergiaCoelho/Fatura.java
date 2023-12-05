
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fatura {
	private Long id;
	private Imovel imovel;
	private int ultimaLeitura;
	private int penultimaLeitura;
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

	public Fatura(Long id, Imovel imovel,  int ultimaLeitura, int penultimaLeitura) {
		this.id = id;
		this.imovel = imovel;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.dataEmissao = Date.valueOf(LocalDate.now()); // Obtém a data atual
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
