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

	private JFrame frame;

	/**
	 * Launch the application.
	 */	
	public void startApplication() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
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
		frame.setBounds(100, 100, 740, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sistema de Receitas");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo ao Sistema de Receitas!");
		lblNewLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(38, 35, 474, 70);
		frame.getContentPane().add(lblNewLabel);
		
		initializeButtons();
	
	}
	
	private void initializeButtons() {
		
		JButton btnCadastraCozinheiro = new JButton("Cadastrar Cozinheiro");
		btnCadastraCozinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraCozinheiro.setBounds(38, 172, 195, 45);
		frame.getContentPane().add(btnCadastraCozinheiro);
		
		
		JButton btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "  O cadastro de degustadores  \n  é feito durante a degustação!  ");
			}
		});
		btnCadastraDegustador.setBounds(273, 172, 195, 45);
		frame.getContentPane().add(btnCadastraDegustador);
		
		
		JButton btnCadastraEditor = new JButton("Cadastrar Editor");
		btnCadastraEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraEditor.setBounds(508, 172, 195, 45);
		frame.getContentPane().add(btnCadastraEditor);
		
		
		JButton btnCadastraIngrediente = new JButton("Cadastrar Ingrediente");
		btnCadastraIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraIngrediente.setBounds(38, 275, 195, 45);
		frame.getContentPane().add(btnCadastraIngrediente);
		
		
		JButton btnCadastraReceita = new JButton("Cadastrar Receita");
		btnCadastraReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastraReceita.setBounds(273, 275, 195, 45);
		frame.getContentPane().add(btnCadastraReceita);
		
		
		JButton btnDegustacao = new JButton("Realizar Degustacao");
		btnDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDegustacao.setBounds(508, 275, 195, 45);
		frame.getContentPane().add(btnDegustacao);
		
		
		JButton btnEditarLivro = new JButton("Editar livro");
		btnEditarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarLivro.setBounds(38, 371, 195, 45);
		frame.getContentPane().add(btnEditarLivro);
		
		
		JButton btnImprimirLivro = new JButton("Imprimir livro");
		btnImprimirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimirLivro.setBounds(273, 371, 195, 45);
		frame.getContentPane().add(btnImprimirLivro);
		
		
		JButton btnAcessaReceitas = new JButton("Acessar receitas");
		btnAcessaReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcessaReceitas.setBounds(508, 371, 195, 45);
		frame.getContentPane().add(btnAcessaReceitas);
	}
}
