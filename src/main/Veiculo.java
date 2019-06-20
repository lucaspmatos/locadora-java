/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.Serializable;

/**
 * A Classe Veiculo.
 */
public class Veiculo implements Serializable{
	
	/** Código estático sequêncial de código. */
	private static int seq = 0;
	
	private int codigo;
	private String marca;
	private String modelo;
	private int ano;
	private String acessorios;
	private double preco;
	private Categoria categoria;
	
	/**
	 * Instancia um novo veículo.
	 *
	 * @param marca a marca do veículo
	 * @param modelo o modelo do veículo
	 * @param ano o ano do veículo
	 * @param acessorios os acessórios do veículo
	 * @param preco o preço de aluguel do veículo
	 * @param categoria a categoria de locação do veículo
	 */
	public Veiculo(String marca, String modelo, int ano, String acessorios, double preco, Categoria categoria) {
		Veiculo.seq = Veiculo.seq + 1;
		this.codigo = Veiculo.seq;
		this.marca = marca;
		this.modelo = modelo;
		this.setAno(ano);
		this.acessorios = acessorios;
		this.setPreco(preco);
		this.categoria = categoria;
	}

	/**
	 * Retorna a marca do veículo
	 *
	 * @return a marca do veículo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Seta uma nova marca para o veículo
	 *
	 * @param marca a nova marca do veículo
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Retorna o modelo do veículo
	 *
	 * @return o modelo do veículo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Seta um novo modelo para o veículo
	 *
	 * @param modelo o novo modelo do veículo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Retorna o ano do veículo
	 *
	 * @return o ano do veículo
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Seta um novo ano para o veículo
	 *
	 * @param ano o novo ano do veículo
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Retorna os acessórios do veículo
	 *
	 * @return os acessórios do veículo
	 */
	public String getAcessorios() {
		return acessorios;
	}

	/**
	 * Seta os acessórios do veículo
	 *
	 * @param acessorios os acessórios do veículo
	 */
	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

	/**
	 * Retorna o preço de aluguel do veículo
	 *
	 * @return o preço de aluguel do veículo
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Seta um novo preço de aluguel do veículo
	 *
	 * @param preco o novo preço de aluguel
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Retorna a categoria de locação do veículo
	 *
	 * @return a categoria do veículo
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Seta uma nova categoria de locação para o veículo
	 *
	 * @param categoria a nova categoria do veículo
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Retorna o código único do veículo.
	 *
	 * @return o código veículo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		String retorno = this.codigo + " - " + this.marca + " - " + this.modelo + " " + this.ano + " - Preço: " + this.preco;
		retorno += "\nAcessórios: " + this.acessorios;
		retorno += "\nCategoria: " + this.categoria.toString();
		return retorno;
	}
}
