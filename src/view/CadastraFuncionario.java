package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import model.TipoFuncionario;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;

public class CadastraFuncionario extends JFrame {
	
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
	private JCheckBox chckbxTtuloDechef;
	private JTextField textFieldRestaurantesTrabalhados;
	private JButton btnVoltar;
	private JLabel lblnomeDosRestaurantes;
	
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
				//System.out.println(formattedTextFieldSalario.getText());
				//System.out.println(formattedTextFieldSalario.getText().replace(".", "").replace("R$ ", "").replace(",", "."));
				dispose();
				if (tipoFuncionario == TipoFuncionario.DEGUSTADOR.getTipo()) {
					TelaDegustacao telaDegustacao = new TelaDegustacao();
					telaDegustacao.startTelaDegustacao();
					telaDegustacao.setLocationRelativeTo(null);
					telaDegustacao.setVisible(true);
				} else {				
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.frame.setLocationRelativeTo(null);
					menuInicial.frame.setVisible(true);
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
					telaDegustacao.setLocationRelativeTo(null);
					telaDegustacao.setVisible(true);
				} else {				
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.frame.setLocationRelativeTo(null);
					menuInicial.frame.setVisible(true);
				}
			}
		});
		btnVoltar.setBounds(70, 385, 160, 45);
		contentPane.add(btnVoltar);
	}
	
	private void campoNome() {
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(45, 30, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(45, 57, 130, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void campoSexo() {
		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSexo.setBounds(294, 122, 70, 15);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMasculno = new JRadioButton("Masculino");
		rdbtnMasculno.setBounds(278, 150, 107, 23);
		contentPane.add(rdbtnMasculno);
		rdbtnMasculno.setSelected(true);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(394, 150, 149, 23);
		contentPane.add(rdbtnFeminino);
				
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnFeminino);
		group.add(rdbtnMasculno);
		
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
			formattedTextFieldData.setValue("01/01/2001");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
		chckbxTtuloDechef = new JCheckBox(" Título de 'Chef'");
		chckbxTtuloDechef.setFont(new Font("Dialog", Font.PLAIN, 13));
		chckbxTtuloDechef.setBounds(42, 90, 171, 23);
		contentPane.add(chckbxTtuloDechef);
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
