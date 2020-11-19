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
			                    Cozinheiro matriculaCozinheiro,
			                    String modoDePreparo) {
		
		Receita receita = new Receita(nome.trim(),
									  codigo.trim(),
									  DataUtils.converteData(dataDeCriacao),
									  ingredienteDaReceitaController.converterPorcoesQueRende(porcoesQueRende),
									  categoria,
									  ingredientesDaReceita,
									  matriculaCozinheiro.getMatricula(),
									  modoDePreparo.trim());
		
		receitaModel.cadastraReceita(receita);
	}
	
	public Receita getReceitaPorCodigo(String codigoReceita) {
		return receitaModel.getReceitaPorCodigo(codigoReceita);
	}
	
	public String montarReceitaDoLivro(ArrayList<Receita> listaDeReceitas) {
		String receitasFormatas = "";
		
		for (Receita receitaAtual : listaDeReceitas) {
			receitasFormatas = receitasFormatas.concat(receitaAtual.getNome() + " - " + receitaAtual.getCodigo() + "\n");			
		}
		
		return receitasFormatas;
	}
	
	public ArrayList<Receita> getAllReceitas(){
		return receitaModel.getAllReceitas();
	}
	
	public boolean validarReceitaVazia() {
		if(receitaModel.getAllReceitas().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public String getReceitaFormatadaPorCodigo(String codigoReceitaAtual) {
		Receita receitaAtual = getReceitaPorCodigo(codigoReceitaAtual);
		
		String receitaFormatada = receitaAtual.getNome() +
								  " - " + 
				                  receitaAtual.getCodigo() + 
				                  "\n" + 
				                  "Rende: " +
				                  receitaAtual.getPorcoesQueRende() +
				                  " porcao(oes)\n" +
				                  "Categoria: " +
				                  receitaAtual.getCategoria() +
				                  "\n\nIngredientes:\n" +
				                  ingredienteDaReceitaController.montarListaDeIngredienteDaReceita(receitaAtual.getIngredientesDaReceita()) +
				                  "\nModo de preparo: " +
				                  receitaAtual.getModoDePreparo() +
				                  "\n\n----------------------------\n\n";
		
		return receitaFormatada;
	}
}
