/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.Serializable;

/**
 * A Classe Localizacao.
 */
public class Localizacao implements Serializable{
	
	/** Código estático sequêncial de código. */
	private static int seq = 0;
	
	private int codigo;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	
	/**
	 * Instancia uma nova localizacao.
	 *
	 * @param endereco o endereço da localização
	 * @param bairro o bairro da localização
	 * @param cidade a cidade da localização
	 * @param estado o estado da localização
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
	 * Retorna o endereço da Localização
	 *
	 * @return o endereço da localização
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Seta um novo endereço para a localização
	 *
	 * @param endereco o novo endereço da localização
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o bairro da localização
	 *
	 * @return o bairro da localização
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Seta um novo bairro para a localização
	 *
	 * @param bairro o novo bairro da localização
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna a cidade da localização
	 *
	 * @return a cidade da localização
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Seta uma nova cidade para a localização
	 *
	 * @param cidade a nova cidade da localização
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o estado da localização (UF)
	 *
	 * @return o estado da localização
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Seta um novo estado (UF) para a localização
	 *
	 * @param estado o novo estado da localização
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna o código único da localização
	 *
	 * @return o código da localização
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.endereco + ", " + this.bairro + ", " + this.cidade + " - " + this.estado;
	}
}
