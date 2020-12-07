package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.IngredienteController;
import utils.DataUtils;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Cria a tela de cadastro de ingredientes pegando e guardando dados nas controllers
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
@SuppressWarnings("serial")
public class CadastraIngrediente extends JFrame {

	private IngredienteController ingredienteController = new IngredienteController();
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JButton btnVoltar;
	private JButton btnCadastrarIngrediente;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblDataDeFabricacao;
	private JLabel lblDataDeValidade;
	private JFormattedTextField formattedTextFieldDataDeFabricacao;
	private JFormattedTextField formattedTextFieldDataDeValidade;

	public CadastraIngrediente() {
		criarTela();	
	}
	
	/**
	 * Cria a aplicacao
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
	 * Cria o frame
	 */	
	private void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setTitle("Cadastro de ingrediente");
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
	
	/**
	 * Verifica se cada validacao é verdadeira 
	 * @return se todas as validacoes forem validas retorna verdadeiro, se não, retorna a mensagem de erro especifica
	 */
	private boolean checarCampos() {
		
		boolean camposValidos = ingredienteController.validarNome(textFieldNome.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um nome!  ");
			return camposValidos;
		}
		
		camposValidos = ingredienteController.validarNomeRepetido(textFieldNome.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Ingrediente já cadastrado!  ");
			return camposValidos;
		}
		
		camposValidos = ingredienteController.validarDescricao(textFieldDescricao.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma descricao!  ");
			return camposValidos;
		}
		
		camposValidos = DataUtils.validarData(formattedTextFieldDataDeFabricacao.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma data de fabricacao!  ");
			return camposValidos;
		}
		
		camposValidos = DataUtils.validarData(formattedTextFieldDataDeValidade.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe uma data de validade!  ");
			return camposValidos;
		}
		
		camposValidos = ingredienteController.validarVencimento(formattedTextFieldDataDeValidade.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Não é possivel cadastrar ingrediente vencido!  ");
			return camposValidos;
		}
		
		camposValidos = ingredienteController.validarFabricacao(formattedTextFieldDataDeFabricacao.getText(),
																formattedTextFieldDataDeValidade.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  A data de fabricacao deve ser antes da data de\n vencimento e do dia atual!  ");
			return camposValidos;
		}
				
		return camposValidos;
	}
	
	/**
	 * Botoes e acoes dos botoes
	 */
	private void inicializeButtons() {
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(30, 291, 198, 45);
		contentPane.add(btnVoltar);
		
		btnCadastrarIngrediente = new JButton("Cadastrar ingrediente");
		btnCadastrarIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean camposValidos = checarCampos();

				if(camposValidos) {
					dispose();
					ingredienteController.cadastraIngrediente(textFieldNome.getText(), 
							                                  textFieldDescricao.getText(), 
							                                  formattedTextFieldDataDeFabricacao.getText(), 
							                                  formattedTextFieldDataDeValidade.getText());
					JOptionPane.showMessageDialog(null, "  Ingrediente cadastrado com sucesso!  ");
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				}
			}
		});
		btnCadastrarIngrediente.setBounds(264, 291, 198, 45);
		contentPane.add(btnCadastrarIngrediente);
	}
	
	/**
	 * Componentes visuais para o campo nome
	 */
	private void campoNome() {
		lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 40, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(50, 77, 139, 26);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
	}
	
	/**
	 * Componentes visuais para o campo descricao
	 */
	private void campoDescricao() {
		lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(264, 40, 70, 15);
		contentPane.add(lblDescricao);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(264, 77, 181, 26);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
	}
	
	/**
	 * Componentes visuais para o campo data de fabricacao
	 */
	private void campoDataDeFabricacao() {
		lblDataDeFabricacao = new JLabel("Data de fabricacao");
		lblDataDeFabricacao.setBounds(50, 158, 160, 15);
		contentPane.add(lblDataDeFabricacao);
		
		try {
			formattedTextFieldDataDeFabricacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldDataDeFabricacao.setBounds(50, 190, 114, 26);
			contentPane.add(formattedTextFieldDataDeFabricacao);
			formattedTextFieldDataDeFabricacao.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Componentes visuais para o campo data de validade
	 */
	private void campoDataDeValidade() {
		lblDataDeValidade = new JLabel("Data de validade");
		lblDataDeValidade.setBounds(264, 158, 128, 15);
		contentPane.add(lblDataDeValidade);

		try {
			formattedTextFieldDataDeValidade = new JFormattedTextField(new MaskFormatter("##/##/####"));
			formattedTextFieldDataDeValidade.setBounds(264, 190, 114, 26);
			contentPane.add(formattedTextFieldDataDeValidade);
			formattedTextFieldDataDeValidade.setValue("00/00/0000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
