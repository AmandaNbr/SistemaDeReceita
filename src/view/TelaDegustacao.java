package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.DegustacaoController;
import controller.DegustadorController;
import controller.ReceitaController;
import model.Degustador;
import model.Funcionario;
import model.Receita;
import model.TipoFuncionario;
import utils.DataUtils;

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

@SuppressWarnings("serial")
public class TelaDegustacao extends JFrame {

	private DegustadorController degustadorController = new DegustadorController();
	private DegustacaoController degustacaoController = new DegustacaoController();
	private ReceitaController receitaController = new ReceitaController();
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
	private JComboBox<Receita> comboBoxReceita;
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
		if (!receitaController.validarReceitaVazia()) {			
			btnRealizaDegustacao.setEnabled(true);
		}
		comboBoxDegustador.removeAllItems();
		currentDegustador = degustadorController.montarDegustador(nome, matricula, rg, sexo, dataDeIngresso, salario);
		comboBoxDegustador.addItem(currentDegustador);
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
		setBounds(100, 100, 535, 350);
		setTitle("Degustacao");
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
		if (degustadorController.validarDegustadorVazio() || receitaController.validarReceitaVazia()) {
			btnRealizaDegustacao.setEnabled(false);
		} else {	
			btnRealizaDegustacao.setEnabled(true);
		}
	}
	
	private void initializeButtons(){		
		btnCadastraDegustador = new JButton("Cadastrar Degustador");
		btnCadastraDegustador.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastraDegustador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastraFuncionario cadastraFuncionario = new CadastraFuncionario(TipoFuncionario.DEGUSTADOR.getTipo());
				cadastraFuncionario.startCadastraFuncionario();
			}
		});
		btnCadastraDegustador.setBounds(322, 47, 183, 45);
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
		btnVoltar.setBounds(55, 248, 183, 45);
		contentPane.add(btnVoltar);
		
		btnRealizaDegustacao = new JButton("Finalizar degustacao");
		btnRealizaDegustacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean camposValidos = checarCampos();
				
				if(camposValidos) {
					dispose();
					if (isDegustacaoObrigatoria) {
						degustadorController.cadastraDegustadorMontado(currentDegustador);
						isDegustacaoObrigatoria = false;
						degustacaoController.cadastraDegustacao((Receita) comboBoxReceita.getSelectedItem(),
																formattedTextFieldNota.getText(), 
																(Degustador) comboBoxDegustador.getSelectedItem(), 
																formattedTextFieldNota.getText());
						JOptionPane.showMessageDialog(null, "  Degustador e Degustacao cadastrados com sucesso!  ");
						MenuInicial menuInicial = new MenuInicial();
						menuInicial.startApplication();
					} else {
						degustacaoController.cadastraDegustacao((Receita) comboBoxReceita.getSelectedItem(),
								formattedTextFieldNota.getText(), 
								(Degustador) comboBoxDegustador.getSelectedItem(), 
								formattedTextFieldNota.getText());
						JOptionPane.showMessageDialog(null, "  Degustacao cadastrada com sucesso!  ");
						MenuInicial menuInicial = new MenuInicial();
						menuInicial.startApplication();
					}
				}
			}
		});
		btnRealizaDegustacao.setBounds(290, 248, 183, 45);
		contentPane.add(btnRealizaDegustacao);
	}
	
	private boolean checarCampos() {
		
		boolean camposValidos = DataUtils.validarData(formattedTextFieldData.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma data valida!  ");
			return camposValidos;
		}
		
		camposValidos = degustacaoController.validarDataDegustacaoReceita(formattedTextFieldData.getText(),
																		 (Receita) comboBoxReceita.getSelectedItem());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "   A data da degustacao deve ser posterior a criacao da receita!  ");
			return camposValidos;
		}
			
		return camposValidos;
		}
	
	private void campoDegustador() {
		comboBoxDegustador = new JComboBox<Degustador>();
		comboBoxDegustador.setBounds(29, 57, 251, 24);
		contentPane.add(comboBoxDegustador);

		for (Funcionario degustador : degustadorController.getAllDegustadores()) {
			comboBoxDegustador.addItem(((Degustador) degustador));
		}
		
		lblDegustador = new JLabel("Degustador");
		lblDegustador.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDegustador.setBounds(29, 36, 128, 15);
		contentPane.add(lblDegustador);
	}

	private void campoReceita() {
		lblReceita = new JLabel("Receita");
		lblReceita.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReceita.setBounds(29, 118, 95, 15);
		contentPane.add(lblReceita);
		
		comboBoxReceita = new JComboBox<Receita>();
		comboBoxReceita.setBounds(29, 136, 251, 24);
		
		for (Receita receita : receitaController.getAllReceitas()) {
			comboBoxReceita.addItem(receita);
		}
		
		contentPane.add(comboBoxReceita);
	}
	
	private void campoNota() {
		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNota.setBounds(238, 185, 70, 15);
		contentPane.add(lblNota);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		formatter.setMaximum(10);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);	
		
		formattedTextFieldNota = new JFormattedTextField(formatter);
		formattedTextFieldNota.setBounds(229, 205, 64, 27);
		contentPane.add(formattedTextFieldNota);
		formattedTextFieldNota.setValue(0);
		formattedTextFieldNota.setToolTipText("Selecione o numero para modifica-lo.");
		formattedTextFieldNota.setColumns(10);
	}
	
	private void campoData() {
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 15));
		lblData.setBounds(322, 118, 70, 15);
		contentPane.add(lblData);

		try {
			formattedTextFieldData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldData.setBounds(322, 137, 139, 24);
			contentPane.add(formattedTextFieldData);
			formattedTextFieldData.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
