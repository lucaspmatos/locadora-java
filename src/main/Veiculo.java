/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.Serializable;

/**
 * A Classe Veiculo.
 */
public class Veiculo implements Serializable {
	
	/** C�digo est�tico sequencial de c�digo. */
	public static int seq = 0;
	
	private int codigo;
	private String marca;
	private String modelo;
	private int ano;
	private String acessorios;
	private double preco;
	private Categoria categoria;
	
	/**
	 * Instancia um novo ve�culo.
	 *
	 * @param marca a marca do ve�culo
	 * @param modelo o modelo do ve�culo
	 * @param ano o ano do ve�culo
	 * @param acessorios os acess�rios do ve�culo
	 * @param preco o pre�o de aluguel do ve�culo
	 * @param categoria a categoria de loca��o do ve�culo
	 * @throws NumeroInvalidoException 
	 */
	public Veiculo(String marca, String modelo, int ano, String acessorios, double preco, Categoria categoria) throws NumeroInvalidoException {
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
	 * Retorna a marca do ve�culo
	 *
	 * @return a marca do ve�culo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Seta uma nova marca para o ve�culo
	 *
	 * @param marca a nova marca do ve�culo
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Retorna o modelo do ve�culo
	 *
	 * @return o modelo do ve�culo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Seta um novo modelo para o ve�culo
	 *
	 * @param modelo o novo modelo do ve�culo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Retorna o ano do ve�culo
	 *
	 * @return o ano do ve�culo
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Seta um novo ano para o ve�culo
	 *
	 * @param ano o novo ano do ve�culo
	 * @throws NumeroInvalidoException 
	 */
	public void setAno(int ano) throws NumeroInvalidoException {
		this.ano = ano;
		
		if (ano < 0) {
			throw new NumeroInvalidoException("ERRO: O ano do ve�culo n�o pode ser negativo!");
		}
		
	}

	/**
	 * Retorna os acess�rios do ve�culo
	 *
	 * @return os acess�rios do ve�culo
	 */
	public String getAcessorios() {
		return acessorios;
	}

	/**
	 * Seta os acess�rios do ve�culo
	 *
	 * @param acessorios os acess�rios do ve�culo
	 */
	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

	/**
	 * Retorna o pre�o de aluguel do ve�culo
	 *
	 * @return o pre�o de aluguel do ve�culo
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Seta um novo pre�o de aluguel do ve�culo
	 *
	 * @param preco o novo pre�o de aluguel
	 * @throws NumeroInvalidoException 
	 */
	public void setPreco(double preco) throws NumeroInvalidoException {
		this.preco = preco;
		
		if (preco <= 0.00) {
			throw new NumeroInvalidoException("ERRO: O pre�o do ve�culo n�o pode ser zero ou negativo!");
		}
	}

	/**
	 * Retorna a categoria de loca��o do ve�culo
	 *
	 * @return a categoria do ve�culo
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Seta uma nova categoria de loca��o para o ve�culo
	 *
	 * @param categoria a nova categoria do ve�culo
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Retorna o c�digo �nico do ve�culo.
	 *
	 * @return o c�digo ve�culo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		String retorno = this.codigo + " - " + this.marca + " - " + this.modelo + " " + this.ano + " - Pre�o: " + this.preco;
		retorno += "\n      Acess�rios: " + this.acessorios;
		retorno += "\n      Categoria: " + this.categoria.toString();
		return retorno;
	}
}
