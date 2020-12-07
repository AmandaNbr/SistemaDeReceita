package controller;

import java.util.ArrayList;
import model.Cozinheiro;
import model.Funcionario;
import model.Receita;
import utils.DataUtils;
import utils.StringUtils;

/**
 * Valida os dados do cozinheiro que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */

public class CozinheiroController {

	private Cozinheiro cozinheiroModel = new Cozinheiro();
	
	private FuncionarioController funcionarioController = new FuncionarioController();
	
	/**
	 * Cadastra cozinheiro
	 * @param string de nome do cozinheiro
	 * @param string de matricula do cozinheiro
	 * @param string de rg do cozinheiro
	 * @param char do sexo do cozinheiro 
	 * @param string de data de ingresso do cozinheiro
	 * @param string salario do cozinheiro
	 * @param string de restaurantes trabalhados
	 * @param booleano que informa se o cozinheiro deseja ser chamado de chefe
	 */
	public void cadastraCozinheiro(String nome,
							       String matricula,
							       String rg,
							       char sexo,
							       String dataDeIngresso,
							       String salario,
							       String restaurantesTrab,
							       boolean ehChefe) {

		Cozinheiro cozinheiro = new Cozinheiro(ehChefe ? "Chef " + nome.trim() : nome.trim(),
				                               matricula.trim(), 
				                               rg, 
				                               sexo, 
				                               DataUtils.converteData(dataDeIngresso),
				                               funcionarioController.converterSalario(salario), 
				                               formatarRestaurantes(restaurantesTrab));
		
		cozinheiroModel.cadastrarCozinheiro(cozinheiro);
	}
	
	/**
	 * Separa a string dos restaurantes por virgula e transforma em uma arraylist de strings,
	 * cada string é um restaurante
	 * @param string de restaurantes trabalhados
	 * @return arrayList de string dos restaurantes trabalhados
	 */
	private ArrayList<String> formatarRestaurantes(String restaurantesRecebidos) {
		String[] restaurantesSeparados = restaurantesRecebidos.split(",");
		
		ArrayList<String> restaurantesFormatados = new ArrayList<String>();
		
		for (String restaurante : restaurantesSeparados) {
			restaurantesFormatados.add(restaurante.trim());
		}
		
		return restaurantesFormatados;
	}
	
	/**
	 * Verifica se há algum cozinheiro cadastrado
	 * @return verdadeiro se não houver cozinheiro cadastrado ou falso se houver
	 */
	public boolean validarCozinheiroVazio() {
		if(cozinheiroModel.getAllCozinheiros().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto funcionario do tipo cozinheiro
	 * @return arraylist de funcionarios do tipo cozinheiro
	 */
	public ArrayList<Funcionario> getAllCozinheiros() {
		return cozinheiroModel.getAllCozinheiros();
	}
	
	/**
	 * Pega o cozinheiro pela matricula
	 * @param matricula do cozinheiro
	 * @return objeto cozinheiro da matricula dada
	 */
	public Cozinheiro getCozinheiroPorMatricula(String matriculaCozinheiro) {
		for (Funcionario cozinheiroAtual : getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matriculaCozinheiro)) {
				return (Cozinheiro) cozinheiroAtual;
			}
		}
		
		return null;
	}
	
	/**
	 * Valida se o cozinheiro recém-contratado publicou alguma receita no prazo de 45 dias 
	 * e se o cozinheiro esta cumprindo a regra de pelo menos uma receita publicada por mês.
	 * @param objeto cozinheiro
	 * @return verdadeiro se o cozinheiro está dentro do prazo ou falso se não publicou nenhuma receita no prazo
	 */
	public boolean validarInatividadeReceita(Cozinheiro cozinheiro) {
		ReceitaController receitaController = new ReceitaController();
		
		if(receitaController.getReceitasPorCozinheiro(cozinheiro.getMatricula()).isEmpty()) {
			if (cozinheiro.getDataDeIngresso().plusDays(45).isAfter(DataUtils.dataAtual())) {
				return true;
			}
		} else {			
			for (Receita receitaAtual : receitaController.getReceitasPorCozinheiro(cozinheiro.getMatricula())) {
				if (receitaAtual.getDataDeCriacao().plusDays(30).isAfter(DataUtils.dataAtual())) {
					return true;
				}
			}
		}

		return false;
	}
}
