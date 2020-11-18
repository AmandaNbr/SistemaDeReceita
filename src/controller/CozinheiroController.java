package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.Cozinheiro;
import utils.DataUtils;

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
}
