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
		// Op��es
		Object[] options1 = { "Locadoras", "Categorias", "Voltar" };

		// Mensagem
		JPanel panel = new JPanel();
		panel.add(new JLabel(
				"<html>Aperte um dos bot�es para administrar (cadastrar, editar, excluir).<br/>Lembrando que para cadastrar um ve�culo em uma locadora � necess�rio existir pelo menos 1 categoria.</html>"));
		int result = JOptionPane.showOptionDialog(null, panel, "Escolha a op��o de administrar",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);

		if (result == JOptionPane.YES_OPTION) { // Se ele escolher a op��o de locadoras
			administrarLocadoras(categorias, locadoras);
		} else if (result == JOptionPane.NO_OPTION) { // Se ele escolher a op��o de categorias
			admnistrarCategorias(categorias, locadoras);
		} else {
			InterfacePrincipal.inicial(categorias, locadoras);
		}
	}

	public static void admnistrarCategorias(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		String[] nomes = new String[categorias.size()];
		for (int i = 0; i < categorias.size(); i++) {
			nomes[i] = categorias.get(i).getCodigo() + " - " + categorias.get(i).getNome();
		}

		final JComboBox<String> combo = new JComboBox<>(nomes);

		String[] options = { "Nova", "Editar", "Excluir", "Voltar", "Sair" };

		String title = "Categorias Cadastradas";

		int selection = JOptionPane.showOptionDialog(null, combo, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		Object categoria_selec = combo.getSelectedItem();

		if (selection == 0) { // Nova categoria
			cadastrarCategoria(categorias, locadoras);
		} else if (selection == 1) { // Editar
			if (categoria_selec != null) {
				editarCategoria(categorias, locadoras, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma categoria para editar.");
				admnistrarCategorias(categorias, locadoras);
			}
		} else if (selection == 2) { // Excluir
			if (categoria_selec != null) {
				excluirCategoria(categorias, locadoras, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma categoria para excluir.");
				admnistrarCategorias(categorias, locadoras);
			}
		} else if (selection == 3) { // Voltar
			inicial(categorias, locadoras);
		} else if (selection == 4) { // Sair
			InterfacePrincipal.sair(categorias, locadoras);
		} else { // Bot�o de fechar
			InterfacePrincipal.sair(categorias, locadoras);
		}
	}

	private static void cadastrarCategoria(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		JTextField campo_nome = new JTextField("");

		String[] aut_itens = { "Sim", "N�o" };
		JComboBox<String> campo_automatico = new JComboBox<>(aut_itens);

		JTextField campo_direcao = new JTextField("");
		JTextField campo_portas = new JTextField("");

		String[] ar_cond_itens = { "Sim", "N�o" };
		JComboBox<String> campo_ar_condicionado = new JComboBox<>(ar_cond_itens);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nome:"));
		panel.add(campo_nome);
		panel.add(new JLabel("Autom�tico?"));
		panel.add(campo_automatico);
		panel.add(new JLabel("Dire��o:"));
		panel.add(campo_direcao);
		panel.add(new JLabel("Quantidade de Portas:"));
		panel.add(campo_portas);
		panel.add(new JLabel("Ar Condicionado?"));
		panel.add(campo_ar_condicionado);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Categoria", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				boolean automatico = true;
				if (campo_automatico.getSelectedItem().equals("N�o")) {
					automatico = false;
				}
				boolean ar_condicionado = true;
				if (campo_ar_condicionado.getSelectedItem().equals("N�o")) {
					ar_condicionado = false;
				}
				Categoria c = new Categoria(campo_nome.getText(), automatico, campo_direcao.getText(),
						Integer.parseInt(campo_portas.getText()), ar_condicionado);
				categorias.add(c);
				JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
			}
		} catch (NumeroInvalidoException nie) {
			JOptionPane.showMessageDialog(null, nie.getMessage());
		} catch (NumberFormatException nf) {
			JOptionPane.showMessageDialog(null, "ERRO: N�mero inv�lido!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			admnistrarCategorias(categorias, locadoras);
		}
	}

	private static void editarCategoria(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		JTextField campo_nome = new JTextField(categorias.get(index).getNome());

		String[] aut_itens = { "Sim", "N�o" };
		JComboBox<String> campo_automatico = new JComboBox<>(aut_itens);
		if (categorias.get(index).isAutomatico()) {
			campo_automatico.setSelectedIndex(0);
		} else {
			campo_automatico.setSelectedIndex(1);
		}

		JTextField campo_direcao = new JTextField(categorias.get(index).getDirecao());
		JTextField campo_portas = new JTextField(Integer.toString(categorias.get(index).getPortas()));

		String[] ar_cond_itens = { "Sim", "N�o" };
		JComboBox<String> campo_ar_condicionado = new JComboBox<>(ar_cond_itens);
		if (categorias.get(index).isAr_condicionado()) {
			campo_ar_condicionado.setSelectedIndex(0);
		} else {
			campo_ar_condicionado.setSelectedIndex(1);
		}

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nome:"));
		panel.add(campo_nome);
		panel.add(new JLabel("Autom�tico?"));
		panel.add(campo_automatico);
		panel.add(new JLabel("Dire��o:"));
		panel.add(campo_direcao);
		panel.add(new JLabel("Quantidade de Portas:"));
		panel.add(campo_portas);
		panel.add(new JLabel("Ar Condicionado?"));
		panel.add(campo_ar_condicionado);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Editar Categoria", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				categorias.get(index).setNome(campo_nome.getText());

				if (campo_automatico.getSelectedItem().equals("N�o")) {
					categorias.get(index).setAutomatico(false);
				} else {
					categorias.get(index).setAutomatico(true);
				}

				categorias.get(index).setDirecao(campo_direcao.getText());
				categorias.get(index).setPortas(Integer.parseInt(campo_portas.getText()));

				if (campo_ar_condicionado.getSelectedItem().equals("N�o")) {
					categorias.get(index).setAr_condicionado(false);
				} else {
					categorias.get(index).setAr_condicionado(true);
				}

				// Ap�s editar a categoria na lista, � necess�rio atualizar a categoria nos
				// ve�culos que a utilizam
				for (int i = 0; i < locadoras.size(); i++) {
					for (int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
						if (locadoras.get(i).getVeiculos().get(j).getCategoria().getCodigo() == categorias.get(index)
								.getCodigo()) {
							locadoras.get(i).getVeiculos().get(j).setCategoria(categorias.get(index));
						}
					}
				}

				JOptionPane.showMessageDialog(null, "Categoria editada com sucesso!");
			}
		} catch (NumeroInvalidoException nie) {
			JOptionPane.showMessageDialog(null, nie.getMessage());
		} catch (NumberFormatException nf) {
			JOptionPane.showMessageDialog(null, "ERRO: N�mero inv�lido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			admnistrarCategorias(categorias, locadoras);
		}
	}

	private static void excluirCategoria(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Voc� tem certeze que deseja excluir a categoria '"
				+ categorias.get(index).getCodigo() + " - " + categorias.get(index).getNome() + "'?", "ATEN��O",
				dialogButton);

		if (dialogResult == JOptionPane.YES_OPTION) {
			// Verifica se existe algum ve�culo utilizando essa categoria
			boolean erro = false;
			for (int i = 0; i < locadoras.size(); i++) {
				for (int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
					if (locadoras.get(i).getVeiculos().get(j).getCategoria().getCodigo() == categorias.get(index)
							.getCodigo()) {
						erro = true;
					}
				}
			}

			if (erro) {
				String msg = "N�o � poss�vel excluir a categoria.\nEla � utilizada pelos seguintes ve�culos:\n";
				for (int i = 0; i < locadoras.size(); i++) {
					for (int j = 0; j < locadoras.get(i).getVeiculos().size(); j++) {
						if (locadoras.get(i).getVeiculos().get(j).getCategoria().getCodigo() == categorias.get(index)
								.getCodigo()) {
							msg += "\nLocadora: " + locadoras.get(i).getNome() + "\n";
							msg += "Ve�culo: " + locadoras.get(i).getVeiculos().get(j).getCodigo() + " - "
									+ locadoras.get(i).getVeiculos().get(j).getMarca() + " - "
									+ locadoras.get(i).getVeiculos().get(j).getModelo() + " - "
									+ locadoras.get(i).getVeiculos().get(j).getAno() + "\n";
						}
					}
				}
				JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				categorias.remove(index);
				JOptionPane.showMessageDialog(null, "Categoria exclu�da com sucesso!", null,
						JOptionPane.INFORMATION_MESSAGE);
			}

			admnistrarCategorias(categorias, locadoras);
		} else {
			admnistrarCategorias(categorias, locadoras);
		}
	}

	private static void administrarLocadoras(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		String[] nomes = new String[locadoras.size()];
		for (int i = 0; i < locadoras.size(); i++) {
			nomes[i] = locadoras.get(i).getCodigo() + " - " + locadoras.get(i).getNome();
		}

		final JComboBox<String> combo = new JComboBox<>(nomes);

		String[] options = { "Nova", "Visualizar", "Editar", "Excluir", "Voltar", "Sair" };

		String title = "Locadoras Cadastradas";

		int selection = JOptionPane.showOptionDialog(null, combo, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		Object loc_selec = combo.getSelectedItem();

		if (selection == 0) { // Nova locadora
			cadastrarLocadora(categorias, locadoras);
		} else if (selection == 1) { // Visualizar
			if (loc_selec != null) {
				visualizarLocadora(categorias, locadoras, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma locadora para visualizar.");
				administrarLocadoras(categorias, locadoras);
			}
		} else if (selection == 2) { // Editar
			if (loc_selec != null) {
				editarLocadora(categorias, locadoras, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma locadora para editar.");
				administrarLocadoras(categorias, locadoras);
			}
		} else if (selection == 3) { // Excluir
			if (loc_selec != null) {
				excluirLocadora(categorias, locadoras, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma locadora para excluir.");
				administrarLocadoras(categorias, locadoras);
			}
		} else if (selection == 4) { // Voltar
			inicial(categorias, locadoras);
		} else if (selection == 5) { // Sair
			InterfacePrincipal.sair(categorias, locadoras);
		} else { // Bot�o de fechar
			InterfacePrincipal.sair(categorias, locadoras);
		}
	}

	private static void cadastrarLocadora(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras) {
		JTextField campo_nome = new JTextField("");

		JTextField campo_cnpj = new JTextField("");

		JTextField campo_telefone = new JTextField("");

		JTextField campo_endereco = new JTextField("");

		JTextField campo_bairro = new JTextField("");

		JTextField campo_cidade = new JTextField("");

		JTextField campo_estado = new JTextField("");

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nome:"));
		panel.add(campo_nome);
		panel.add(new JLabel("CNPJ:"));
		panel.add(campo_cnpj);
		panel.add(new JLabel("Telefone:"));
		panel.add(campo_telefone);
		panel.add(new JLabel("Endere�o:"));
		panel.add(campo_endereco);
		panel.add(new JLabel("Bairro:"));
		panel.add(campo_bairro);
		panel.add(new JLabel("Cidade:"));
		panel.add(campo_cidade);
		panel.add(new JLabel("Estado:"));
		panel.add(campo_estado);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Locadora", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				Localizacao loc = new Localizacao(campo_endereco.getText(), campo_bairro.getText(),
						campo_cidade.getText(), campo_estado.getText());
				Locadora c = new Locadora(campo_nome.getText(), campo_cnpj.getText(), campo_telefone.getText(), loc);
				locadoras.add(c);
				JOptionPane.showMessageDialog(null, "Locadora cadastrada com sucesso!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			administrarLocadoras(categorias, locadoras);
		}
	}

	private static void editarLocadora(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		JTextField campo_nome = new JTextField(locadoras.get(index).getNome());

		JTextField campo_cnpj = new JTextField(locadoras.get(index).getCnpj());

		JTextField campo_telefone = new JTextField(locadoras.get(index).getTelefone());

		JTextField campo_endereco = new JTextField(locadoras.get(index).getLocalizacao().getEndereco());

		JTextField campo_bairro = new JTextField(locadoras.get(index).getLocalizacao().getBairro());

		JTextField campo_cidade = new JTextField(locadoras.get(index).getLocalizacao().getCidade());

		JTextField campo_estado = new JTextField(locadoras.get(index).getLocalizacao().getEstado());

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nome:"));
		panel.add(campo_nome);
		panel.add(new JLabel("CNPJ:"));
		panel.add(campo_cnpj);
		panel.add(new JLabel("Telefone:"));
		panel.add(campo_telefone);
		panel.add(new JLabel("Endere�o:"));
		panel.add(campo_endereco);
		panel.add(new JLabel("Bairro:"));
		panel.add(campo_bairro);
		panel.add(new JLabel("Cidade:"));
		panel.add(campo_cidade);
		panel.add(new JLabel("Estado:"));
		panel.add(campo_estado);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Editar Locadora", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				locadoras.get(index).setNome(campo_nome.getText());
				locadoras.get(index).setCnpj(campo_cnpj.getText());
				locadoras.get(index).setTelefone(campo_telefone.getText());
				locadoras.get(index).getLocalizacao().setEndereco(campo_endereco.getText());
				locadoras.get(index).getLocalizacao().setBairro(campo_bairro.getText());
				locadoras.get(index).getLocalizacao().setCidade(campo_cidade.getText());
				locadoras.get(index).getLocalizacao().setEstado(campo_estado.getText());

				JOptionPane.showMessageDialog(null, "Locadora editada com sucesso!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			administrarLocadoras(categorias, locadoras);
		}
	}

	private static void excluirLocadora(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Voc� tem certeze que deseja excluir a locadora '" + locadoras.get(index).getNome() + "'?", "ATEN��O",
				dialogButton);

		if (dialogResult == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Locadora exclu�da com sucesso!", null,
					JOptionPane.INFORMATION_MESSAGE);
			locadoras.remove(index);
			administrarLocadoras(categorias, locadoras);
		} else {
			administrarLocadoras(categorias, locadoras);
		}
	}

	private static void visualizarLocadora(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras, int index) {
		String[] nomes = new String[locadoras.get(index).getVeiculos().size()];
		for (int i = 0; i < locadoras.get(index).getVeiculos().size(); i++) {
			nomes[i] = locadoras.get(index).getVeiculos().get(i).getCodigo() + " - "
					+ locadoras.get(index).getVeiculos().get(i).getMarca() + " - "
					+ locadoras.get(index).getVeiculos().get(i).getModelo() + " - "
					+ Integer.toString(locadoras.get(index).getVeiculos().get(i).getAno());
		}

		final JComboBox<String> combo = new JComboBox<>(nomes);

		String[] options = { "Novo", "Editar", "Excluir", "Voltar", "Sair" };

		String title = locadoras.get(index).getNome() + " - Ve�culos Cadastrados";

		int selection = JOptionPane.showOptionDialog(null, combo, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		Object veic_selec = combo.getSelectedItem();

		if (selection == 0) { // Novo Ve�culo
			cadastrarVeiculo(categorias, locadoras, index);
		} else if (selection == 1) { // Editar
			if (veic_selec != null) {
				editarVeiculo(categorias, locadoras, index, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione um ve�culo para editar.");
				visualizarLocadora(categorias, locadoras, index);
			}
		} else if (selection == 2) { // Excluir
			if (veic_selec != null) {
				excluirVeiculo(categorias, locadoras, index, combo.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione um ve�culo para excluir.");
				visualizarLocadora(categorias, locadoras, index);
			}
		} else if (selection == 3) { // Voltar
			administrarLocadoras(categorias, locadoras);
		} else if (selection == 4) { // Sair
			InterfacePrincipal.sair(categorias, locadoras);
		} else { // Bot�o de fechar
			InterfacePrincipal.sair(categorias, locadoras);
		}
	}

	private static void cadastrarVeiculo(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras,
			int index_locadora) {
		JTextField campo_marca = new JTextField("");

		JTextField campo_modelo = new JTextField("");

		JTextField campo_ano = new JTextField("");

		JTextField campo_acessorios = new JTextField("");

		JTextField campo_preco = new JTextField("");

		String[] categorias_nomes = new String[categorias.size()];
		for (int i = 0; i < categorias.size(); i++) {
			categorias_nomes[i] = categorias.get(i).getCodigo() + " - " + categorias.get(i).getNome();
		}
		JComboBox<String> campo_categoria = new JComboBox<>(categorias_nomes);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Marca:"));
		panel.add(campo_marca);
		panel.add(new JLabel("Modelo:"));
		panel.add(campo_modelo);
		panel.add(new JLabel("Ano:"));
		panel.add(campo_ano);
		panel.add(new JLabel("Acess�rios:"));
		panel.add(campo_acessorios);
		panel.add(new JLabel("Pre�o do aluguel:"));
		panel.add(campo_preco);
		panel.add(new JLabel("Categoria:"));
		panel.add(campo_categoria);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Ve�culo", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				if (campo_categoria.getSelectedItem() != null) {
					Veiculo v = new Veiculo(campo_marca.getText(), campo_modelo.getText(),
							Integer.parseInt(campo_ano.getText()), campo_acessorios.getText(),
							Double.parseDouble(campo_preco.getText()),
							categorias.get(campo_categoria.getSelectedIndex()));
					locadoras.get(index_locadora).addVeiculo(v);
					JOptionPane.showMessageDialog(null, "Ve�culo cadastrado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "� necess�rio escolher uma categoria para cadastrar!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NumeroInvalidoException nie) {
			JOptionPane.showMessageDialog(null, nie.getMessage());
		} catch(NumberFormatException nf) {
				JOptionPane.showMessageDialog(null, "ERRO: N�mero inv�lido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			visualizarLocadora(categorias, locadoras, index_locadora);
		}
	}

	private static void editarVeiculo(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras,
			int index_locadora, int index) {
		JTextField campo_marca = new JTextField(locadoras.get(index_locadora).getVeiculos().get(index).getMarca());

		JTextField campo_modelo = new JTextField(locadoras.get(index_locadora).getVeiculos().get(index).getModelo());

		JTextField campo_ano = new JTextField(
				Integer.toString(locadoras.get(index_locadora).getVeiculos().get(index).getAno()));

		JTextField campo_acessorios = new JTextField(
				locadoras.get(index_locadora).getVeiculos().get(index).getAcessorios());

		JTextField campo_preco = new JTextField(
				Double.toString(locadoras.get(index_locadora).getVeiculos().get(index).getPreco()));

		String[] categorias_nomes = new String[categorias.size()];
		int cat_index = 0;
		for (int i = 0; i < categorias.size(); i++) {
			categorias_nomes[i] = categorias.get(i).getCodigo() + " - " + categorias.get(i).getNome();
			// Encontra a categoria do ve�culo que est� sendo editado
			if (categorias.get(i).getCodigo() == locadoras.get(index_locadora).getVeiculos().get(index).getCategoria()
					.getCodigo()) {
				cat_index = i;
			}
		}
		JComboBox<String> campo_categoria = new JComboBox<>(categorias_nomes);
		campo_categoria.setSelectedIndex(cat_index);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Marca:"));
		panel.add(campo_marca);
		panel.add(new JLabel("Modelo:"));
		panel.add(campo_modelo);
		panel.add(new JLabel("Ano:"));
		panel.add(campo_ano);
		panel.add(new JLabel("Acess�rios:"));
		panel.add(campo_acessorios);
		panel.add(new JLabel("Pre�o do aluguel:"));
		panel.add(campo_preco);
		panel.add(new JLabel("Categoria:"));
		panel.add(campo_categoria);

		try {
			int result = JOptionPane.showConfirmDialog(null, panel, "Editar Ve�culo", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				if (campo_categoria.getSelectedItem() != null) {
					locadoras.get(index_locadora).getVeiculos().get(index).setMarca(campo_marca.getText());
					locadoras.get(index_locadora).getVeiculos().get(index).setModelo(campo_modelo.getText());
					locadoras.get(index_locadora).getVeiculos().get(index)
							.setAno(Integer.parseInt(campo_ano.getText()));
					locadoras.get(index_locadora).getVeiculos().get(index).setAcessorios(campo_acessorios.getText());
					locadoras.get(index_locadora).getVeiculos().get(index)
							.setPreco(Double.parseDouble(campo_preco.getText()));
					locadoras.get(index_locadora).getVeiculos().get(index)
							.setCategoria(categorias.get(campo_categoria.getSelectedIndex()));

					JOptionPane.showMessageDialog(null, "Ve�culo editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "� necess�rio escolher uma categoria!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NumeroInvalidoException nie) {
			JOptionPane.showMessageDialog(null, nie.getMessage());
		} catch(NumberFormatException nf) {
				JOptionPane.showMessageDialog(null, "ERRO: N�mero inv�lido!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma exce��o.");
		} finally {
			visualizarLocadora(categorias, locadoras, index_locadora);
		}
	}

	private static void excluirVeiculo(ArrayList<Categoria> categorias, ArrayList<Locadora> locadoras,
			int index_locadora, int index) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Voc� tem certeze que deseja excluir o ve�culo '"
						+ locadoras.get(index_locadora).getVeiculos().get(index).getMarca() + " - "
						+ locadoras.get(index_locadora).getVeiculos().get(index).getModelo() + "'?",
				"ATEN��O", dialogButton);

		if (dialogResult == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Ve�culo exclu�do com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
			locadoras.get(index_locadora).getVeiculos().remove(index);
			visualizarLocadora(categorias, locadoras, index_locadora);
		} else {
			visualizarLocadora(categorias, locadoras, index_locadora);
		}
	}
}
