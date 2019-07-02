/*
 * Authors: Samuel Costa e Lucas Matos
 */
package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A Classe utilitária GravaArquivo.
 */
public class GravaArquivo implements Gravador {
	
	/**
	 * Grava uma lista de locadoras em um arquivo.
	 * 
	 * @param locadoras ArrayList de locadoras
	 * @param nome_arquivo nome do arquivo a ser gravado
	 * @throws IOException
	 */
	public void locadoras(ArrayList<Locadora> locadoras, String nome_arquivo) throws IOException{
		
		File f = new File(nome_arquivo);
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
		
		FileOutputStream fos = new FileOutputStream(nome_arquivo, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//save the number of records
        oos.writeInt(locadoras.size());
		
		for(int i = 0; i < locadoras.size(); i++){
			oos.writeObject(locadoras.get(i));
			oos.reset();
		}
		
		oos.close();
	}
	
	/**
	 * Grava uma lista de categorias em um arquivo
	 * @param categorias ArrayList de categorias
	 * @param nome_arquivo nome do arquivo
	 * @throws IOException
	 */
	public void categorias(ArrayList<Categoria> categorias, String nome_arquivo) throws IOException{
		File f = new File(nome_arquivo);
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
		
		FileOutputStream fos = new FileOutputStream(nome_arquivo, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//save the number of records
        oos.writeInt(categorias.size());
		
		for(int i = 0; i < categorias.size(); i++){
			oos.writeObject(categorias.get(i));
			oos.reset();
		}
		
		oos.close();
	}
}
