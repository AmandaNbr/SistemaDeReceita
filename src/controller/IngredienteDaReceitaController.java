package controller;

import java.util.ArrayList;

import model.Ingrediente;
import model.IngredienteDaReceita;

public class IngredienteDaReceitaController {
	
	public IngredienteDaReceitaController() {}
	    
	public IngredienteDaReceita montarIngredienteDaReceita(Ingrediente ingrediente,
												 String quantidade,
												 String medida) {
		
	return new IngredienteDaReceita(ingrediente,
		                            converterQuantidade(quantidade), 
		                            medida.trim());
	}
	
	public double converterQuantidade(String quantidadeRecebida) {
		String quantidadeFormatada = quantidadeRecebida.replace(".", "").replace(",", ".");
		return Double.parseDouble(quantidadeFormatada);
	}
	
	public String montarListaDeIngredienteDaReceita(ArrayList<IngredienteDaReceita> ingredientesDaReceitaRecebidos) {
		String listaFormatada = "";
		
		for (IngredienteDaReceita ingredienteDaReceita : ingredientesDaReceitaRecebidos) {
			listaFormatada = listaFormatada.concat(
					ingredienteDaReceita.getQuantidadeIng() + 
					(ingredienteDaReceita.getMedidaIng().isEmpty() ? " " : " " + ingredienteDaReceita.getMedidaIng() + " de ") + 
					ingredienteDaReceita.getIngrediente().getNome() + 
					"\n");
		}
		
		return listaFormatada;
	}

	public int converterPorcoesQueRende(String porcoesQueRendeRecebida) {
		return Integer.parseInt(porcoesQueRendeRecebida.replace(".", ""));
	}
	
}