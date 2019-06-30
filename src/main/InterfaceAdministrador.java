package main;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceAdministrador {
	public static void inicial(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		// Opções
		Object[] options1 = { "Locadoras", "Categorias", "Voltar" };
		
		// Mensagem
		JPanel panel = new JPanel();
        panel.add(new JLabel("<html>Aperte um dos botões para administrar (cadastrar, editar, excluir).<br/>Lembrando que para cadastrar um veículo em uma locadora é necessário existir pelo menos 1 categoria.</html>"));
        int result = JOptionPane.showOptionDialog(null, panel, "Escolha a opção de administrar",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        
        if (result == JOptionPane.YES_OPTION){ // Se ele escolher a opção de locadoras
        	// Locadoras
        }else if(result == JOptionPane.NO_OPTION) { // Se ele escolher a opção de categorias
        	admnistrarCategorias(categorias, locadoras);
        }else {
        	InterfacePrincipal.inicial(categorias, locadoras);
        }
	}
	
	public static void admnistrarCategorias(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		String[] nomes = new String[categorias.size()];
		for(int i = 0; i < categorias.size(); i++) {
			nomes[i] = categorias.get(i).getCodigo() + " - " + categorias.get(i).getNome();
		}
		
		final JComboBox<String> combo = new JComboBox<>(nomes);
		
		String[] options = { "Nova", "Editar", "Excluir", "Voltar", "Sair" };
		
		String title = "Categorias Cadastradas";
		
		int selection = JOptionPane.showOptionDialog(null, combo, title,
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		        options, options[0]);
		
		Object categoria_selec = combo.getSelectedItem();
		
		if(selection == 0) { // Nova categoria
			cadastrar(categorias, locadoras);
		}else if(selection == 1) { // Editar
			if (categoria_selec != null) {
				editar(categorias, locadoras, combo.getSelectedIndex());
			}else {
				JOptionPane.showMessageDialog(null, "Selecione uma categoria para editar.");
				admnistrarCategorias(categorias, locadoras);
			}
		}else if(selection == 2){ // Excluir
			if (categoria_selec != null) {
				excluir(categorias, locadoras, combo.getSelectedIndex());
			}else {
				JOptionPane.showMessageDialog(null, "Selecione uma categoria para excluir.");
				admnistrarCategorias(categorias, locadoras);
			}
		}else if(selection == 3) { // Voltar
			inicial(categorias, locadoras);
		}else{ // Sair
			InterfacePrincipal.sair(categorias, locadoras);
		}
	}
	
	private static void cadastrar(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
        JTextField campo_nome = new JTextField("");
        
        String[] aut_itens = {"Sim", "Não"};
        JComboBox<String> campo_automatico = new JComboBox<>(aut_itens);
        
        JTextField campo_direcao = new JTextField("");
        JTextField campo_portas = new JTextField("");
        
        String[] ar_cond_itens = {"Sim", "Não"};
        JComboBox<String> campo_ar_condicionado = new JComboBox<>(ar_cond_itens);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:"));
        panel.add(campo_nome);
        panel.add(new JLabel("Automático?"));
        panel.add(campo_automatico);
        panel.add(new JLabel("Direção:"));
        panel.add(campo_direcao);
        panel.add(new JLabel("Quantidade de Portas:"));
        panel.add(campo_portas);
        panel.add(new JLabel("Ar Condicionado?"));
        panel.add(campo_ar_condicionado);
        
        try {
        	int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Categoria",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (result == JOptionPane.OK_OPTION) {
            	boolean automatico = true;
            	if(campo_automatico.getSelectedItem().equals("Não")) {
            		automatico = false;
            	}
            	boolean ar_condicionado = true;
            	if(campo_ar_condicionado.getSelectedItem().equals("Não")) {
            		ar_condicionado = false;
            	}
                Categoria c = new Categoria(campo_nome.getText(), automatico, campo_direcao.getText(), Integer.parseInt(campo_portas.getText()), ar_condicionado);
                categorias.add(c);
                JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
            }
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Ocorreu uma exceção.");
        }finally{
        	admnistrarCategorias(categorias, locadoras);
        }
	}
	
	private static void editar(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		JTextField campo_nome = new JTextField(categorias.get(index).getNome());
        
        String[] aut_itens = {"Sim", "Não"};
        JComboBox<String> campo_automatico = new JComboBox<>(aut_itens);
        if(categorias.get(index).isAutomatico()) {
        	campo_automatico.setSelectedIndex(0);
        }else{
        	campo_automatico.setSelectedIndex(1);
        }
        
        JTextField campo_direcao = new JTextField(categorias.get(index).getDirecao());
        JTextField campo_portas = new JTextField(Integer.toString(categorias.get(index).getPortas()));
        
        String[] ar_cond_itens = {"Sim", "Não"};
        JComboBox<String> campo_ar_condicionado = new JComboBox<>(ar_cond_itens);
        if(categorias.get(index).isAr_condicionado()) {
        	campo_ar_condicionado.setSelectedIndex(0);
        }else{
        	campo_ar_condicionado.setSelectedIndex(1);
        }
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:"));
        panel.add(campo_nome);
        panel.add(new JLabel("Automático?"));
        panel.add(campo_automatico);
        panel.add(new JLabel("Direção:"));
        panel.add(campo_direcao);
        panel.add(new JLabel("Quantidade de Portas:"));
        panel.add(campo_portas);
        panel.add(new JLabel("Ar Condicionado?"));
        panel.add(campo_ar_condicionado);
        
        try {
        	int result = JOptionPane.showConfirmDialog(null, panel, "Editar Categoria",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (result == JOptionPane.OK_OPTION) {
            	categorias.get(index).setNome(campo_nome.getText());
            	
            	if(campo_automatico.getSelectedItem().equals("Não")) {
            		categorias.get(index).setAutomatico(false);
            	}else {
            		categorias.get(index).setAutomatico(true);
            	}
            	
            	categorias.get(index).setDirecao(campo_direcao.getText());
            	categorias.get(index).setPortas(Integer.parseInt(campo_portas.getText()));
            	
            	if(campo_ar_condicionado.getSelectedItem().equals("Não")) {
            		categorias.get(index).setAr_condicionado(false);
            	}else{
            		categorias.get(index).setAr_condicionado(true);
            	}

                JOptionPane.showMessageDialog(null, "Categoria editada com sucesso!");
            }
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Ocorreu uma exceção.");
        }finally{
        	admnistrarCategorias(categorias, locadoras);
        }
	}
	
	private static void excluir(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		// Verifica se existe algum veículo utilizando essa categoria
		boolean erro = false;
		ArrayList<Veiculo> veiculosUsados = new ArrayList<Veiculo>();
		for(int i = 0; i < locadoras.size(); i++) {
			for(int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
				if(locadoras.get(i).getVeiculos().get(j).getCategoria().getCodigo() == categorias.get(index).getCodigo()) {
					erro = true;
					veiculosUsados.add(locadoras.get(i).getVeiculos().get(j));
				}
			}
		}
		
		if(erro) {
			String msg = "Não é possível excluir a categoria. Ela é utilizada pelos seguintes veículos:\n";
			for(int i = 0; i < veiculosUsados.size(); i++) {
				msg += veiculosUsados.get(i).toString() + "\n";
			}
			JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE );
		}else {
			categorias.remove(index);
			JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!", null, JOptionPane.INFORMATION_MESSAGE );
		}
		
		admnistrarCategorias(categorias, locadoras);
	}
}
