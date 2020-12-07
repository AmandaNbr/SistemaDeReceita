package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.CozinheiroController;
import controller.ReceitaController;
import model.Funcionario;
import model.Receita;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

/**
 * Cria a tela de acesso a receitas pegando dados da receitaController
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
@SuppressWarnings("serial")
public class AcessarReceitas extends JFrame {

	private ReceitaController receitaController = new ReceitaController();
	private CozinheiroController cozinheiroController = new CozinheiroController();
	private JPanel contentPane;
	private JLabel lblCozinheiro;
	private JComboBox<String> comboBoxCozinheiro;
	private JEditorPane editorPaneReceitasNaoPublicadas;
	private JButton btnVoltar;
	private JScrollPane scrollPaneReceitasNaoPublicadas;
	private JEditorPane editorPaneReceitasPublicadas;
	private JScrollPane scrollPaneReceitasPublicadas;
	private JLabel lblReceitasPublicadas;
	private JLabel lblReceitasNaoPublicadas;

	public AcessarReceitas() {
		criarTela();
	}
	
	/**
	 * Cria a aplicacao
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
	 * Cria o frame.
	 */
	private void criarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 430);
		setTitle("Acesso a receitas");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializeButton();

		campoMostrarReceitaNaoPublicadas();
		
		campoMostrarReceitasPublicadas();
		
		campoCozinheiro();
		
		/*
		 * Coloca certos campos como disabled para nao dar nullpointer
		 */
		if(cozinheiroController.validarCozinheiroVazio()) {
			comboBoxCozinheiro.removeAllItems();
			comboBoxCozinheiro.setEnabled(false);
		}
		
		/*
		 * Coloca certos campos como disabled para nao dar nullpointer
		 */
		if(receitaController.validarReceitasVazias()) {
			editorPaneReceitasPublicadas.setText("Não há receitas publicadas!");
			editorPaneReceitasNaoPublicadas.setText("Não há receitas não publicadas!");
		}
	}
	
	/**
	 * Botao e acoes do botao
	 */
	private void initializeButton() {
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.startApplication();
			}
		});
		btnVoltar.setBounds(307, 331, 175, 45);
		contentPane.add(btnVoltar);
	}
	
	/**
	 * Componentes visuais para o campo cozinheiro
	 */
	private void campoCozinheiro() {
		lblCozinheiro = new JLabel("Cozinheiros");
		lblCozinheiro.setBounds(338, 22, 92, 15);
		contentPane.add(lblCozinheiro);
		
		comboBoxCozinheiro = new JComboBox<String>();
		comboBoxCozinheiro.setMaximumRowCount(100);
		comboBoxCozinheiro.setBounds(169, 49, 450, 24);
		comboBoxCozinheiro.addItem("Todos");
		
		for (Funcionario cozinheiro : cozinheiroController.getAllCozinheiros()) {
			comboBoxCozinheiro.addItem(cozinheiro.toString());
		}
			
		comboBoxCozinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!receitaController.validarReceitasVazias() && !(comboBoxCozinheiro.getSelectedItem() == null))
					mostrarReceitas();
			}
		});
		
		comboBoxCozinheiro.setSelectedItem(null);
		
		contentPane.add(comboBoxCozinheiro);		
	}
	
	/**
	 * Componentes visuais para mostrar receitas
	 */
	private void mostrarReceitas() {
		if(comboBoxCozinheiro.getSelectedItem() == "Todos") {
			if(receitaController.validarReceitasVazias()) {
				editorPaneReceitasPublicadas.setText("Nao ha receitas publicadas!");
				editorPaneReceitasNaoPublicadas.setText("Nao ha receitas não publicadas!");
			} else {
				receitaController.identificaPublicacaoDeReceitas(receitaController.getAllReceitas());
				editorPaneReceitasNaoPublicadas.setText(getReceitasEmString(receitaController.getListaDeReceitasNaoPublicadas()));
				editorPaneReceitasPublicadas.setText(getReceitasEmString(receitaController.getListaDeReceitasPublicadas()));
			}
		} else {
			receitaController.identificaPublicacaoDeReceitas(receitaController.getReceitasPorCozinheiro(comboBoxCozinheiro.getSelectedItem().toString().split(" - ")[1]));
			editorPaneReceitasNaoPublicadas.setText(getReceitasEmString(receitaController.getListaDeReceitasNaoPublicadas()));
			editorPaneReceitasPublicadas.setText(getReceitasEmString(receitaController.getListaDeReceitasPublicadas()));
		}
		
		if (editorPaneReceitasNaoPublicadas.getText().isEmpty()) {
			editorPaneReceitasNaoPublicadas.setText("Nao ha receitas nao publicadas!");
		}
		
		if (editorPaneReceitasPublicadas.getText().isEmpty()) {
			editorPaneReceitasPublicadas.setText("Nao ha receitas publicadas!");
		}
	}
	
	/**
	 * Converte a arraylist de string em uma unica string
	 */
	private String getReceitasEmString(ArrayList<Receita> receitasRecebidas) {
		return receitasRecebidas.stream()
								.map(receita -> receitaController.getReceitaFormatadaPorCodigo(receita.getCodigo()))
								.collect(Collectors.joining());
	}
	
	/**
	 * Componentes visuais para mostrar receitas nao publicadas
	 */
	private void campoMostrarReceitaNaoPublicadas() {
		lblReceitasNaoPublicadas = new JLabel("Receitas nao publicadas");
		lblReceitasNaoPublicadas.setBounds(23, 100, 205, 15);
		contentPane.add(lblReceitasNaoPublicadas);
		
		editorPaneReceitasNaoPublicadas = new JEditorPane();
		editorPaneReceitasNaoPublicadas.setEditable(false);
		scrollPaneReceitasNaoPublicadas = new JScrollPane(editorPaneReceitasNaoPublicadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneReceitasNaoPublicadas.setBounds(23, 127, 350, 189);
		contentPane.add(scrollPaneReceitasNaoPublicadas);		
	}
	
	/**
	 * Componentes visuais para mostrar receitas publicadas
	 */
	private void campoMostrarReceitasPublicadas() {
		lblReceitasPublicadas = new JLabel("Receitas publicadas");
		lblReceitasPublicadas.setBounds(405, 100, 176, 15);
		contentPane.add(lblReceitasPublicadas);
		
		editorPaneReceitasPublicadas = new JEditorPane();
		editorPaneReceitasPublicadas.setEditable(false);
		scrollPaneReceitasPublicadas = new JScrollPane(editorPaneReceitasPublicadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneReceitasPublicadas.setBounds(405, 127, 350, 189);
		contentPane.add(scrollPaneReceitasPublicadas);
		}
	
}
