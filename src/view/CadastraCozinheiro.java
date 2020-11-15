package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastraCozinheiro extends JFrame {

	private JPanel contentPane;
	private JButton btnCadastrar;
	
	/**
	 * Launch the application.
	 */
	public void startCadastraCozinheiro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraCozinheiro frame = new CadastraCozinheiro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastraCozinheiro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Cadastro de Cozinheiro");
		
		initializeButtons();
	}
	
	private void initializeButtons() {
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.frame.setLocationRelativeTo(null);
				menuInicial.frame.setVisible(true);
			}
		});
		btnCadastrar.setBounds(176, 388, 158, 43);
		contentPane.add(btnCadastrar);
	}
}
