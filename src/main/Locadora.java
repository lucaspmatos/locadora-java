/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A Classe Locadora.
 */
public class Locadora implements Serializable{
	
	/** Código estático sequêncial de código. */
	private static int seq = 0;
	
	private int codigo;
	private String nome;
	private String cnpj;
	private String telefone;
	private Localizacao localizacao;
	private ArrayList<Veiculo> veiculos;
	
	/**
	 * Instancia uma nova locadora
	 *
	 * @param nome o nome da locadora
	 * @param cnpj o CNPJ da locadora
	 * @param telefone o telefone de contato da locadora
	 * @param localizacao a localização da locadora
	 */
	public Locadora(String nome, String cnpj, String telefone, Localizacao localizacao) {
		Locadora.seq = Locadora.seq + 1;
		this.codigo = Locadora.seq;
		this.nome = nome;
		this.setCnpj(cnpj);
		this.telefone = telefone;
		this.localizacao = localizacao;
		this.setVeiculos(new ArrayList<Veiculo>());
	}

	/**
	 * Retorna o código único da locadora no sistema
	 *
	 * @return código da locadora
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Retorna o nome da locadora
	 *
	 * @return o nome da locadora
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta um novo nome para a locadora
	 *
	 * @param nome o novo nome da locadora
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o CNPJ da locadora
	 *
	 * @return o cnpj da locadora
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Seta o CNPJ da locadora
	 *
	 * @param cnpj o novo CNPJ da locadora
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Retorna o número de telefone da locadora
	 *
	 * @return o telefone da locadora
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Seta o telefone da locadora
	 *
	 * @param telefone o novo telefone da locadora
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna a localização da locadora
	 *
	 * @return o objeto de localização da locadora
	 */
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	/**
	 * Seta a localização física da locadora
	 *
	 * @param localizacao objeto de localização da locadora
	 */
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Retorna a lista de veículos da locadora
	 *
	 * @return a lista de veículos da locadora
	 */
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	/**
	 * Seta uma nova lista de veículos para a locadora
	 *
	 * @param veiculos a nova lista de objetos de veículos
	 */
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	/**
	 * Adiciona um veículo na lista de veículos da locadora
	 *
	 * @param veiculo o objeto do veículo a ser adicionado
	 */
	public void addVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
	@Override
	public String toString() {
		String retorno = this.codigo + " - " + this.nome + " - " + this.cnpj + " - Tel: " + this.telefone;
		retorno += "\nLocalização: " + this.localizacao.toString();
		
		if(veiculos.size() > 0) {
			retorno += "\nVeículos";
			for(int i = 0; i < this.veiculos.size(); i++) {
				retorno += "\n" + this.veiculos.get(i).toString();
			}
		}else {
			retorno += "\nSem nenhum veículo cadastrado";
		}
		
		return retorno;
	}
}
