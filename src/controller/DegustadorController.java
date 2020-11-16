package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Cozinheiro;
import model.Degustador;
import model.Empresa;
import model.Funcionario;

public class DegustadorController {
	
	Degustador degustadorModel = new Degustador();
	
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
	
	public void cadastraDegustadorMontado(Degustador degustador) {
		degustadorModel.cadastrarDegustador(degustador);
	}	
	
	public Degustador montarDegustador(String nome,
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
		
		return degustador;
	}
	
	public boolean validarDegustadorVazio() {
		if(degustadorModel.getAllDegustadores().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Funcionario> getAllDegustadores() {
		return degustadorModel.getAllDegustadores();
	}
}
