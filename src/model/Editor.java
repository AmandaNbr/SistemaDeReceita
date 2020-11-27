package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Editor extends Funcionario {
		
	public Editor() {}
	
	public Editor(String nome, 
			      String matricula, 
			      String rg, 
			      char sexo, 
			      LocalDate dataDeIngresso, 
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
