package model;
import java.util.ArrayList;
import java.util.Date;

public class Degustador extends Funcionario{
	 
	public Degustador() {}
	
	public Degustador(String nome, String matricula, String rg, char sexo, Date dataDeIngresso, double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}

	
	public ArrayList<Funcionario> getAllDegustadores() {
		return Empresa.getFuncionariosPorCargo(Degustador.class);
	}
	
	public void cadastrarDegustador(Degustador degustador) {
		Empresa.addNovoFuncionario(degustador);		
	}
}
