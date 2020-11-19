package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CriarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 630, 500);
		setTitle("Criacao do livro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloLivro = new JLabel("Titulo");
		lblTituloLivro.setBounds(38, 24, 70, 15);
		contentPane.add(lblTituloLivro);
		
		JLabel lblCodigoIsbn = new JLabel("Codigo ISBN");
		lblCodigoIsbn.setBounds(38, 94, 129, 15);
		contentPane.add(lblCodigoIsbn);
		
		textField = new JTextField();
		textField.setBounds(38, 42, 215, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setBounds(338, 24, 70, 15);
		contentPane.add(lblEditor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(338, 42, 245, 24);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(38, 113, 184, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
