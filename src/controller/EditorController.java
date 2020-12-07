package controller;

import java.util.ArrayList;

import model.Editor;
import model.Funcionario;
import utils.DataUtils;
import utils.StringUtils;

/**
 * Valida os dados do degustador que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class EditorController {
	
	private Editor editorModel = new Editor();
	
	private FuncionarioController funcionarioController = new FuncionarioController();

	/**
	 * Cadastra editor
	 * @param string do nome do editor
	 * @param string do matricula do editor
	 * @param string do rg do editor
	 * @param char do sexo do editor
	 * @param string do dataDeIngresso do editor
	 * @param string do salario do editor
	 */
	public void cadastraEditor(String nome,
			                   String matricula,
			                   String rg,
			                   char sexo,
			                   String dataDeIngresso,
			                   String salario) {
		
		Editor editor = new Editor(nome.trim(), 
								   matricula.trim(), 
								   rg, 
								   sexo, 
								   DataUtils.converteData(dataDeIngresso),
								   funcionarioController.converterSalario(salario));
		
		editorModel.cadastrarEditor(editor);
	}
	
	/**
	 * Pega editor por matricula
	 * @param string da matricula do editor
	 * @return objeto editor
	 */
	public Editor getEditorPorMatricula(String matriculaEditor) {
		Editor editor = new Editor();
		
		for (Funcionario editorAtual : editor.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getMatricula(), matriculaEditor)) {
				return (Editor) editorAtual;
			}
		}
		
		return null;
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto funcionario do tipo editor
	 * @return arraylist de funcionarios do tipo editor
	 */
	public ArrayList<Funcionario> getAllEditores() {
		return editorModel.getAllEditores();
	}
	
	/**
	 * Verifica se há algum editor cadastrado
	 * @return verdadeiro se não houver editor cadastrado ou falso se houver
	 */
	public boolean validarEditorVazio() {
		if(editorModel.getAllEditores().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
