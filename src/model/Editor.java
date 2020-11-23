package model;
import java.util.ArrayList;
import java.util.Date;

public class Editor extends Funcionario {
		
	public Editor() {}
	
	public Editor(String nome, 
			      String matricula, 
			      String rg, 
			      char sexo, 
			      Date dataDeIngresso, 
			      double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}
	
	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}

	public ArrayList<Funcionario> getAllEditores() {
		return Empresa.getFuncionariosPorCargo(Editor.class);
	}
	
	public void cadastrarEditor(Editor editor) {
		Empresa.addNovoFuncionario(editor);
	}
}
