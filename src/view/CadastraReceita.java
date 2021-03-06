package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.CozinheiroController;
import controller.IngredienteController;
import controller.IngredienteDaReceitaController;
import controller.ReceitaController;
import model.Cozinheiro;
import model.Funcionario;
import model.Ingrediente;
import model.IngredienteDaReceita;
import model.ReceitaCategorias;
import utils.DataUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Cria a tela de cadastro de receitas pegando e guardando dados nas controllers
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
@SuppressWarnings("serial")
public class CadastraReceita extends JFrame {

	private ReceitaController receitaController = new ReceitaController();
	private CozinheiroController cozinheiroController = new CozinheiroController();
	private IngredienteController ingredienteController = new IngredienteController();
	private IngredienteDaReceitaController ingredienteDaReceitaController = new IngredienteDaReceitaController();
	private ArrayList<IngredienteDaReceita> ingredientesDaReceita = new ArrayList<IngredienteDaReceita>();
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCodigo;
	private JButton btnCadastrarReceita;
	private JButton btnVoltar;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblCozinheiro;
	private JComboBox<Cozinheiro> comboBoxCozinheiro;
	private JLabel lblDataDeCriacao;
	private JLabel lblPorcoesQueRende;
	private JButton btnAddIngrediente;
	private JLabel lblModoDePreparo;
	private JEditorPane editorPaneModoDePreparo;
	private JScrollPane scrollPaneModoDePreparo;
	private JEditorPane editorPaneIngredientes;
	private JScrollPane scrollPaneIngredientes;
	private JLabel lblIngredientes;
	private JFormattedTextField formattedTextFieldDataDeCriacao;
	private JFormattedTextField formattedTextFieldPorcoesQueRende;
	private JComboBox<ReceitaCategorias> comboBoxCategoria;
	private JLabel lblCategoria;
	private JPanel popUpIngrediente;
	private JLabel lblIngredientePopUp;
	private JComboBox<Ingrediente> comboBoxNome;
	private JLabel lblQuantidadePopUp;
	private JFormattedTextField formattedFieldQuantidade;
	private JLabel lblMedidaPopUp;
	private JTextField textFieldMedida;
	private boolean test = false;

	public CadastraReceita() {
		criarTela();
	}
	/**
	 * Cria a aplicacao
	 */
	public void startCadastraReceita() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setLocationRelativeTo(null);
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame
	 */	
	private void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 660);
		setTitle("Cadastro de Receita");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializeButtons();
		
		campoNome();
		
		campoCodigo();
		
		campoCozinheiro();

		campoDataDeCriacao();
		
		campoPorcoesQueRende();
		
		campoCategoria();
		
		campoModoDePreparo();
		
		campoIngredientes();
		
		/*
		 * Coloca certos campos como disabled para nao dar nullpointer
		 */
		if(cozinheiroController.validarCozinheiroVazio()) {
			btnCadastrarReceita.setEnabled(false);
			comboBoxCozinheiro.setEnabled(false);
		}
		
		/*
		 * Coloca certos campos como disabled para nao dar nullpointer
		 */
		if(ingredienteController.validarIngredienteVazio()) {
			btnAddIngrediente.setEnabled(false);
			btnCadastrarReceita.setEnabled(false);
		}
		
		test = true;
	}
	
	/**
	 * Verifica se cada validacao é verdadeira 
	 * @return se todas as validacoes forem validas retorna verdadeiro, se não, retorna a mensagem de erro especifica
	 */
	private boolean checarCampos() {
		
		boolean camposValidos = receitaController.validarNomeVazio(textFieldNome.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um nome!  ");
			return camposValidos;
		}
		
		camposValidos = receitaController.validarNomeRepetido(textFieldNome.getText(),
															  (Cozinheiro )comboBoxCozinheiro.getSelectedItem());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  O cozinheiro nao pode ter receitas com o mesmo nome!  ");
			return camposValidos;
		}
		
		camposValidos = DataUtils.validarData(formattedTextFieldDataDeCriacao.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma data de criacao!  ");
			return camposValidos;
		}
		
		camposValidos = receitaController.validarDataDeCriacao(formattedTextFieldDataDeCriacao.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "   A data de criacao deve ser igual  \n  ou antes da data atual!  ");
			return camposValidos;
		}
		
		camposValidos = receitaController.validarCodigoVazio(textFieldCodigo.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um codigo!  ");
			return camposValidos;
		}
	
		camposValidos = receitaController.validarCodigoRepetido(textFieldCodigo.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Codigo repetido. O codigo deve ser unico!  ");
			return camposValidos;
		}
		
		camposValidos = receitaController.validarModoDePreparoVazio(editorPaneModoDePreparo.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe o modo de preparo!  ");
			return camposValidos;
		}
		
		camposValidos = receitaController.validarIngredienteVazio(editorPaneIngredientes.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Adicione pelo menos um ingrediente!  ");
			return camposValidos;
		}
		
		return camposValidos;
	}
	
	/**
	 * Botoes e acoes dos botoes
	 */
	private void initializeButtons() {
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(68, 554, 198, 45);
		contentPane.add(btnVoltar);
		
		btnCadastrarReceita = new JButton("Cadastrar receita");
		btnCadastrarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean camposValidos = checarCampos();
				
				if(camposValidos) {
					dispose();
					JOptionPane.showMessageDialog(null, "   Receita cadastrada com sucesso!   ");
					receitaController.cadastraReceita(textFieldNome.getText(),
													  textFieldCodigo.getText(),
													  formattedTextFieldDataDeCriacao.getText(),
													  formattedTextFieldPorcoesQueRende.getText(),
													  (ReceitaCategorias) comboBoxCategoria.getSelectedItem(),
													  ingredientesDaReceita,
													  (Cozinheiro) comboBoxCozinheiro.getSelectedItem(),
													  editorPaneModoDePreparo.getText());
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				}
			}
		});
		btnCadastrarReceita.setBounds(429, 554, 198, 45);
		contentPane.add(btnCadastrarReceita);
		
		btnAddIngrediente = new JButton("Add ingrediente");
		btnAddIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarPopUp();
			}
		});
		btnAddIngrediente.setBounds(448, 194, 179, 35);
		contentPane.add(btnAddIngrediente);
	}
	
	/**
	 * Cria um popup para escolher os ingredientes da receita e colocar a medida e quantidade
	 */
	private void criarPopUp() {
		popUpIngrediente = new JPanel(new GridLayout(0, 1));
		
		campoIngredientePopUp();
		
		campoQuantidadePopUp();
		
		campoMedidaPopUp();

		int resultado = JOptionPane.showConfirmDialog(null, popUpIngrediente, "Adicionar Ingrediente",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (resultado == JOptionPane.OK_OPTION) {
			ingredientesDaReceita.add(ingredienteDaReceitaController.montarIngredienteDaReceita((Ingrediente) comboBoxNome.getSelectedItem(),
				    																			formattedFieldQuantidade.getText(),
				    																			textFieldMedida.getText()));

			editorPaneIngredientes.setText(ingredienteDaReceitaController.montarListaDeIngredienteDaReceita(ingredientesDaReceita));
		} else {
			// Nada a fazer
		}
	}
	
	/**
	 * Componentes visuais para o campo ingrediente do popup
	 */
	private void campoIngredientePopUp() {
		lblIngredientePopUp = new JLabel("Ingrediente:");		
		popUpIngrediente.add(lblIngredientePopUp);
		
		comboBoxNome = new JComboBox<Ingrediente>();
		popUpIngrediente.add(comboBoxNome);
		
		for (Ingrediente ingredienteAtual : ingredienteController.getAllIngredientes()) {
			comboBoxNome.addItem(ingredienteAtual);
		}
	}
	
	/**
	 * Componentes visuais para o campo quantidade do popup
	 */
	private void campoQuantidadePopUp() {
		lblQuantidadePopUp = new JLabel("Quantidade:");
		popUpIngrediente.add(lblQuantidadePopUp);
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(1);
		format.setMinimumFractionDigits(1);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.5);
		formatter.setMaximum(10000.0);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(false);
		
		formattedFieldQuantidade = new JFormattedTextField(formatter);
		formattedFieldQuantidade.setValue(1.0);
		formattedFieldQuantidade.setToolTipText("Selecione o numero para modifica-lo.");
		popUpIngrediente.add(formattedFieldQuantidade);
	}
	
	/**
	 * Componentes visuais para o campo medida popup
	 */
	private void campoMedidaPopUp() {
		lblMedidaPopUp = new JLabel("Medida: Opcional");
		popUpIngrediente.add(lblMedidaPopUp);
		textFieldMedida = new JTextField();
		popUpIngrediente.add(textFieldMedida);	
	}	
	
	/**
	 * Componentes visuais para o campo nome
	 */
	private void campoNome() {
		lblNome = new JLabel("Nome");
		lblNome.setBounds(43, 24, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(43, 44, 280, 24);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
	}
	
	/**
	 * Componentes visuais para o campo codigo
	 */
	private void campoCodigo() {
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(547, 96, 70, 15);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(547, 115, 114, 24);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
	}
	
	/**
	 * Componentes visuais para o campo cozinheiro
	 */
	private void campoCozinheiro() {
		lblCozinheiro = new JLabel("Cozinheiro");
		lblCozinheiro.setBounds(366, 24, 111, 15);
		contentPane.add(lblCozinheiro);

		comboBoxCozinheiro = new JComboBox<Cozinheiro>();
		comboBoxCozinheiro.setMaximumRowCount(100);
		comboBoxCozinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (test)
					checarInatividade();
			}
		});
		comboBoxCozinheiro.setBounds(366, 43, 295, 24);
		
		for (Funcionario cozinheiro : cozinheiroController.getAllCozinheiros()) {
			comboBoxCozinheiro.addItem(((Cozinheiro) cozinheiro));
		}
		
		comboBoxCozinheiro.setSelectedItem(null);
		
		contentPane.add(comboBoxCozinheiro);
	}
	
	/**
	 * Confere se o cozinheiro esta dentro do prazo de criacao de receita
	 */
	private void checarInatividade() {
		if(!cozinheiroController.validarInatividadeReceita((Cozinheiro) comboBoxCozinheiro.getSelectedItem())) {
			JOptionPane.showMessageDialog(null, "   O cozinheiro selecionado ultrapassou o tempo limite   \n   para criacao de novas receitas.   ");
		}
	}
	
	/**
	 * Componentes visuais para o campo data de criacao
	 */
	private void campoDataDeCriacao() {
		lblDataDeCriacao = new JLabel("Data de criacao");
		lblDataDeCriacao.setBounds(209, 96, 114, 15);
		contentPane.add(lblDataDeCriacao);
		
		try {
			formattedTextFieldDataDeCriacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldDataDeCriacao.setBounds(209, 115, 114, 24);
			contentPane.add(formattedTextFieldDataDeCriacao);
			formattedTextFieldDataDeCriacao.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Componentes visuais para o campo porcoes que rende
	 */
	private void campoPorcoesQueRende() {
		lblPorcoesQueRende = new JLabel("Porcoes que rende");
		lblPorcoesQueRende.setBounds(43, 96, 152, 15);
		contentPane.add(lblPorcoesQueRende);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(1);
		formatter.setMaximum(10001);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);	
	
		formattedTextFieldPorcoesQueRende = new JFormattedTextField(formatter);
		formattedTextFieldPorcoesQueRende.setValue(1);
		formattedTextFieldPorcoesQueRende.setBounds(43, 115, 70, 24);
		contentPane.add(formattedTextFieldPorcoesQueRende);
		formattedTextFieldPorcoesQueRende.setToolTipText("Selecione o numero para modifica-lo.");
	}
	
	/**
	 * Componentes visuais para o campo categoria
	 */
	private void campoCategoria() {
		comboBoxCategoria = new JComboBox<ReceitaCategorias>(ReceitaCategorias.values());
		comboBoxCategoria.setBounds(366, 114, 142, 24);
		contentPane.add(comboBoxCategoria);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(366, 96, 70, 15);
		contentPane.add(lblCategoria);
	}
	
	/**
	 * Componentes visuais para o campo modo de preparo
	 */
	private void campoModoDePreparo() {
		lblModoDePreparo = new JLabel("Modo de preparo");
		lblModoDePreparo.setBounds(43, 171, 142, 15);
		contentPane.add(lblModoDePreparo);
		
		editorPaneModoDePreparo = new JEditorPane();
		scrollPaneModoDePreparo = new JScrollPane(editorPaneModoDePreparo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneModoDePreparo.setBounds(43, 198, 339, 329);
		contentPane.add(scrollPaneModoDePreparo);
	}
	
	/**
	 * Componentes visuais para o campo ingredientes
	 */
	private void campoIngredientes() {
		editorPaneIngredientes = new JEditorPane();
		editorPaneIngredientes.setEditable(false);
		scrollPaneIngredientes = new JScrollPane(editorPaneIngredientes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneIngredientes.setBounds(412, 268, 261, 258);
		contentPane.add(scrollPaneIngredientes);
		
		lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(412, 241, 119, 15);
		contentPane.add(lblIngredientes);
	}
}
