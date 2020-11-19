package model;
import java.util.ArrayList;
import java.util.Date;

import utils.StringUtils;

public class Cozinheiro extends Funcionario{

	private ArrayList<String> restaurantesTrab;	
	
	public Cozinheiro() {}

	public Cozinheiro(String nome, 
				      String matricula, 
				      String rg, 
				      char sexo, 
				      Date dataDeIngresso, 
				      double salario,  
				      ArrayList<String> restaurantesTrab) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.restaurantesTrab = restaurantesTrab;
	}
	

	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}

	//gets e sets
	public ArrayList<String> getRestaurantesTrab() {
		return restaurantesTrab;
	}
	
	public void setRestaurantesTrab(ArrayList<String> restaurantesTrab) {
		this.restaurantesTrab = restaurantesTrab;
	}
	
	public ArrayList<Funcionario> getAllCozinheiros() {
		return Empresa.getFuncionariosPorCargo(Cozinheiro.class);
	}
	
	public void cadastrarCozinheiro(Cozinheiro cozinheiro) {
		Empresa.addNovoFuncionario(cozinheiro);
	}
	
	public Cozinheiro getCozinheiroPorMatricula(String matriculaCozinheiro) {

		for (Funcionario cozinheiroAtual : getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matriculaCozinheiro)) {
				return (Cozinheiro) cozinheiroAtual;
			}
		}
		
		return null;
	}
}
