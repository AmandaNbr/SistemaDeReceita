package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.CozinheiroController;
import controller.EditorController;
import controller.FuncionarioController;
import model.TipoFuncionario;
import utils.DataUtils;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class CadastraFuncionario extends JFrame {
	
	private FuncionarioController funcionarioController = new FuncionarioController();
	private EditorController editorController = new EditorController();
	private CozinheiroController cozinheiroController = new CozinheiroController();
	private String tipoFuncionario;
	private JPanel contentPane;
	private JButton btnCadastrar;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblRG;
	private JLabel lblSexo;
	private JLabel lblDataDeIngresso;
	private JLabel lblSalario;
	private JFormattedTextField formattedTextFieldRG;
	private JFormattedTextField formattedTextFieldSalario;
	private JFormattedTextField formattedTextFieldData;
	private JLabel lblRestaurantesTrabalhados;
	private JCheckBox chckbxTituloDechef;
	private JTextField textFieldRestaurantesTrabalhados;
	private JButton btnVoltar;
	private JLabel lblnomeDosRestaurantes;
	private ButtonGroup group;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	
	public CadastraFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
		criarTela();
	}
	
	/**
	 * Launch the application.
	 */
	public void startCadastraFuncionario() {
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
	public void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Cadastro de Funcionario");
		
		initializeButtons();
		
		campoNome();
		
		campoMatricula();
		
		campoRG();
		
		campoSexo();
		
		campoDataDeIngresso();
		
		campoSalario();	
		
		if (tipoFuncionario == TipoFuncionario.COZINHEIRO.getTipo()) {
			campoNomeChef();
			
			campoRestaurantes();
		}
	}

	private void initializeButtons() {
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean camposValidos = checarCampos();
				
				if (camposValidos) {
					dispose();
					if (tipoFuncionario == TipoFuncionario.DEGUSTADOR.getTipo()) {
						JOptionPane.showMessageDialog(null, "  O degustador só será cadastrado  \n  após o termino da degustacao    \n   realizada obrigatoriamente por ele!   ");
						TelaDegustacao telaDegustacao = new TelaDegustacao();
						telaDegustacao.degustacaoObrigatoria(textFieldNome.getText(),
															 textFieldMatricula.getText(),
															 formattedTextFieldRG.getText(),
															 getRbtSelecionado(),
															 formattedTextFieldData.getText(),
															 formattedTextFieldSalario.getText());
						telaDegustacao.startTelaDegustacao();
					} else if (tipoFuncionario == TipoFuncionario.EDITOR.getTipo()) {	
						editorController.cadastraEditor(textFieldNome.getText(),
								                        textFieldMatricula.getText(),
								                        formattedTextFieldRG.getText(),
								                        getRbtSelecionado(),
								                        formattedTextFieldData.getText(),
								                        formattedTextFieldSalario.getText());
						JOptionPane.showMessageDialog(null, "  Editor cadastrado com sucesso!  ");
						MenuInicial menuInicial = new MenuInicial();
						menuInicial.startApplication();
					} else if (tipoFuncionario == TipoFuncionario.COZINHEIRO.getTipo()) {	
						cozinheiroController.cadastraCozinheiro(textFieldNome.getText(),
																 textFieldMatricula.getText(),
		                                                         formattedTextFieldRG.getText(),
		                                                         getRbtSelecionado(),
		                                                         formattedTextFieldData.getText(),
		                                                         formattedTextFieldSalario.getText(),
		                                                         textFieldRestaurantesTrabalhados.getText(),
		                                                         chckbxTituloDechef.isSelected());
						JOptionPane.showMessageDialog(null, "  Cozinheiro cadastrado com sucesso!  ");
						MenuInicial menuInicial = new MenuInicial();
						menuInicial.startApplication();
					}
				} else {
						// Nada a fazer
				}
			}
		});
		btnCadastrar.setBounds(278, 385, 160, 45);
		contentPane.add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
				if (tipoFuncionario == TipoFuncionario.DEGUSTADOR.getTipo()) {
					TelaDegustacao telaDegustacao = new TelaDegustacao();
					telaDegustacao.startTelaDegustacao();
				} else {				
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				}
			}
		});
		btnVoltar.setBounds(70, 385, 160, 45);
		contentPane.add(btnVoltar);
	}
	
	private boolean checarCampos() {
		
		boolean camposValidos = funcionarioController.validarNome(textFieldNome.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um nome!  ");
			return camposValidos;
		}
		
		camposValidos = funcionarioController.validarMatriculaVazia(textFieldMatricula.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma matricula!  ");
			return camposValidos;
		}
		
		camposValidos = funcionarioController.validarMatriculaRepetida(textFieldMatricula.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Matricula já cadastrada!  ");
			return camposValidos;
		}
		
		camposValidos = funcionarioController.validarRGValido(formattedTextFieldRG.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um RG valido!  ");
			return camposValidos;
		}
		
		camposValidos = funcionarioController.validarRGRepetido(formattedTextFieldRG.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  RG já cadastrado!  ");
			return camposValidos;
		}
		
		camposValidos = DataUtils.validarData(formattedTextFieldData.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Data invalida!  ");
			return camposValidos;
		}
		
		camposValidos = funcionarioController.validarSalario(formattedTextFieldSalario.getText());
		if (!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um salario maior que o salario minimo atual!  \n  (R$ 1045.00)  ");
			return camposValidos;
		}
		

		return camposValidos;
	}
	
	private void campoNome() {
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(45, 30, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(45, 57, 130, 25);
		textFieldNome.setColumns(10);
		contentPane.add(textFieldNome);
	}
	
	private void campoMatricula() {
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMatricula.setBounds(291, 30, 107, 15);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(291, 57, 130, 25);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
	}
	
	private void campoRG() {
		lblRG = new JLabel("RG");
		lblRG.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRG.setBounds(45, 122, 70, 15);
		contentPane.add(lblRG);
		
		try {
			formattedTextFieldRG = new JFormattedTextField(new MaskFormatter("#.###.###"));
			formattedTextFieldRG.setBounds(45, 149, 130, 25);
			contentPane.add(formattedTextFieldRG);
			formattedTextFieldRG.setValue("0.000.000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void campoSexo() {
		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSexo.setBounds(294, 122, 70, 15);
		contentPane.add(lblSexo);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(278, 150, 107, 23);
		contentPane.add(rdbtnMasculino);
		rdbtnMasculino.setSelected(true);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(394, 150, 149, 23);
		contentPane.add(rdbtnFeminino);
				
		group = new ButtonGroup();
		group.add(rdbtnFeminino);
		group.add(rdbtnMasculino);
		
	}
	
	private char getRbtSelecionado() {
		if(rdbtnMasculino.isSelected()) {
			return 'M';
		} else {
			return 'F';
		}
	}
	
	private void campoDataDeIngresso() {
		lblDataDeIngresso = new JLabel("Data de Ingresso");
		lblDataDeIngresso.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDataDeIngresso.setBounds(45, 218, 158, 15);
		contentPane.add(lblDataDeIngresso);

		try {
			formattedTextFieldData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldData.setBounds(45, 245, 130, 25);
			contentPane.add(formattedTextFieldData);
			formattedTextFieldData.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void campoSalario() {
		lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSalario.setBounds(294, 218, 70, 15);
		contentPane.add(lblSalario);
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
		format.setMaximumFractionDigits(2);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(00.00);
		formatter.setMaximum(1000000.00);
		formatter.setAllowsInvalid(false);
		formattedTextFieldSalario = new JFormattedTextField(formatter);
		formattedTextFieldSalario.setValue(00.00);
		formattedTextFieldSalario.setBounds(291, 245, 130, 25);
		formattedTextFieldSalario.setToolTipText("O valor deve seguir o modelo: 00.00");
		contentPane.add(formattedTextFieldSalario);
		formattedTextFieldSalario.setColumns(10);
	}
	
	private void campoNomeChef() {
		chckbxTituloDechef = new JCheckBox(" Título de 'Chef'");
		chckbxTituloDechef.setFont(new Font("Dialog", Font.PLAIN, 13));
		chckbxTituloDechef.setBounds(42, 90, 171, 23);
		contentPane.add(chckbxTituloDechef);
	}
	
	private void campoRestaurantes() {
		lblRestaurantesTrabalhados = new JLabel("Restaurantes trabalhados (opcional)");
		lblRestaurantesTrabalhados.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRestaurantesTrabalhados.setToolTipText("");
		lblRestaurantesTrabalhados.setBounds(45, 305, 340, 15);
		contentPane.add(lblRestaurantesTrabalhados);
		
		textFieldRestaurantesTrabalhados = new JTextField();
		textFieldRestaurantesTrabalhados.setBounds(45, 332, 429, 25);
		contentPane.add(textFieldRestaurantesTrabalhados);
		textFieldRestaurantesTrabalhados.setColumns(10);
		
		lblnomeDosRestaurantes = new JLabel("*nome dos restaurantes separado por virgula");
		lblnomeDosRestaurantes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblnomeDosRestaurantes.setBounds(45, 358, 376, 15);
		contentPane.add(lblnomeDosRestaurantes);

	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}
