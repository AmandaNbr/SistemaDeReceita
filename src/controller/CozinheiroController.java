package controller;

import java.util.ArrayList;
import model.Cozinheiro;
import model.Funcionario;
import model.Receita;
import utils.DataUtils;
import utils.StringUtils;

public class CozinheiroController {

	private Cozinheiro cozinheiroModel = new Cozinheiro();
	private FuncionarioController funcionarioController = new FuncionarioController();
	
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
	
	private ArrayList<String> formatarRestaurantes(String restaurantesRecebidos) {
		String[] restaurantesSeparados = restaurantesRecebidos.split(",");
		
		ArrayList<String> restaurantesFormatados = new ArrayList<String>();
		
		for (String restaurante : restaurantesSeparados) {
			restaurantesFormatados.add(restaurante.trim());
		}
		
		return restaurantesFormatados;
	}
	
	public boolean validarCozinheiroVazio() {
		if(cozinheiroModel.getAllCozinheiros().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Funcionario> getAllCozinheiros() {
		return cozinheiroModel.getAllCozinheiros();
	}
	
	public Cozinheiro getCozinheiroPorMatricula(String matriculaCozinheiro) {
		for (Funcionario cozinheiroAtual : getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matriculaCozinheiro)) {
				return (Cozinheiro) cozinheiroAtual;
			}
		}
		
		return null;
	}
	
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
