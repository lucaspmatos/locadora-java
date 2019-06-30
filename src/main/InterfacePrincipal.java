package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfacePrincipal {
	private static LeitorArquivo leitor = new LeitorArquivo();
	private static GravaArquivo gravador = new GravaArquivo();
	private static String arquivo_categorias = "categorias.txt";
	private static String arquivo_locadoras = "locadoras.txt";
	
	
	public static void main(String args[]) {
		// Lê o arquivo de Categorias e Locadoras
		ArrayList<Categoria> categorias = null;
		ArrayList<Locadora> locadoras = null;
		try {
			categorias = leitor.categorias(arquivo_categorias);
			locadoras = leitor.locadoras(arquivo_locadoras);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Existe um erro nos arquivos do programa. Saindo.");
			System.exit(0);
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Os arquivos de dados não foram encontrados, uma nova base será criada.");
			categorias = new ArrayList<Categoria>();
			locadoras = new ArrayList<Locadora>();
		}
		// Coloca o sequêncial do código sincronizado com os conteúdos já salvos
		Categoria.seq = categorias.size();
		Locadora.seq = locadoras.size();
		
		// Inicia a interface inicial
		inicial(categorias, locadoras);
	}
	
	public static void sair(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		// Salva as listas nos arquivos e fecha o programa
		try {
			gravador.categorias(categorias, arquivo_categorias);
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar as categorias.");
		}
		
		try {
			gravador.locadoras(locadoras, arquivo_locadoras);
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar as locadoras.");
		}
		
		System.exit(0);
	}
	
	public static void inicial(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		// Opções
		Object[] options1 = { "Administrador", "Usuário", "Sair" };
		
		// Mensagem
		JPanel panel = new JPanel();
        panel.add(new JLabel("Escolha a perspectiva de interface desejada."));
        
        int result = JOptionPane.showOptionDialog(null, panel, "Escolha a interface",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        
        if (result == JOptionPane.YES_OPTION){ // Se ele escolher a interface de administrador
        	InterfaceAdministrador.inicial(categorias, locadoras);
        }else if(result == JOptionPane.NO_OPTION) { // Se ele escolher a interface de usuário
        	System.out.println("Opção 2");
        }else {
        	sair(categorias, locadoras);
        }
	}
}
