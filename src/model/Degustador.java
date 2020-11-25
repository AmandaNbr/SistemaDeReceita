package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Degustador extends Funcionario{
	 
	public Degustador() {}
	
	public Degustador(String nome, String matricula, String rg, char sexo, LocalDate dataDeIngresso, double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}

	
	public ArrayList<Funcionario> getAllDegustadores() {
		return Empresa.getFuncionariosPorCargo(Degustador.class);
	}
	
	public void cadastrarDegustador(Degustador degustador) {
		Empresa.addNovoFuncionario(degustador);		
	}

	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}
}
