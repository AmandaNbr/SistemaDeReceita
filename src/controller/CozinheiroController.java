package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.Cozinheiro;

public class CozinheiroController {

	private Cozinheiro cozinheiroModel = new Cozinheiro();
	
	public void cadastraCozinheiro(String nome,
							       String matricula,
							       String rg,
							       char sexo,
							       String dataDeIngresso,
							       String salario,
							       String restaurantesTrab) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataDeIngressoFormatada = new Date();
		try {
			dataDeIngressoFormatada = simpleDateFormat.parse(dataDeIngresso);
		} catch (ParseException e) {
			// Nada a fazer
		}
		
		String salarioFormatado = salario.replace(".", "").replace("R$ ", "").replace(",", ".");
		

		// TODO: trim lista restaurants

		Cozinheiro cozinheiro = new Cozinheiro(nome.trim(),
				                               matricula.trim(), 
				                               rg, 
				                               sexo, 
				                               dataDeIngressoFormatada,
				                               Double.parseDouble(salarioFormatado), 
				                               new ArrayList<String>(Arrays.asList(restaurantesTrab.split(","))));
		
		cozinheiroModel.cadastrarCozinheiro(cozinheiro);
	}
}
