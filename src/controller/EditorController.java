package controller;

import model.Editor;
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
}
