package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.LivroDeReceitaController;
import model.LivroDeReceita;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Cria a tela de acesso a livros pegando dados do livroDeReceitaController
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
@SuppressWarnings("serial")
public class ImprimirLivro extends JFrame {

	private LivroDeReceitaController livroDeReceitaController = new LivroDeReceitaController();
	private JPanel contentPane;
	private JSeparator separator ;
	private JEditorPane editorPaneLivroDeReceita;
	private JComboBox<LivroDeReceita> comboBoxLivroDeReceita;
	private JLabel lblLivros;
	private JButton btnVoltar;
	private JScrollPane scrollPaneLivroDeReceita;

	public ImprimirLivro() {
		criarTela();
	}
	
	/**
	 * Cria a aplicacao
	 */
	public void startImprimirLivro() {
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
		setBounds(100, 100, 550, 500);
		setTitle("Impressao do livro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializeButton();
		
		campoLivro();
		
		addSeparador();
		
		/*
		 * Coloca o campo como disabled para nao dar nullpointer
		 */
		if(livroDeReceitaController.getAllLivrosDeReceita().isEmpty()) {
			comboBoxLivroDeReceita.setEnabled(false);
		}
	}
	
	/**
	 * Botao e acoes do botao
	 */
	private void initializeButton() {
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(191, 399, 175, 45);
		contentPane.add(btnVoltar);
	}
	
	/**
	 * Componentes visuais para o campo livro
	 */
	private void campoLivro() {
		lblLivros = new JLabel("Livros");
		lblLivros.setBounds(246, 12, 70, 15);
		contentPane.add(lblLivros);
		
		editorPaneLivroDeReceita = new JEditorPane();
		editorPaneLivroDeReceita.setEditable(false);
		scrollPaneLivroDeReceita = new JScrollPane(editorPaneLivroDeReceita, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLivroDeReceita.setBounds(41, 122, 476, 257);
		contentPane.add(scrollPaneLivroDeReceita);
		
		comboBoxLivroDeReceita = new JComboBox<LivroDeReceita>();
		comboBoxLivroDeReceita.setMaximumRowCount(50);
		comboBoxLivroDeReceita.setBounds(77, 39, 378, 24);
		for (LivroDeReceita livroDeReceita: livroDeReceitaController.getAllLivrosDeReceita()) {
			comboBoxLivroDeReceita.addItem(livroDeReceita);
		}
		
		comboBoxLivroDeReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!livroDeReceitaController.getAllLivrosDeReceita().isEmpty() &&  !(comboBoxLivroDeReceita.getSelectedItem() == null)) {		
					editorPaneLivroDeReceita.setText(livroDeReceitaController.montarCapaDoLivroDeReceita((LivroDeReceita) comboBoxLivroDeReceita.getSelectedItem()) + livroDeReceitaController.montarLivroDeReceita((LivroDeReceita) comboBoxLivroDeReceita.getSelectedItem()));
				}
			}
		});
		
		comboBoxLivroDeReceita.setSelectedItem(null);
			
		contentPane.add(comboBoxLivroDeReceita);
	}
	
	/**
	 * Adiciona o componente visual separador
	 */
	private void addSeparador() {
		separator = new JSeparator();
		separator.setBounds(60, 89, 425, 2);
		contentPane.add(separator);
	}
}
