package model;

import java.util.ArrayList;

public class Cliente {
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
