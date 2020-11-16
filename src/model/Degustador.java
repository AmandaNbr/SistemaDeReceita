package model;
import java.util.ArrayList;
import java.util.Date;

public class Degustador extends Funcionario{

	private int qntDegustacoes;	
	
	public Degustador(String nome, 
			          String matricula, 
			          String rg, 
			          char sexo, 
			          Date dataDeIngresso, 
			          double salario, 
			          int qntDegustacoes) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.qntDegustacoes = qntDegustacoes;
	}
	 
	public Degustador() {
	}

	@Override
	public String toString() {
		return "Degustador [qntDegustacoes=" + qntDegustacoes + "]";
	}

	//gets e sets
	public int getQntDegustacoes() {
		return qntDegustacoes;
	}
	
	public void setQntDegustacoes(int qntDegustacoes) {
		this.qntDegustacoes = qntDegustacoes;
	}
	
	public ArrayList<Funcionario> getAllDegustadores() {
		return Empresa.getFuncionariosPorCargo(Degustador.class);
	}
}
