package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastraIngrediente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textField;
	private JTextField textField_1;

	public CadastraIngrediente() {
		criarTela();	
	}
	
	/**
	 * Launch the application.
	 */
	public void startCadastraIngrediente() {
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
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializeButtons();
		
		campoNome();
		
		campoDescricao();
		
		campoDataDeFabricacao();
		
		campoDataDeValidade();
	}
	
	private void inicializeButtons() {
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(30, 291, 198, 45);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrarIngrediente = new JButton("Cadastrar ingrediente");
		btnCadastrarIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: cadastrar
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnCadastrarIngrediente.setBounds(264, 291, 198, 45);
		contentPane.add(btnCadastrarIngrediente);
	}
	
	private void campoNome() {
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 40, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(50, 77, 139, 26);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
	}
	
	private void campoDescricao() {
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(264, 40, 70, 15);
		contentPane.add(lblDescricao);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(264, 77, 181, 26);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
	}
	
	private void campoDataDeFabricacao() {
		JLabel lblDataDeFabricacao = new JLabel("Data de fabricacao");
		lblDataDeFabricacao.setBounds(50, 158, 160, 15);
		contentPane.add(lblDataDeFabricacao);
		
		textField = new JTextField();
		textField.setBounds(50, 190, 114, 26);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	private void campoDataDeValidade() {
		JLabel lblDataDeValidade = new JLabel("Data de validade");
		lblDataDeValidade.setBounds(264, 158, 128, 15);
		contentPane.add(lblDataDeValidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(264, 190, 114, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
