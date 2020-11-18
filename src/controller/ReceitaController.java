package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Cozinheiro;
import model.IngredienteDaReceita;
import model.Receita;
import model.ReceitaCategorias;
import utils.DataUtils;
import utils.StringUtils;

public class ReceitaController {

	private Receita receitaModel = new Receita();
	private IngredienteDaReceitaController ingredienteDaReceitaController = new IngredienteDaReceitaController();
	public ReceitaController() {}
	
	public boolean validarNomeVazio(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarNomeRepetido(String nomeDaReceita, Cozinheiro cozinheiro) {
		
		for (Receita receitaAtual : getAllReceitas()) {
			if (StringUtils.comparaStrings(receitaAtual.getNome(), nomeDaReceita)) {
				if (StringUtils.comparaStrings(receitaAtual.getMatriculaCozinheiro(), cozinheiro.getMatricula())){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean validarCodigoVazio(String codigo) {
		if (!codigo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarCodigoRepetido(String codigo) {		
		for (Receita receitaAtual : receitaModel.getAllReceitas()) {
			if(StringUtils.comparaStrings(receitaAtual.getCodigo(), codigo)) {
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
	
	public boolean validarIngredienteVazio(String listaDeIngredientes) {
		if(!listaDeIngredientes.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarDataDeCriacao(String dataDeCriacao) {
		Date dataDeCriacaoFormatada = DataUtils.converteData(dataDeCriacao);

		if(dataDeCriacaoFormatada.before(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void CadastraReceita(String nome,
			                    String codigo,
			                    String dataDeCriacao,
			                    String porcoesQueRende,
			                    ReceitaCategorias categoria,
			                    ArrayList<IngredienteDaReceita> ingredientesDaReceita,
			                    Cozinheiro matriculaCozinheiro) {
		
		Receita receita = new Receita(nome.trim(),
									  codigo.trim(),
									  DataUtils.converteData(dataDeCriacao),
									  ingredienteDaReceitaController.converterPorcoesQueRende(porcoesQueRende),
									  categoria,
									  ingredientesDaReceita,
									  matriculaCozinheiro.getMatricula());
		
		receitaModel.cadastraReceita(receita);
	}
	
	public ArrayList<Receita> getAllReceitas(){
		return receitaModel.getAllReceitas();
	}
}
