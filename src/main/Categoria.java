/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.Serializable;

/**
 * A Classe Categoria.
 */
public class Categoria implements Serializable {
	
	/** C�digo est�tico sequ�ncial de c�digo. */
	private static int seq = 0;
	
	private int codigo;
	private String nome;
	private boolean automatico;
	private String direcao;
	private int portas;
	private boolean ar_condicionado;
	
	/**
	 * Instancia uma nova categoria.
	 *
	 * @param nome Nome da Categoria
	 * @param automatico Define se na categoria os carros s�o autom�ticos ou n�o
	 * @param direcao Define o tipo de dire��o do carro (Ex: Mec�nica)
	 * @param portas Define o n�mero de portas do carro
	 * @param ar_condicionado Define se o carro tem ar condicionado ou n�o
	 * @throws NumeroInvalidoException 
	 */
	public Categoria(String nome, boolean automatico, String direcao, int portas, boolean ar_condicionado) throws NumeroInvalidoException {
		Categoria.seq = Categoria.seq + 1;
		this.codigo = Categoria.seq;
		this.nome = nome;
		this.automatico = automatico;
		this.direcao = direcao;
		this.setPortas(portas);
		this.ar_condicionado = ar_condicionado;
	}

	/**
	 * Retorna o nome da categoria
	 *
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o nome da categoria
	 *
	 * @param nome novo nome da categoria
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Checa se a categoria � de carros autom�ticos
	 *
	 * @return true, se for autom�tico
	 */
	public boolean isAutomatico() {
		return automatico;
	}

	/**
	 * Seta se a categoria � de carros autom�ticos ou n�o
	 *
	 * @param automatico o novo status de autom�tico
	 */
	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	/**
	 * Retorna o tipo de dire��o dos carros da categoria
	 *
	 * @return tipo de dire��o
	 */
	public String getDirecao() {
		return direcao;
	}

	/**
	 * Seta um tipo de dire��o para os carros da categoria
	 *
	 * @param direcao o novo tipo de dire��o
	 */
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	/**
	 * Retorna o n�mero de portas dos carros da categoria
	 *
	 * @return n�mero de portas
	 */
	public int getPortas() {
		return portas;
	}

	/**
	 * Sets the portas.
	 *
	 * @param portas the new portas
	 * @throws NumeroInvalidoException 
	 */
	public void setPortas(int portas) throws NumeroInvalidoException {
		this.portas = portas;
		
		if (portas <= 1 && portas == 3 && portas <= 5) {
			throw new NumeroInvalidoException("ERRO: O n�mero de portas do ve�culo deve ser 2 ou 4!");
		}
	}

	/**
	 * Checa se os carros da categoria possuem ou n�o ar condicionado
	 *
	 * @return true, se tiver ar condicionado
	 */
	public boolean isAr_condicionado() {
		return ar_condicionado;
	}

	/**
	 * Define se a categoria possui ou n�o carros com ar condicionado
	 *
	 * @param ar_condicionado o novo status de ar condicionado da categoria
	 */
	public void setAr_condicionado(boolean ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}

	/**
	 * Retorna o c�digo �nico da categoria
	 *
	 * @return c�digo da categoria
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		String retorno =  this.codigo + " - " + this.nome + " - Autom�tico: ";
		if(this.automatico == true){
			retorno += "Sim ";
		}else {
			retorno += "N�o ";
		}
		retorno += "- Dire��o: " + this.direcao + " - Portas: " + this.portas + " - Ar condicionado: ";
		if(this.ar_condicionado == true){
			retorno += "Sim ";
		}else {
			retorno += "N�o ";
		}
		return retorno;
	}
}
