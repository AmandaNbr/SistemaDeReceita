package controller;

import model.Degustacao;
import model.Degustador;
import model.Funcionario;

public class DegustacaoController {
	
	private Degustador degustadorModel = new Degustador();
	private Degustacao degustacaoModel = new Degustacao();
	
	public boolean validarDegustadorVazio() {
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(!degustadorAtual.toString().isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}	
}
