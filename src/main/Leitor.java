package main;

import java.io.IOException;
import java.util.ArrayList;

public interface Leitor {
	
	public ArrayList<Locadora> locadoras(String nome_arquivo) throws IOException, ClassNotFoundException;
	public ArrayList<Categoria> categorias(String nome_arquivo) throws IOException, ClassNotFoundException;
	
}
