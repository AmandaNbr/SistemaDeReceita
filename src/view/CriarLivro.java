package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.EditorController;
import controller.LivroDeReceitaController;
import controller.ReceitaController;
import model.Editor;
import model.Funcionario;
import model.Receita;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

/**
 * Cria a tela de criacao de livros pegando e guardando dados nas controllers
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
@SuppressWarnings("serial")
public class CriarLivro extends JFrame {

	private EditorController editorController = new EditorController();
	private ReceitaController receitaController = new ReceitaController();
	private LivroDeReceitaController livroDeReceitaController = new LivroDeReceitaController();
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JLabel lblTituloLivro;
	private JLabel lblCodigoIsbn;
	private JLabel lblEditor;
	private JComboBox<Editor> comboBoxEditor;
	private JButton btnVoltar;
	private JButton btnCriarLivro;
	private JEditorPane editorPaneReceitasAdicionadas;
	private JButton btnAdicionarReceita;
	private JLabel lblReceitasAdicionadas;
	private JComboBox<Receita> comboBoxReceita;
	private JLabel lblReceitas;
	private JScrollPane scrollPaneReceitas;
	private JSeparator separator;
	private JFormattedTextField formattedTextFieldCodigoIsbn;
	private ArrayList<Receita> listaReceitas = new ArrayList<Receita>();

	public CriarLivro() {
		criarTela();
	}
	
	/**
	 * Cria a aplicacao
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
	 * Cria o frame
	 */
	
	private void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 585);
		setTitle("Criacao do livro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		initializeButtons();
		
		campoTitulo();

		campoCodigoIsbn();

		campoEditor();
		
		campoReceitas();
		
		campoReceitasAdicionadas();
		
		addSeparador();
		
		mostrarCampos();
	}
	
	/**
	 * Valida se ha editores ou receitas vazias, se sim coloca os botoes e alguns campos como disabled 
	 * para nao dar nullpointer
	 */
	private void mostrarCampos() {
		if(editorController.validarEditorVazio() || receitaController.validarReceitasVazias()) {
			comboBoxEditor.setEnabled(false);
			comboBoxReceita.setEnabled(false);
			btnAdicionarReceita.setEnabled(false);
			btnCriarLivro.setEnabled(false);
		}
	}

	/**
	 * Botoes e acoes dos botoes
	 */
	private void initializeButtons() {
		btnAdicionarReceita = new JButton("Adicionar receita");
		btnAdicionarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaReceitas.add((Receita) comboBoxReceita.getSelectedItem());
				comboBoxReceita.removeItem((Receita) comboBoxReceita.getSelectedItem());
				editorPaneReceitasAdicionadas.setText(receitaController.montarReceitaDoLivro(listaReceitas));
				
				if(comboBoxReceita.getItemCount() == 0) {
					btnAdicionarReceita.setEnabled(false);
					comboBoxReceita.setEnabled(false);
				}
			}
		});
		btnAdicionarReceita.setBounds(155, 231, 240, 36);
		contentPane.add(btnAdicionarReceita);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(54, 484, 195, 45);
		contentPane.add(btnVoltar);
		
		btnCriarLivro = new JButton("Criar livro");
		btnCriarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean camposValidos = checarCampos();
				
				if(camposValidos) {
					dispose();
					livroDeReceitaController.cadastraLivroDeReceita(textFieldTitulo.getText(),
																    formattedTextFieldCodigoIsbn.getText(),
																    new ArrayList<String>(listaReceitas.stream().map(Receita::getCodigo).collect(Collectors.toList())),
																    (Editor) comboBoxEditor.getSelectedItem());
					JOptionPane.showMessageDialog(null, "  Cheirinho de livro novo...  \n  Livro finalizado com sucesso!  ");
					MenuInicial menuInicial = new MenuInicial();
					menuInicial.startApplication();
				}	
			}
		});
		btnCriarLivro.setBounds(302, 484, 195, 45);
		contentPane.add(btnCriarLivro);
	}
	
	/**
	 * Verifica se cada validacao é verdadeira 
	 * @return se todas as validacoes forem validas retorna verdadeiro, se não, retorna a mensagem de erro especifica
	 */
	private boolean checarCampos() {
	
		boolean camposValidos = livroDeReceitaController.validarTituloVazio(textFieldTitulo.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um titulo!  ");
			return camposValidos;
		}
		
		camposValidos = livroDeReceitaController.validarTituloRepetido(textFieldTitulo.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Titulo repetido. O titulo deve ser unico!  ");
			return camposValidos;
		}
		
		camposValidos = livroDeReceitaController.validarCodigoIsbnVazio(formattedTextFieldCodigoIsbn.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Informe um codigo ISBN valido!  ");
			return camposValidos;
		}
		
		camposValidos = livroDeReceitaController.validarCodigoIsbnRepetido(formattedTextFieldCodigoIsbn.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Codigo ISBN repetido. O codigo deve ser unico!  ");
			return camposValidos;
		}
		
		camposValidos = livroDeReceitaController.validarReceitaDoLivroVazia(editorPaneReceitasAdicionadas.getText());
		if(!camposValidos) {
			JOptionPane.showMessageDialog(null, "  Adicione pelo menos uma receita!  ");
			return camposValidos;
		}
				
		return camposValidos;
	}
	
	/**
	 * Componentes visuais para o campo titulo
	 */
	private void campoTitulo() {
		lblTituloLivro = new JLabel("Titulo");
		lblTituloLivro.setBounds(38, 24, 70, 15);
		contentPane.add(lblTituloLivro);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(38, 42, 200, 24);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
	}
	
	/**
	 * Componentes visuais para o campo codigo isbn
	 */
	private void campoCodigoIsbn() {
		lblCodigoIsbn = new JLabel("Codigo ISBN");
		lblCodigoIsbn.setBounds(297, 24, 129, 15);
		contentPane.add(lblCodigoIsbn);
		
		try {
			formattedTextFieldCodigoIsbn = new JFormattedTextField(new MaskFormatter("###-##-##-#####-#"));
			formattedTextFieldCodigoIsbn.setBounds(297, 42, 200, 24);
			contentPane.add(formattedTextFieldCodigoIsbn);
			formattedTextFieldCodigoIsbn.setValue("000-00-00-00000-0");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Componentes visuais para o campo editor
	 */
	private void campoEditor() {
		lblEditor = new JLabel("Editor");
		lblEditor.setBounds(245, 88, 70, 15);
		contentPane.add(lblEditor);
		
		comboBoxEditor = new JComboBox<Editor>();
		comboBoxEditor.setBounds(126, 109, 300, 24);
		
		for (Funcionario editor : editorController.getAllEditores()) {
			comboBoxEditor.addItem(((Editor) editor));			
		}
		
		contentPane.add(comboBoxEditor);
	}
	
	/**
	 * Componentes visuais para o campo receitas
	 */
	private void campoReceitas() {
		lblReceitas = new JLabel("Receitas");
		lblReceitas.setBounds(240, 175, 70, 15);
		contentPane.add(lblReceitas);
		
		comboBoxReceita = new JComboBox<Receita>();
		comboBoxReceita.setBounds(126, 195, 300, 24);
		contentPane.add(comboBoxReceita);
		
		for (Receita receita : receitaController.getAllReceitas()) {
			comboBoxReceita.addItem(receita);
		}
	}
	
	/**
	 * Componentes visuais para o receitas adicionadas
	 */
	private void campoReceitasAdicionadas() {
		lblReceitasAdicionadas = new JLabel("Receitas adicionadas");
		lblReceitasAdicionadas.setBounds(200, 292, 169, 15);
		contentPane.add(lblReceitasAdicionadas);
		
		editorPaneReceitasAdicionadas = new JEditorPane();
		editorPaneReceitasAdicionadas.setEditable(false);
		scrollPaneReceitas = new JScrollPane(editorPaneReceitasAdicionadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneReceitas.setBounds(106, 319, 338, 147);
		contentPane.add(scrollPaneReceitas);
	}
	
	/**
	 * Adiciona o componente visual separador
	 */
	private void addSeparador() {
		separator = new JSeparator();
		separator.setBounds(50, 154, 450, 2);
		contentPane.add(separator);
	}
}
