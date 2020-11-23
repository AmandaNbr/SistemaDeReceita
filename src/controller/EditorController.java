package controller;

import java.util.ArrayList;

import model.Editor;
import model.Funcionario;
import utils.DataUtils;

public class EditorController {
	
	private Editor editorModel = new Editor();
	private FuncionarioController funcionarioController = new FuncionarioController();

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
	
	public ArrayList<Funcionario> getAllEditores() {
		return editorModel.getAllEditores();
	}
	
	public boolean validarEditorVazio() {
		if(editorModel.getAllEditores().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
