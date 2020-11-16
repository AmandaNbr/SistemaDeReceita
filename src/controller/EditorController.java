package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Editor;

public class EditorController {
	
	private Editor editorModel = new Editor();

	public void cadastraEditor(String nome,
			                   String matricula,
			                   String rg,
			                   char sexo,
			                   String dataDeIngresso,
			                   String salario) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataDeIngressoFormatada = new Date();
		try {
			dataDeIngressoFormatada = simpleDateFormat.parse(dataDeIngresso);
		} catch (ParseException e) {
			// Nada a fazer
		}
		
		String salarioFormatado = salario.replace(".", "").replace("R$ ", "").replace(",", ".");
		
		Editor editor = new Editor(nome.trim(), 
								   matricula.trim(), 
								   rg, 
								   sexo, dataDeIngressoFormatada,
								   Double.parseDouble(salarioFormatado));
		
		editorModel.cadastrarEditor(editor);
	}
}
