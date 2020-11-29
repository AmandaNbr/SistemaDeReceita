package controller;

import java.util.ArrayList;

import model.Editor;
import model.LivroDeReceita;
import utils.StringUtils;

/**
 * Valida os dados do livro de receita que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class LivroDeReceitaController {
	
	private LivroDeReceita livroDeReceitaModel = new LivroDeReceita();
	private ReceitaController receitaController = new ReceitaController();
	
	/**
	 * Valida se o codigo isbn está vazia
	 * @param string codigo isbn do livro de receita
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarCodigoIsbnVazio(String codigoIsbn) {
		if(!codigoIsbn.equals("000-00-00-00000-0")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Valida se o codigo isbn é repetido
	 * @param string codigo isbn do livro de receita
	 * @return verdadeiro se não for repetida ou falso se for
	 */
	public boolean validarCodigoIsbnRepetido(String codigoIsbn) {		
		for (LivroDeReceita livroAtual : livroDeReceitaModel.getAllLivrosDeReceita()) {
			if(StringUtils.comparaStrings(livroAtual.getIsbn(), codigoIsbn)) {
				return false;
			}	
		}
		
		return true;
	}
	
	/**
	 * Valida se o titulo do livro está vazio
	 * @param string titulo do livro de receita
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarTituloVazio(String titulo) {
		if (!titulo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se o titulo do livro é repetido
	 * @param string titulo do livro de receita
	 * @return verdadeiro se não for repetida ou falso se for
	 */
	public boolean validarTituloRepetido(String titulo) {		
		for (LivroDeReceita livroAtual : livroDeReceitaModel.getAllLivrosDeReceita()) {
			if(StringUtils.comparaStrings(livroAtual.getTitulo(), titulo)) {
				return false;
			}	
		}
		
		return true;
	}
	
	/**
	 * Valida se ha alguma receita adicionada ao livro
	 * @param string receita do livro
	 * @return verdadeiro se tiver algo ou falso se estiver vazio
	 */
	public boolean validarReceitaDoLivroVazia(String receitaDoLivro) {
		if(!receitaDoLivro.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Cadastra livro de receita
	 * @param titulo do livro de receita
	 * @param codigo isbn do livro de receita
	 * @param codigos receitas
	 * @param editor do livro de receita
	 */
	public void cadastraLivroDeReceita(String titulo,
									   String codigoIsbn,
									   ArrayList<String> codigosReceitas,
									   Editor editor) {
		
		LivroDeReceita livroDeReceita = new LivroDeReceita(titulo.trim(), 
														   codigoIsbn.trim(), 
														   codigosReceitas,
														   editor.getMatricula().trim());
		
		livroDeReceitaModel.cadastraLivroDeReceita(livroDeReceita);
	}
	
	/**
	 * Formata a 'capa' do livro, com informacoes relevantes, para ser printada
	 * @param objeto livro de receita
	 * @return string capa do livro
	 */
	public String montarCapaDoLivroDeReceita(LivroDeReceita livroDeReceita) {
		
		String capaFormatada = "\n\n----------------------------\n\n\t" + 
		                       livroDeReceita.getTitulo() +
		                       "\n\n" +
		                       "Codigo ISBN: " +
		                       livroDeReceita.getIsbn() +
		                       "\n Editor: " +
		                       livroDeReceita.getEditorPorMatricula(livroDeReceita.getMatriculaEditor()).getNome() +
		                       "\n\n----------------------------\n\n";
			
		return capaFormatada;
	}
	
	/**
	 * Cria a string livro de receita com todas as receitas ja formatadas
	 * @param objeto livro de receita
	 * @return string livro de receita
	 */
	public String montarLivroDeReceita(LivroDeReceita livroDeReceita) {
		String livroDeReceitaFormatado = "";

		for (String codigoReceitaAtual : livroDeReceita.getCodigosReceitas()) {
			livroDeReceitaFormatado = livroDeReceitaFormatado.concat(receitaController.getReceitaFormatadaPorCodigo(codigoReceitaAtual));
		}
		
		return livroDeReceitaFormatado;
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto livro de receita
	 * @return arraylist de livros de receita
	 */
	public ArrayList<LivroDeReceita> getAllLivrosDeReceita(){
		return livroDeReceitaModel.getAllLivrosDeReceita();
	}
	
	/**
	 * Confere se a receita ja foi publicada em algum livro
	 * @param codigo da receita
	 * @return verdadeiro se a receita já foi publicada ou falso se nao foi
	 */
	public boolean checarReceitaPublicada(String codigoReceita) {
		
		for (LivroDeReceita livroDeReceita : getAllLivrosDeReceita()) {
			for (String codigoReceitaNoLivro : livroDeReceita.getCodigosReceitas()) {
				if(StringUtils.comparaStrings(codigoReceita, codigoReceitaNoLivro)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
