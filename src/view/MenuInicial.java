package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.TipoFuncionario;

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
		
		// COZINHEIRO
		btnCadastraCozinheiro = new JButton("Cadastrar Cozinheiro");
		btnCadastraCozinheiro.setFocusable(false);
		btnCadastraCozinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CadastraFuncionario cadastraFuncionario = new CadastraFuncionario(TipoFuncionario.COZINHEIRO.getTipo());
				cadastraFuncionario.startCadastraFuncionario();
			}
		});
		btnCadastraCozinheiro.setBounds(38, 172, 195, 45);
		frame.getContentPane().add(btnCadastraCozinheiro);
		
		// DEGUSTADOR
		btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.setFocusable(false);
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "  O cadastro de degustador é feito   \n   na degustacao  ");	
			}
		});
		btnCadastraDegustador.setBounds(273, 172, 195, 45);
		frame.getContentPane().add(btnCadastraDegustador);
		
		// EDITOR
		btnCadastraEditor = new JButton("Cadastrar Editor");
		btnCadastraEditor.setFocusable(false);
		btnCadastraEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CadastraFuncionario cadastraFuncionario = new CadastraFuncionario(TipoFuncionario.EDITOR.getTipo());
				cadastraFuncionario.startCadastraFuncionario();
			}
		});
		btnCadastraEditor.setBounds(508, 172, 195, 45);
		frame.getContentPane().add(btnCadastraEditor);
		
		// INGREDIENTE
		btnCadastraIngrediente = new JButton("Cadastrar Ingrediente");
		btnCadastraIngrediente.setFocusable(false);
		btnCadastraIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CadastraIngrediente cadastraIngrediente = new CadastraIngrediente();
				cadastraIngrediente.startCadastraIngrediente();
			}
		});
		btnCadastraIngrediente.setBounds(38, 275, 195, 45);
		frame.getContentPane().add(btnCadastraIngrediente);
		
		// RECEITA
		btnCadastraReceita = new JButton("Cadastrar Receita");
		btnCadastraReceita.setFocusable(false);
		btnCadastraReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CadastraReceita cadastraReceita = new CadastraReceita();
				cadastraReceita.startCadastraReceita();
			}
		});
		btnCadastraReceita.setBounds(273, 275, 195, 45);
		frame.getContentPane().add(btnCadastraReceita);
		
		
		btnDegustacao = new JButton("Realizar Degustacao");
		btnDegustacao.setFocusable(false);
		btnDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TelaDegustacao telaDegustacao = new TelaDegustacao();
				telaDegustacao.startTelaDegustacao();
			}
		});
		btnDegustacao.setBounds(508, 275, 195, 45);
		frame.getContentPane().add(btnDegustacao);
		
		
		btnCriarLivro = new JButton("Criar livro");
		btnCriarLivro.setFocusable(false);
		btnCriarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CriarLivro criarLivro = new CriarLivro();
				criarLivro.startCriarLivro();
			}
		});
		btnCriarLivro.setBounds(38, 371, 195, 45);
		frame.getContentPane().add(btnCriarLivro);
		
		
		btnImprimirLivro = new JButton("Imprimir livro");
		btnImprimirLivro.setFocusable(false);
		btnImprimirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ImprimirLivro imprimirLivro = new ImprimirLivro();
				imprimirLivro.startImprimirLivro();
			}
		});
		btnImprimirLivro.setBounds(273, 371, 195, 45);
		frame.getContentPane().add(btnImprimirLivro);
		
		
		btnAcessaReceitas = new JButton("Acessar receitas");
		btnAcessaReceitas.setFocusable(false);
		btnAcessaReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AcessarReceitas acessarReceitas = new AcessarReceitas();
				acessarReceitas.startAcessarReceitas();
			}
		});
		btnAcessaReceitas.setBounds(508, 371, 195, 45);
		frame.getContentPane().add(btnAcessaReceitas);
	}
}
