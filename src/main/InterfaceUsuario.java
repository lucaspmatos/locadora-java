package main;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceUsuario {
	public static void inicial(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		JTextField campo_pesquisa = new JTextField("");
        
        String[] opcoes = {"Categoria", "Localização", "Locadora", "Veículo"};
        JComboBox<String> campo_opcao = new JComboBox<>(opcoes);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Pesquisa:"));
        panel.add(campo_pesquisa);
        panel.add(new JLabel("Por: "));
        panel.add(campo_opcao);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Pesquisar",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
        	int counter = 0;
            for (int i = 0; i < campo_pesquisa.getText().length(); i++) {
            	if (Character.isLetter(campo_pesquisa.getText().charAt(i))) {
            		counter++;
            	}  
            }
            
        	if(!campo_pesquisa.getText().equals("") || counter > 2) {
        		if(campo_opcao.getSelectedIndex() == 0) {
            		pesquisaPorCategoria(categorias, locadoras, campo_pesquisa.getText());
            	}else if(campo_opcao.getSelectedIndex() == 1) {
            		pesquisarPorLocalizacao(categorias, locadoras, campo_pesquisa.getText());
            	}else if(campo_opcao.getSelectedIndex() == 2) {
            		pesquisarPorLocadora(categorias, locadoras, campo_pesquisa.getText());
            	}else {
            		pesquisarPorVeiculo(categorias, locadoras, campo_pesquisa.getText());
            	}
        	}else {
        		JOptionPane.showMessageDialog(null, "É obrigatório digitar pelo menos 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE );
        		InterfaceUsuario.inicial(categorias, locadoras);
        	}
        	
        }else {
        	InterfacePrincipal.inicial(categorias, locadoras);
        }
	}
	
	public static void pesquisaPorCategoria(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, String pesquisa) {
		String msg = "";
		boolean loc_encontrada = false;
		for(int i = 0; i < locadoras.size(); i++) {
			loc_encontrada = false;
			for(int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
				if(locadoras.get(i).getVeiculos().get(j).getCategoria().getNome().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1) {
					if(!loc_encontrada) {
						msg += "\n" + locadoras.get(i).toString() + "\nVeículos:\n";
					}
					loc_encontrada = true;
					msg += "      " + locadoras.get(i).getVeiculos().get(j).toString() + "\n";
				}
				
			}
		}
		boolean positivo = true;
		if(!msg.equals("")) {
			msg = "Locadora(s) Encontradada(s): \n" + msg;
		}else {
			positivo = false;
		}
		
		mostraResultado(categorias, locadoras, pesquisa, positivo, msg);
	}
	
	public static void pesquisarPorLocalizacao(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, String pesquisa) {
		String msg = "";
		for(int i = 0; i < locadoras.size(); i++) {
			if(locadoras.get(i).getLocalizacao().getEndereco().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
					|| locadoras.get(i).getLocalizacao().getBairro().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
					|| locadoras.get(i).getLocalizacao().getCidade().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
					|| locadoras.get(i).getLocalizacao().getEstado().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1) {
				msg += "\n" + locadoras.get(i).toString() + "\nVeículos:\n";
				for(int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
					msg += "      " + locadoras.get(i).getVeiculos().get(j).toString() + "\n";
				}
				
			}
			
		}
		boolean positivo = true;
		if(!msg.equals("")) {
			msg = "Locadora(s) Encontradada(s): \n" + msg;
		}else {
			positivo = false;
		}
		
		mostraResultado(categorias, locadoras, pesquisa, positivo, msg);
	}
	
	public static void pesquisarPorLocadora(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, String pesquisa) {
		String msg = "";
		for(int i = 0; i < locadoras.size(); i++) {
			if(locadoras.get(i).getNome().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
					|| locadoras.get(i).getCnpj().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
					|| locadoras.get(i).getTelefone().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1) {
				msg += "\n" + locadoras.get(i).toString() + "\nVeículos:\n";
				for(int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
					msg += "      " + locadoras.get(i).getVeiculos().get(j).toString() + "\n";
				}
				
			}
			
		}
		boolean positivo = true;
		if(!msg.equals("")) {
			msg = "Locadora(s) Encontradada(s): \n" + msg;
		}else {
			positivo = false;
		}
		
		mostraResultado(categorias, locadoras, pesquisa, positivo, msg);
	}
	
	public static void pesquisarPorVeiculo(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, String pesquisa) {
		String msg = "";
		boolean loc_encontrada = false;
		for(int i = 0; i < locadoras.size(); i++) {
			loc_encontrada = false;
			for(int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
				if(locadoras.get(i).getVeiculos().get(j).getMarca().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
						|| locadoras.get(i).getVeiculos().get(j).getModelo().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1
						|| locadoras.get(i).getVeiculos().get(j).getAcessorios().toLowerCase().indexOf(pesquisa.toLowerCase()) != -1) {
					if(!loc_encontrada) {
						msg += "\n" + locadoras.get(i).toString() + "\nVeículos:\n";
					}
					loc_encontrada = true;
					msg += "      " + locadoras.get(i).getVeiculos().get(j).toString() + "\n";
				}
				
			}
		}
		boolean positivo = true;
		if(!msg.equals("")) {
			msg = "Locadora(s) Encontradada(s): \n" + msg;
		}else {
			positivo = false;
		}
		
		mostraResultado(categorias, locadoras, pesquisa, positivo, msg);
	}
	
	public static void mostraResultado(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, String pesquisa, boolean positivo, String msg) {
		if(!positivo) {
			JOptionPane.showMessageDialog(null, "Nenhuma locadora foi encontrada para o termo digitado.", "Erro", JOptionPane.ERROR_MESSAGE );
		}else {
			JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE );
		}
		
		InterfaceUsuario.inicial(categorias, locadoras);
	}
}
