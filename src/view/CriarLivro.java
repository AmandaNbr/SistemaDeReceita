package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldCodigoIsbn;
	private JLabel lblTituloLivro;
	private JLabel lblCodigoIsbn;
	private JLabel lblEditor;
	private JComboBox comboBoxEditor;
	private JButton btnVoltar;
	private JButton btnCriarLivro;
	private JEditorPane editorPaneReceitasAdicionadas;
	private JButton btnAdicionarReceita;
	private JLabel lblReceitasAdicionadas;
	private JComboBox comboBoxReceita;
	private JLabel lblReceitas;

	public CriarLivro() {
		criarTela();
	}
	
	/**
	 * Launch the application.
	 */
	public void startCriarLivro() {
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
		setBounds(100, 100, 550, 585);
		setTitle("Criacao do livro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		initializeButtons();
		
		campoTitulo();

		campoCodigoIsbn();

		campoEditor();
		
		campoReceitas();
		
		campoReceitasAdicionadas();
	}
	
	private void initializeButtons() {
		btnAdicionarReceita = new JButton("Adicionar receita");
		btnAdicionarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarReceita.setBounds(155, 231, 240, 36);
		contentPane.add(btnAdicionarReceita);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(54, 484, 195, 45);
		contentPane.add(btnVoltar);
		
		btnCriarLivro = new JButton("Criar livro");
		btnCriarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnCriarLivro.setBounds(302, 484, 195, 45);
		contentPane.add(btnCriarLivro);
	}
	
	private void campoTitulo() {
		lblTituloLivro = new JLabel("Titulo");
		lblTituloLivro.setBounds(38, 24, 70, 15);
		contentPane.add(lblTituloLivro);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(38, 42, 200, 24);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
	}
	
	private void campoCodigoIsbn() {
		lblCodigoIsbn = new JLabel("Codigo ISBN");
		lblCodigoIsbn.setBounds(297, 24, 129, 15);
		contentPane.add(lblCodigoIsbn);
		
		
		textFieldCodigoIsbn = new JTextField();
		textFieldCodigoIsbn.setBounds(297, 42, 200, 24);
		contentPane.add(textFieldCodigoIsbn);
		textFieldCodigoIsbn.setColumns(10);
	}
	
	private void campoEditor() {
		lblEditor = new JLabel("Editor");
		lblEditor.setBounds(245, 88, 70, 15);
		contentPane.add(lblEditor);
		
		comboBoxEditor = new JComboBox();
		comboBoxEditor.setBounds(126, 109, 300, 24);
		contentPane.add(comboBoxEditor);
	}
	
	private void campoReceitas() {
		lblReceitas = new JLabel("Receitas");
		lblReceitas.setBounds(240, 175, 70, 15);
		contentPane.add(lblReceitas);
		
		comboBoxReceita = new JComboBox();
		comboBoxReceita.setBounds(126, 195, 300, 24);
		contentPane.add(comboBoxReceita);
	}
	
	private void campoReceitasAdicionadas() {
		lblReceitasAdicionadas = new JLabel("Receitas adicionadas");
		lblReceitasAdicionadas.setBounds(200, 292, 169, 15);
		contentPane.add(lblReceitasAdicionadas);
		
		editorPaneReceitasAdicionadas = new JEditorPane();
		editorPaneReceitasAdicionadas.setBounds(106, 319, 338, 147);
		contentPane.add(editorPaneReceitasAdicionadas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 154, 450, 2);
		contentPane.add(separator);
	}
}
