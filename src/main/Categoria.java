/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

/**
 * A Classe Categoria.
 */
public class Categoria {
	
	/** Código estático sequêncial de código. */
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
	 * @param automatico Define se na categoria os carros são automáticos ou não
	 * @param direcao Define o tipo de direção do carro (Ex: Mecânica)
	 * @param portas Define o número de portas do carro
	 * @param ar_condicionado Define se o carro tem ar condicionado ou não
	 */
	public Categoria(String nome, boolean automatico, String direcao, int portas, boolean ar_condicionado) {
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
	 * Checa se a categoria é de carros automáticos
	 *
	 * @return true, se for automático
	 */
	public boolean isAutomatico() {
		return automatico;
	}

	/**
	 * Seta se a categoria é de carros automáticos ou não
	 *
	 * @param automatico o novo status de automático
	 */
	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	/**
	 * Retorna o tipo de direção dos carros da categoria
	 *
	 * @return tipo de direção
	 */
	public String getDirecao() {
		return direcao;
	}

	/**
	 * Seta um tipo de direção para os carros da categoria
	 *
	 * @param direcao o novo tipo de direção
	 */
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	/**
	 * Retorna o número de portas dos carros da categoria
	 *
	 * @return número de portas
	 */
	public int getPortas() {
		return portas;
	}

	/**
	 * Sets the portas.
	 *
	 * @param portas the new portas
	 */
	public void setPortas(int portas) {
		this.portas = portas;
	}

	/**
	 * Checa se os carros da categoria possuem ou não ar condicionado
	 *
	 * @return true, se tiver ar condicionado
	 */
	public boolean isAr_condicionado() {
		return ar_condicionado;
	}

	/**
	 * Define se a categoria possui ou não carros com ar condicionado
	 *
	 * @param ar_condicionado o novo status de ar condicionado da categoria
	 */
	public void setAr_condicionado(boolean ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}

	/**
	 * Retorna o código único da categoria
	 *
	 * @return código da categoria
	 */
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		String retorno =  this.codigo + " - " + this.nome + " - Automático: ";
		if(this.automatico == true){
			retorno += "Sim ";
		}else {
			retorno += "Não ";
		}
		retorno += "- Direção: " + this.direcao + " - Portas: " + this.portas + " - Ar condicionado: ";
		if(this.ar_condicionado == true){
			retorno += "Sim ";
		}else {
			retorno += "Não ";
		}
		return retorno;
	}
}
