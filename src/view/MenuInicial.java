package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInicial {

	protected JFrame frame;
	private JLabel lblTitulo;
	private JButton btnCadastraCozinheiro;
	private JButton btnCadastraDegustador;
	private JButton btnCadastraEditor;
	private JButton btnCadastraIngrediente;
	private JButton btnCadastraReceita;
	private JButton btnDegustacao;
	private JButton btnCriarLivro;
	private JButton btnImprimirLivro;
	private JButton btnAcessaReceitas;

	/**
	 * Launch the application.
	 */	
	public void startApplication() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sistema de Receitas");
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Bem vindo ao Sistema de Receitas!");
		lblTitulo.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblTitulo.setBounds(38, 35, 474, 70);
		frame.getContentPane().add(lblTitulo);
		
		initializeButtons();
	
	}
	
	private void initializeButtons() {
		
		btnCadastraCozinheiro = new JButton("Cadastrar Cozinheiro");
		btnCadastraCozinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CadastraCozinheiro cadastraCozinheiro = new CadastraCozinheiro();
				cadastraCozinheiro.startCadastraCozinheiro();
			}
		});
		btnCadastraCozinheiro.setBounds(38, 172, 195, 45);
		frame.getContentPane().add(btnCadastraCozinheiro);
		
		
		btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "  O cadastro de degustadores  \n  é feito durante a degustação!  ");
			}
		});
		btnCadastraDegustador.setBounds(273, 172, 195, 45);
		frame.getContentPane().add(btnCadastraDegustador);
		
		
		btnCadastraEditor = new JButton("Cadastrar Editor");
		btnCadastraEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraEditor.setBounds(508, 172, 195, 45);
		frame.getContentPane().add(btnCadastraEditor);
		
		
		btnCadastraIngrediente = new JButton("Cadastrar Ingrediente");
		btnCadastraIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraIngrediente.setBounds(38, 275, 195, 45);
		frame.getContentPane().add(btnCadastraIngrediente);
		
		
		btnCadastraReceita = new JButton("Cadastrar Receita");
		btnCadastraReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraReceita.setBounds(273, 275, 195, 45);
		frame.getContentPane().add(btnCadastraReceita);
		
		
		btnDegustacao = new JButton("Realizar Degustacao");
		btnDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDegustacao.setBounds(508, 275, 195, 45);
		frame.getContentPane().add(btnDegustacao);
		
		
		btnCriarLivro = new JButton("Criar livro");
		btnCriarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarLivro.setBounds(38, 371, 195, 45);
		frame.getContentPane().add(btnCriarLivro);
		
		
		btnImprimirLivro = new JButton("Imprimir livro");
		btnImprimirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimirLivro.setBounds(273, 371, 195, 45);
		frame.getContentPane().add(btnImprimirLivro);
		
		
		btnAcessaReceitas = new JButton("Acessar receitas");
		btnAcessaReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcessaReceitas.setBounds(508, 371, 195, 45);
		frame.getContentPane().add(btnAcessaReceitas);
	}
}
