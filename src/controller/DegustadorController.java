package controller;

import java.util.ArrayList;
import model.Degustador;
import model.Funcionario;
import utils.DataUtils;

public class DegustadorController {
	
	private Degustador degustadorModel = new Degustador();
	private FuncionarioController funcionarioController = new FuncionarioController();
	
	
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
	
		Degustador degustador = new Degustador(nome.trim(), 
					           matricula.trim(), 
					           rg, 
					           sexo, 
					           DataUtils.converteData(dataDeIngresso),
					           funcionarioController.converterSalario(salario));
		
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
