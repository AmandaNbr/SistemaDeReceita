package model;
import java.util.Date;

public class Editor extends Funcionario {
		
	public Editor() {};
	
	public Editor(String nome, 
			      String matricula, 
			      String rg, 
			      char sexo, 
			      Date dataDeIngresso, 
			      double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}
	
	
}