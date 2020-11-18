package controller;

import java.util.ArrayList;

import model.Ingrediente;
import model.Receita;
import utils.DataUtils;

public class ReceitaController {

	private Receita receitaModel = new Receita();
	
	public ReceitaController() {}
	
	public boolean validarNomeVazio(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	// TODO: validar se o chef cadastrou receita com o mesmo nome
	
	public boolean validarCodigoVazio(String codigo) {
		if (!codigo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarCodigoRepetido(String codigo) {		
		for (Receita receitaAtual : receitaModel.getAllReceitas()) {
			if(receitaAtual.getCodigo().equals(codigo.trim())) {
				return false;
			}	
		}
		
		return true;
	}
	
	public boolean validarModoDePreparoVazio(String modoDePreparo) {
		if (!modoDePreparo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void CadastraReceita(String nome,
			                    String codigo,
			                    String dataDeCriacao,
			                    int porcoesQueRende,
			                    String categoria,
			                    ArrayList<String> ingredienteDaReceita,
			                    String matriculaCozinheiro) {
//		Receita receita = new Receita(nome,
//									  codigo,
//									  DataUtils.converteData(dataDeCriacao),
//									  porcoesQueRende,
//									  categoria,
//									  ingredienteDaReceita,
//									  matriculaCozinheiro);
		
//		receitaModel.cadastraReceita(receita);
	}
}
