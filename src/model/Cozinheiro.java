package model;
import java.time.LocalDate;
import java.util.ArrayList;

import utils.StringUtils;

/**
 * Modelo de cozinheiro, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class Cozinheiro extends Funcionario{

	private ArrayList<String> restaurantesTrab;	
	
	public Cozinheiro() {}

	public Cozinheiro(String nome, 
				      String matricula, 
				      String rg, 
				      char sexo, 
				      LocalDate dataDeIngresso, 
				      double salario,  
				      ArrayList<String> restaurantesTrab) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.restaurantesTrab = restaurantesTrab;
	}
	

	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}

	public ArrayList<String> getRestaurantesTrab() {
		return restaurantesTrab;
	}
	
	public void setRestaurantesTrab(ArrayList<String> restaurantesTrab) {
		this.restaurantesTrab = restaurantesTrab;
	}
	
	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto funcionario do tipo receita
	 * @return arraylist de cozinheiros
	 */
	public ArrayList<Funcionario> getAllCozinheiros() {
		return Empresa.getFuncionariosPorCargo(Cozinheiro.class);
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar cozinheiro
	 * @param objeto cozinheiro
	 */
	public void cadastrarCozinheiro(Cozinheiro cozinheiro) {
		Empresa.addNovoFuncionario(cozinheiro);
	}
	
	/**
	 * Pega um determinado cozinheiro pela matricula
	 * @param string da matricula do cozinheiro
	 * @return objeto cozinheiro
	 */
	public Cozinheiro getCozinheiroPorMatricula(String matriculaCozinheiro) {

		for (Funcionario cozinheiroAtual : getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matriculaCozinheiro)) {
				return (Cozinheiro) cozinheiroAtual;
			}
		}
		
		return null;
	}
}
