package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AcessarReceitas extends JFrame {

	private JPanel contentPane;

	public AcessarReceitas() {
		criarTela();
	}
	
	/**
	 * Launch the application.
	 */
	public void startAcessarReceitas() {
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
		setBounds(100, 100, 450, 300);
		setTitle("Acesso a receitas");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
