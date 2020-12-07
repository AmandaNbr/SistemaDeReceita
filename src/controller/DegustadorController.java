package controller;

import java.util.ArrayList;
import model.Degustador;
import model.Funcionario;
import utils.DataUtils;

/**
 * Valida os dados do degustador que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class DegustadorController {
	
	private Degustador degustadorModel = new Degustador();
	
	private FuncionarioController funcionarioController = new FuncionarioController();
	
	/**
	 * Cadastra temporariamente o degustador até a degustacao ser realizada
	 * @param string do nome do degustador
	 * @param string do matricula do degustador
	 * @param string do rg do degustador
	 * @param char do sexo do degustador
	 * @param string do dataDeIngresso do degustador
	 * @param string do salario do degustador
	 */
	public void cadastraDegustador(String nome,
                                   String matricula,
                                   String rg,
                                   char sexo,
                                   String dataDeIngresso,
                                   String salario) {
		degustadorModel.cadastrarDegustador(montarDegustador(nome,
                											 matricula,
                											 rg,
                											 sexo,
                											 dataDeIngresso,
                											 salario));
	}
	
	/**
	 * Cadastra o degustador instanciado
	 * @param objeto degustador
	 */
	public void cadastraDegustadorMontado(Degustador degustador) {
		degustadorModel.cadastrarDegustador(degustador);
	}	
	
	/**
	 * Instancia um novo degustador e retorna este degustador
	 * @param string do nome do degustador
	 * @param string do matricula do degustador
	 * @param string do rg do degustador
	 * @param char do sexo do degustador
	 * @param string do dataDeIngresso do degustador
	 * @return objeto degustador
	 */
	public Degustador montarDegustador(String nome,
            						   String matricula,
            						   String rg,
            						   char sexo,
            						   String dataDeIngresso,
            						   String salario) {
	
		Degustador degustador = new Degustador(nome.trim(), 
					           matricula.trim(), 
					           rg, 
					           sexo, 
					           DataUtils.converteData(dataDeIngresso),
					           funcionarioController.converterSalario(salario));
		
		return degustador;
	}
	
	/**
	 * Verifica se há algum degustador cadastrado
	 * @return verdadeiro se não houver degustador cadastrado ou falso se houver
	 */
	public boolean validarDegustadorVazio() {
		if(degustadorModel.getAllDegustadores().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto funcionario do tipo degustador
	 * @return arraylist de funcionarios do tipo degustador
	 */
	public ArrayList<Funcionario> getAllDegustadores() {
		return degustadorModel.getAllDegustadores();
	}
}
