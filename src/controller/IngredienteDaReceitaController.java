package controller;

import java.util.ArrayList;

import model.Ingrediente;
import model.IngredienteDaReceita;

/**
 * Valida os dados dos ingredientes da receita que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class IngredienteDaReceitaController {
	
	public IngredienteDaReceitaController() {}
	    
	/**
	 * Instancia um ingrediente da receita e retorna este ingrediente da receita
	 * @param ingrediente da receita
	 * @param quantidade do ingrediente da receita
	 * @param medida do ingrediente da receita
	 * @return objeto ingrediente da receita
	 */
	public IngredienteDaReceita montarIngredienteDaReceita(Ingrediente ingrediente,
												 String quantidade,
												 String medida) {
		
	return new IngredienteDaReceita(ingrediente,
		                            converterQuantidade(quantidade), 
		                            medida.trim());
	}
	
	/**
	 * Converte a string quantidade para double e deixa no formato certo de double
	 * @param string quantidade do ingrediente da receita
	 * @return double quantidade do ingrediente da receita
	 */
	public double converterQuantidade(String quantidadeRecebida) {
		String quantidadeFormatada = quantidadeRecebida.replace(".", "").replace(",", ".");
		return Double.parseDouble(quantidadeFormatada);
	}
	
	/**
	 * Converte os ingredientes da receita recebidos em uma string formatada dos ingredientes da receita
	 * @param arraylist de ingredientes da receita
	 * @return string de ingredientes da receita
	 */
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
}