package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Funcionario;

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
			if(cozinheiroAtual.getMatricula().equals(matricula.trim())) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(degustadorAtual.getMatricula().equals(matricula.trim())) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(editorAtual.getMatricula().equals(matricula.trim())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validarRG(String rg) {
		for (Funcionario cozinheiroAtual : cozinheiroModel.getAllCozinheiros()) {
			if(cozinheiroAtual.getRg().equals(rg)) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(degustadorAtual.getRg().equals(rg)) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(editorAtual.getRg().equals(rg)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validarSalario(String salario) {
		String salarioFormatado = salario.replace(".", "").replace("R$ ", "").replace(",", ".");
		double salarioFinal = Double.parseDouble(salarioFormatado);
		if (salarioFinal > 1045.0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarData(String data) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataDeIngressoFormatada;
		try {
			dataDeIngressoFormatada = simpleDateFormat.parse(data);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
