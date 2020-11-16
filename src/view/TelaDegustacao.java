package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.TipoFuncionario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDegustacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNota;
	private JTextField textFieldData;
	private JLabel lblDegustador;
	private JLabel lblReceita;
	private JButton btnVoltar;
	private JButton btnRealizaDegustacao;
	private JLabel lblNota;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public void startTelaDegustacao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDegustacao frame = new TelaDegustacao();
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
	public TelaDegustacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializeButtons();
		
		campoDegustador();
		
		campoReceita();
		
		campoNota();
		
		campoData();	
	}
	
	private void initializeButtons(){		
		JButton btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastraFuncionario cadastraFuncionario = new CadastraFuncionario(TipoFuncionario.DEGUSTADOR.getTipo());
				cadastraFuncionario.startCadastraFuncionario();
			}
		});
		btnCadastraDegustador.setBounds(273, 36, 193, 45);
		contentPane.add(btnCadastraDegustador);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(53, 302, 183, 45);
		contentPane.add(btnVoltar);
		
		btnRealizaDegustacao = new JButton("Finalizar degustacao");
		btnRealizaDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizaDegustacao.setBounds(283, 302, 183, 45);
		contentPane.add(btnRealizaDegustacao);
	}
	
	private void campoDegustador() {
		JComboBox comboBoxDegustador = new JComboBox();
		comboBoxDegustador.setBounds(64, 57, 139, 24);
		contentPane.add(comboBoxDegustador);
		
		lblDegustador = new JLabel("Degustador");
		lblDegustador.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDegustador.setBounds(65, 36, 128, 15);
		contentPane.add(lblDegustador);
	}

	private void campoReceita() {
		lblReceita = new JLabel("Receita");
		lblReceita.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReceita.setBounds(64, 137, 95, 15);
		contentPane.add(lblReceita);	
		
		JComboBox comboBoxReceita = new JComboBox();
		comboBoxReceita.setBounds(64, 158, 139, 24);
		contentPane.add(comboBoxReceita);
	}
	
	private void campoNota() {
		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNota.setBounds(297, 137, 70, 15);
		contentPane.add(lblNota);
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(297, 157, 64, 27);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
	}
	
	private void campoData() {
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 15));
		lblData.setBounds(64, 226, 70, 15);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(64, 248, 139, 24);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
	}
}
