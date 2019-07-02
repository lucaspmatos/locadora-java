package main;

import java.io.IOException;
import java.util.ArrayList;

public interface Gravador {
	
	public void locadoras(ArrayList<Locadora> locadoras, String nome_arquivo) throws IOException;
	public void categorias(ArrayList<Categoria> categorias, String nome_arquivo) throws IOException;

}
