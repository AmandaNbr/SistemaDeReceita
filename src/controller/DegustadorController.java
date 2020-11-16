package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Degustador;
import model.Editor;

public class DegustadorController {
	
	Degustador degustadorModel = new Degustador();
	
	public void cadastraDegustador(String nome,
                                   String matricula,
                                   String rg,
                                   char sexo,
                                   String dataDeIngresso,
                                   String salario) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataDeIngressoFormatada = new Date();
		try {
		dataDeIngressoFormatada = simpleDateFormat.parse(dataDeIngresso);
		} catch (ParseException e) {
		// Nada a fazer
		}

		String salarioFormatado = salario.replace(".", "").replace("R$ ", "").replace(",", ".");
	
		Degustador degustador = new Degustador(nome.trim(), 
					           matricula.trim(), 
					           rg, 
					           sexo, 
					           dataDeIngressoFormatada,
					           Double.parseDouble(salarioFormatado));
	
		
		degustadorModel.cadastrarDegustador(degustador);
	}
}
