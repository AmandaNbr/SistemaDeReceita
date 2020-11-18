package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastraReceita extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCodigo;
	private JButton btnCadastrarReceita;
	private JButton btnVoltar;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblCozinheiro;
	private JComboBox comboBoxCozinheiro;
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
	private JComboBox comboBox;
	private JLabel lblCategoria;

	public CadastraReceita() {
		criarTela();
	}
	/**
	 * Launch the application.
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
	 * Create the frame.
	 */	
	private void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 660);
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
	}
	
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
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnCadastrarReceita.setBounds(360, 554, 198, 45);
		contentPane.add(btnCadastrarReceita);
		
		btnAddIngrediente = new JButton("Add ingrediente");
		btnAddIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddIngrediente.setBounds(416, 194, 179, 35);
		contentPane.add(btnAddIngrediente);
	}
	
	private void campoNome() {
		lblNome = new JLabel("Nome");
		lblNome.setBounds(43, 24, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(40, 44, 114, 24);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
	}
	
	private void campoCodigo() {
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(222, 24, 70, 15);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(220, 44, 114, 24);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
	}
	
	private void campoCozinheiro() {
		lblCozinheiro = new JLabel("Cozinheiro");
		lblCozinheiro.setBounds(412, 24, 111, 15);
		contentPane.add(lblCozinheiro);
		
		comboBoxCozinheiro = new JComboBox();
		comboBoxCozinheiro.setBounds(412, 43, 183, 24);
		contentPane.add(comboBoxCozinheiro);
	}
	
	private void campoDataDeCriacao() {
		lblDataDeCriacao = new JLabel("Data de criacao");
		lblDataDeCriacao.setBounds(222, 96, 114, 15);
		contentPane.add(lblDataDeCriacao);
		
		try {
			formattedTextFieldDataDeCriacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldDataDeCriacao.setBounds(220, 115, 114, 24);
			contentPane.add(formattedTextFieldDataDeCriacao);
			formattedTextFieldDataDeCriacao.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void campoPorcoesQueRende() {
		lblPorcoesQueRende = new JLabel("Porcoes que rende");
		lblPorcoesQueRende.setBounds(43, 96, 152, 15);
		contentPane.add(lblPorcoesQueRende);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(1);
		formatter.setMaximum(10000);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);	
				
		formattedTextFieldPorcoesQueRende = new JFormattedTextField(formatter);
		formattedTextFieldPorcoesQueRende.setBounds(43, 115, 50, 24);
		contentPane.add(formattedTextFieldPorcoesQueRende);
		formattedTextFieldPorcoesQueRende.setToolTipText("Selecione o numero para modifica-lo.");
	}
	
	private void campoCategoria() {
		comboBox = new JComboBox();
		comboBox.setBounds(416, 114, 179, 24);
		contentPane.add(comboBox);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(416, 96, 70, 15);
		contentPane.add(lblCategoria);
	}
	
	private void campoModoDePreparo() {
		lblModoDePreparo = new JLabel("Modo de preparo");
		lblModoDePreparo.setBounds(43, 171, 142, 15);
		contentPane.add(lblModoDePreparo);
		
		editorPaneModoDePreparo = new JEditorPane();
		scrollPaneModoDePreparo = new JScrollPane(editorPaneModoDePreparo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneModoDePreparo.setBounds(43, 198, 339, 329);
		contentPane.add(scrollPaneModoDePreparo);
	}
	
	private void campoIngredientes() {
		editorPaneIngredientes = new JEditorPane();
		editorPaneIngredientes.setEditable(false);
		scrollPaneIngredientes = new JScrollPane(editorPaneIngredientes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneIngredientes.setBounds(412, 268, 183, 258);
		contentPane.add(scrollPaneIngredientes);
		
		lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(412, 241, 119, 15);
		contentPane.add(lblIngredientes);
	}
}
