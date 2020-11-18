package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.DegustadorController;
import model.Degustador;
import model.Funcionario;
import model.TipoFuncionario;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaDegustacao extends JFrame {

	private DegustadorController degustadorController = new DegustadorController();
	private JButton btnCadastraDegustador;
	private JPanel contentPane;
	private JFormattedTextField formattedTextFieldNota;
	private JFormattedTextField formattedTextFieldData;
	private JLabel lblDegustador;
	private JLabel lblReceita;
	private JButton btnVoltar;
	private JButton btnRealizaDegustacao;
	private JLabel lblNota;
	private JLabel lblData;
	private JComboBox<String> comboBoxReceita;
	private JComboBox<Degustador> comboBoxDegustador;
	private boolean isDegustacaoObrigatoria = false;
	private Degustador currentDegustador;
	
	public TelaDegustacao() {
		criarTela();
	}
	
	public void degustacaoObrigatoria(String nome,
            			  String matricula,
                          String rg,
                          char sexo,
                          String dataDeIngresso,
                          String salario) {
		this.isDegustacaoObrigatoria = true;
		btnCadastraDegustador.setEnabled(false);
		comboBoxDegustador.removeAllItems();
		currentDegustador = degustadorController.montarDegustador(nome, matricula, rg, sexo, dataDeIngresso, salario);
		comboBoxDegustador.addItem(currentDegustador);

		lblReceita.setVisible(true);
		comboBoxReceita.setVisible(true);		
		lblNota.setVisible(true);		
		formattedTextFieldNota.setVisible(true);		
		lblData.setVisible(true);		
		formattedTextFieldData.setVisible(true);	
		btnRealizaDegustacao.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public void startTelaDegustacao() {
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
		setTitle("Degustacao");
		contentPane.setLayout(null);
		
		initializeButtons();
		
		campoDegustador();
		
		campoReceita();
		
		campoNota();
		
		campoData();
		
		mostrarCampos();
	}
	
	private void mostrarCampos() {
		if (degustadorController.validarDegustadorVazio()) {
			lblReceita.setVisible(false);
			comboBoxReceita.setVisible(false);		
			lblNota.setVisible(false);		
			formattedTextFieldNota.setVisible(false);		
			lblData.setVisible(false);		
			formattedTextFieldData.setVisible(false);	
			btnRealizaDegustacao.setVisible(false);
		} else {
			lblReceita.setVisible(true);
			comboBoxReceita.setVisible(true);		
			lblNota.setVisible(true);		
			formattedTextFieldNota.setVisible(true);		
			lblData.setVisible(true);		
			formattedTextFieldData.setVisible(true);	
			btnRealizaDegustacao.setVisible(true);
		}
	}
	
	private void initializeButtons(){		
		btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastraFuncionario cadastraFuncionario = new CadastraFuncionario(TipoFuncionario.DEGUSTADOR.getTipo());
				cadastraFuncionario.startCadastraFuncionario();
			}
		});
		btnCadastraDegustador.setBounds(273, 36, 193, 45);
		contentPane.add(btnCadastraDegustador);
		btnCadastraDegustador.setFocusable(false);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.frame.setLocationRelativeTo(null);
				menuInicial.frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(53, 302, 183, 45);
		contentPane.add(btnVoltar);
		
		btnRealizaDegustacao = new JButton("Finalizar degustacao");
		btnRealizaDegustacao.setVisible(false);
		btnRealizaDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO:VALIDACAO DOS CAMPOS
				dispose();
				if (isDegustacaoObrigatoria) {
					// CADASTRAR A DEGUSTACAO
					
					degustadorController.cadastraDegustadorMontado(currentDegustador);
					isDegustacaoObrigatoria = false;
					JOptionPane.showMessageDialog(null, "  Degustador e Degustacao cadastrados com sucesso!  ");
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				} else {
					// CADASTRAR A DEGUSTACAO
					JOptionPane.showMessageDialog(null, "  Degustacao cadastrada com sucesso!  ");
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				}
			}
		});
		btnRealizaDegustacao.setBounds(283, 302, 183, 45);
		contentPane.add(btnRealizaDegustacao);
	}
	
	private void campoDegustador() {
		comboBoxDegustador = new JComboBox<Degustador>();
		comboBoxDegustador.setBounds(64, 57, 139, 24);
		contentPane.add(comboBoxDegustador);

		for (Funcionario degustador : degustadorController.getAllDegustadores()) {
			comboBoxDegustador.addItem(((Degustador) degustador));
		}
		
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
		lblReceita.setVisible(false);
		
		comboBoxReceita = new JComboBox<String>();
		comboBoxReceita.setBounds(64, 158, 139, 24);
		contentPane.add(comboBoxReceita);
		comboBoxReceita.setVisible(false);		
	}
	
	private void campoNota() {
		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNota.setBounds(297, 137, 70, 15);
		contentPane.add(lblNota);
		lblNota.setVisible(false);		
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		formatter.setMaximum(10);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);	
		
		formattedTextFieldNota = new JFormattedTextField(formatter);
		formattedTextFieldNota.setBounds(297, 157, 64, 27);
		contentPane.add(formattedTextFieldNota);
		formattedTextFieldNota.setToolTipText("Selecione o numero para modifica-lo.");
		formattedTextFieldNota.setColumns(10);
		formattedTextFieldNota.setVisible(false);
	}
	
	private void campoData() {
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 15));
		lblData.setBounds(64, 226, 70, 15);
		contentPane.add(lblData);
		lblData.setVisible(false);		

		try {
			formattedTextFieldData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldData.setBounds(64, 248, 139, 24);
			contentPane.add(formattedTextFieldData);
			formattedTextFieldData.setValue("00/00/0000");
			formattedTextFieldData.setVisible(false);		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
