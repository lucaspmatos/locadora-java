/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * A Classe utilitária LeitorArquivo.
 */
public class LeitorArquivo implements Leitor {
	
	/**
	 * Lê uma lista de locadoras de um arquivo
	 * 
	 * @param nome_arquivo nome do arquivo a ser lido
	 * @return lista de locadoras
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Locadora> locadoras(String nome_arquivo) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(nome_arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<Locadora> locadoras = new ArrayList<Locadora>();
		
		int size = ois.readInt();
		
		for (int i=0; i<size; i++) {
			Locadora locadora = (Locadora) ois.readObject();
			locadoras.add(locadora);
        }
		
		ois.close();
		fis.close();
		
		return locadoras;
	}
	
	/**
	 * Lê uma lista de categorias de um arquivo
	 * 
	 * @param nome_arquivo nome do arquivo a ser lido
	 * @return lista de locadoras
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Categoria> categorias(String nome_arquivo) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(nome_arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		int size = ois.readInt();
		
		for (int i=0; i<size; i++) {
			Categoria categoria = (Categoria) ois.readObject();
			categorias.add(categoria);
        }
		
		ois.close();
		fis.close();
		
		return categorias;
	}
}
