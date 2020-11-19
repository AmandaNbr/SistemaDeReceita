package controller;

import java.util.ArrayList;

import model.LivroDeReceita;
import utils.StringUtils;

public class LivroDeReceitaController {
	
	private LivroDeReceita livroDeReceitaModel = new LivroDeReceita();
	private ReceitaController receitaController = new ReceitaController();
	
	public boolean validarCodigoIsbnVazio(String codigoIsbn) {
		if(!codigoIsbn.equals("000-00-00-00000-0")) {
			return true;
		}
		return false;
	}
	
	public boolean validarCodigoIsbnRepetido(String codigoIsbn) {		
		for (LivroDeReceita livroAtual : livroDeReceitaModel.getAllLivrosDeReceita()) {
			if(StringUtils.comparaStrings(livroAtual.getIsbn(), codigoIsbn)) {
				return false;
			}	
		}
		
		return true;
	}
		
	public boolean validarTituloVazio(String titulo) {
		if (!titulo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarTituloRepetido(String titulo) {		
		for (LivroDeReceita livroAtual : livroDeReceitaModel.getAllLivrosDeReceita()) {
			if(StringUtils.comparaStrings(livroAtual.getTitulo(), titulo)) {
				return false;
			}	
		}
		
		return true;
	}
	
	public boolean validarReceitaDoLivroVazia(String receitaDoLivro) {
		if(!receitaDoLivro.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void cadastraLivroDeReceita(String titulo,
									   String codigoIsbn,
									   ArrayList<String> codigosReceitas) {
		
		LivroDeReceita livroDeReceita = new LivroDeReceita(titulo.trim(), 
														   codigoIsbn.trim(), 
														   codigosReceitas);
		
		livroDeReceitaModel.cadastraLivroDeReceita(livroDeReceita);
	}
	
	public String montarLivroDeReceita(LivroDeReceita livroDeReceita) {
		String livroDeReceitaFormatado = "";
		
		for (String codigoReceitaAtual : livroDeReceita.getCodigosReceitas()) {
			livroDeReceitaFormatado = livroDeReceitaFormatado.concat(receitaController.getReceitaFormatadaPorCodigo(codigoReceitaAtual));
		}
		
		return livroDeReceitaFormatado;
	}
	
	public ArrayList<LivroDeReceita> getAllLivrosDeReceita(){
		return livroDeReceitaModel.getAllLivrosDeReceita();
	}
}
