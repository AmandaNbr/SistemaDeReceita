package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class CadastraReceita extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarReceita = new JButton("Cadastrar receita");
		btnCadastrarReceita.setBounds(265, 387, 198, 45);
		contentPane.add(btnCadastrarReceita);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(24, 387, 198, 45);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(43, 24, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(40, 44, 114, 24);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(265, 24, 70, 15);
		contentPane.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(265, 44, 114, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCozinheiro = new JLabel("Cozinheiro");
		lblCozinheiro.setBounds(43, 99, 111, 15);
		contentPane.add(lblCozinheiro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 126, 135, 24);
		contentPane.add(comboBox);
		
		JLabel lblDataDeCriacao = new JLabel("Data de criacao");
		lblDataDeCriacao.setBounds(265, 99, 114, 15);
		contentPane.add(lblDataDeCriacao);
		
		textField_1 = new JTextField();
		textField_1.setBounds(265, 127, 114, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPorcoesQueRende = new JLabel("Porcoes que rende");
		lblPorcoesQueRende.setBounds(43, 182, 152, 15);
		contentPane.add(lblPorcoesQueRende);
		
		textField_2 = new JTextField();
		textField_2.setBounds(43, 204, 60, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Add ingrediente");
		btnNewButton.setBounds(254, 182, 179, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Modo de preparo");
		lblNewLabel.setBounds(43, 253, 142, 15);
		contentPane.add(lblNewLabel);
		
		//buttons
	}
}
