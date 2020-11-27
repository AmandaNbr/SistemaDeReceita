package controller;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Funcionario;
import utils.StringUtils;

public class FuncionarioController {
	
	private Cozinheiro cozinheiroModel = new Cozinheiro();
	private Degustador degustadorModel = new Degustador();
	private Editor editorModel = new Editor();

	
	public FuncionarioController() {
	}
	
	public boolean validarNome(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarMatriculaVazia(String matricula) {
		if (!matricula.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarMatriculaRepetida(String matricula) {		
		for (Funcionario cozinheiroAtual : cozinheiroModel.getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(StringUtils.comparaStrings(degustadorAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validarRGValido(String rg) {
		if(!rg.equals("0.000.000") && !rg.equals("1.111.111") && !rg.equals("2.222.222") && 
		   !rg.equals("3.333.333") && !rg.equals("4.444.444") && !rg.equals("5.555.555") &&
		   !rg.equals("6.666.666") && !rg.equals("7.777.777") && !rg.equals("8.888.888") && 
		   !rg.equals("9.999.999")) {
			return true;
		}
		return false;
	}
	
	public boolean validarRG(String rg) {
		for (Funcionario cozinheiroAtual : cozinheiroModel.getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getRg(), rg)) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(StringUtils.comparaStrings(degustadorAtual.getRg(), rg)) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getRg(), rg)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validarSalario(String salario) {
		double salarioFinal = converterSalario(salario);
		if (salarioFinal > 1045.0) {
			return true;
		} else {
			return false;
		}
	}
	
	public double converterSalario(String salarioRecebido) {
		String salarioFormatado = salarioRecebido.replace(".", "").replace("R$ ", "").replace(",", ".");
		return Double.parseDouble(salarioFormatado);
	}
}
