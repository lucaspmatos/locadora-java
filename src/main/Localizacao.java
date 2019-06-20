/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.Serializable;

/**
 * A Classe Localizacao.
 */
public class Localizacao implements Serializable{
	
	/** C�digo est�tico sequ�ncial de c�digo. */
	private static int seq = 0;
	
	private int codigo;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	
	/**
	 * Instancia uma nova localizacao.
	 *
	 * @param endereco o endere�o da localiza��o
	 * @param bairro o bairro da localiza��o
	 * @param cidade a cidade da localiza��o
	 * @param estado o estado da localiza��o
	 */
	public Localizacao(String endereco, String bairro, String cidade, String estado) {
		Localizacao.seq = Localizacao.seq + 1;
		this.codigo = Localizacao.seq;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cidade = cidade;
		this.estado = estado;
	}

	/**
	 * Retorna o endere�o da Localiza��o
	 *
	 * @return o endere�o da localiza��o
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Seta um novo endere�o para a localiza��o
	 *
	 * @param endereco o novo endere�o da localiza��o
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o bairro da localiza��o
	 *
	 * @return o bairro da localiza��o
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Seta um novo bairro para a localiza��o
	 *
	 * @param bairro o novo bairro da localiza��o
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna a cidade da localiza��o
	 *
	 * @return a cidade da localiza��o
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Seta uma nova cidade para a localiza��o
	 *
	 * @param cidade a nova cidade da localiza��o
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o estado da localiza��o (UF)
	 *
	 * @return o estado da localiza��o
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Seta um novo estado (UF) para a localiza��o
	 *
	 * @param estado o novo estado da localiza��o
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna o c�digo �nico da localiza��o
	 *
	 * @return o c�digo da localiza��o
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.endereco + ", " + this.bairro + ", " + this.cidade + " - " + this.estado;
	}
}
