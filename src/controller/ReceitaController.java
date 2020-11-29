package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Cozinheiro;
import model.Degustacao;
import model.IngredienteDaReceita;
import model.Receita;
import model.ReceitaCategorias;
import utils.DataUtils;
import utils.StringUtils;

/**
 * Valida os dados da receita que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class ReceitaController {

	private DegustacaoController degustacaoController = new DegustacaoController();
	private CozinheiroController cozinheiroController = new CozinheiroController();
	private Receita receitaModel = new Receita();
	private IngredienteDaReceitaController ingredienteDaReceitaController = new IngredienteDaReceitaController();
	private ArrayList<Receita> listaDeReceitasPublicadas;
	private ArrayList<Receita> listaDeReceitasNaoPublicadas;
	
	public ReceitaController() {}
	
	public ArrayList<Receita> getListaDeReceitasPublicadas() {
		return listaDeReceitasPublicadas;
	}

	public void setListaDeReceitasPublicadas(ArrayList<Receita> listaDeReceitasPublicadas) {
		this.listaDeReceitasPublicadas = listaDeReceitasPublicadas;
	}

	public ArrayList<Receita> getListaDeReceitasNaoPublicadas() {
		return listaDeReceitasNaoPublicadas;
	}

	public void setListaDeReceitasNaoPublicadas(ArrayList<Receita> listaDeReceitasNaoPublicadas) {
		this.listaDeReceitasNaoPublicadas = listaDeReceitasNaoPublicadas;
	}
	
	/**
	 * Valida se o nome está vazio
	 * @param string do nome da receita
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarNomeVazio(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se o nome da receita é repetido
	 * @param string nome da receita
	 * @param objeto cozinheiro
	 * @return verdadeiro se não for repetida ou falso se for
	 */
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
	
	/**
	 * Valida se o codigo da receita está vazio
	 * @param string do codigo da receita
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarCodigoVazio(String codigo) {
		if (!codigo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se o codigo da receita é repetido
	 * @param string do codigo da receita
	 * @return verdadeiro se não for repetida ou falso se for
	 */
	public boolean validarCodigoRepetido(String codigo) {		
		for (Receita receitaAtual : receitaModel.getAllReceitas()) {
			if(StringUtils.comparaStrings(receitaAtual.getCodigo(), codigo)) {
				return false;
			}	
		}
		
		return true;
	}
	
	/**
	 * Valida se o modo de preparo está vazio
	 * @param string do modo de preparo da receita
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarModoDePreparoVazio(String modoDePreparo) {
		if (!modoDePreparo.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se ha algum ingrediente na receita
	 * @param string da lista de ingredientes da receita
	 * @return verdadeiro se tiver ingrediente ou falso nao tiver
	 */
	public boolean validarIngredienteVazio(String listaDeIngredientes) {
		if(!listaDeIngredientes.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se a data de criacao é antes da data atual
	 * @param data de criacao
	 * @return verdadeiro se for valida ou falso se nao for
	 */
	public boolean validarDataDeCriacao(String dataDeCriacao) {
		LocalDate dataDeCriacaoFormatada = DataUtils.converteData(dataDeCriacao);

		if(dataDeCriacaoFormatada.isBefore(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Converte de string para inteiro e troca ponto por string vazia
	 * @param string porcoes que rende
	 * @return int porcoes que rende
	 */
	public int converterPorcoesQueRende(String porcoesQueRendeRecebida) {
		return Integer.parseInt(porcoesQueRendeRecebida.replace(".", ""));
	}
	
	/**
	 * Cadastra receita
	 * @param string nome
	 * @param string codigo
	 * @param string dataDeCriacao
	 * @param string porcoesQueRende
	 * @param enum categoria
	 * @param arraylist ingredientesDaReceita
	 * @param objeto cozinheiro
	 * @param string modoDePreparo
	 */
	public void cadastraReceita(String nome,
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
									  converterPorcoesQueRende(porcoesQueRende),
									  categoria,
									  ingredientesDaReceita,
									  matriculaCozinheiro.getMatricula(),
									  modoDePreparo.trim());
		
		receitaModel.cadastraReceita(receita);
	}
	
	/**
	 * Chama um metodo da model que retorna uma instancia do objeto receita
	 * @param codigo receita
	 * @return objeto receita
	 */
	public Receita getReceitaPorCodigo(String codigoReceita) {
		return receitaModel.getReceitaPorCodigo(codigoReceita);
	}
	
	/**
	 * Cria a string receita do livro
	 * @param objeto receita
	 * @return string receita formatada
	 */
	public String montarReceitaDoLivro(ArrayList<Receita> listaDeReceitas) {
		String receitasFormatadas = "";
		
		for (Receita receitaAtual : listaDeReceitas) {
			receitasFormatadas = receitasFormatadas.concat(receitaAtual.getNome() + " - " + receitaAtual.getCodigo() + "\n");			
		}
		
		return receitasFormatadas;
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto receita
	 * @return arraylist de receitas
	 */
	public ArrayList<Receita> getAllReceitas(){
		return receitaModel.getAllReceitas();
	}
	
	/**
	 * Verifica se há alguma receita cadastrada
	 * @return verdadeiro se não houver receita cadastrada ou falso se houver
	 */
	public boolean validarReceitasVazias() {
		if(receitaModel.getAllReceitas().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cria a string receita formatada com as devidas informacoes
	 * @param string codigo da receita
	 * @return string receita formatada
	 */
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
				                  "\nInventada por: " +
				                  cozinheiroController.getCozinheiroPorMatricula(receitaAtual.getMatriculaCozinheiro()).getNome() +
				                  "\nData de criacao: " +
				                  DataUtils.formataData(receitaAtual.getDataDeCriacao()) +
				                  "\nNota: " +
				                  mediaNotas(codigoReceitaAtual) +
				                  "\n\nIngredientes:\n" +
				                  ingredienteDaReceitaController.montarListaDeIngredienteDaReceita(receitaAtual.getIngredientesDaReceita()) +
				                  "\nModo de preparo:\n" +
				                  receitaAtual.getModoDePreparo() +
				                  "\n\n----------------------------\n\n";
		
		return receitaFormatada;
	}
	
	/**
	 * Calcula a media das degustacoes
	 * @param string codigo receita
	 * @return string media notas
	 */
	public String mediaNotas(String codigoReceitaAtual) {
		ArrayList<Degustacao> listaDeDegustacoes = degustacaoController.getDegustacaoPorReceita(codigoReceitaAtual);
		
		if(listaDeDegustacoes.isEmpty()) {
			return "--";
		} else {
			return String.valueOf(listaDeDegustacoes.stream().mapToDouble(degustacaoModel -> degustacaoModel.getNota()).average().getAsDouble());
		}
		
	}
	
	/**
	 * Pega as receitas de um determinado cozinheiro
	 * @param string matricula do cozinheiro
	 * @return arraylist do objeto receita
	 */
	public ArrayList<Receita> getReceitasPorCozinheiro(String matriculaCozinheiro) {
		ArrayList<Receita> listaDeReceitasPorCozinheiro = new ArrayList<Receita>();
		
		for (Receita receitaAtual : getAllReceitas()) {
			if(StringUtils.comparaStrings(receitaAtual.getMatriculaCozinheiro(), matriculaCozinheiro)) {
				listaDeReceitasPorCozinheiro.add(receitaAtual);
			}
		}
		
		return listaDeReceitasPorCozinheiro;
	}
	
	/**
	 * Cria e preenche duas arraylists: receitas publicadas e receitas nao publicadas
	 * @param lista de receitas
	 */
	public void identificaPublicacaoDeReceitas(ArrayList<Receita> listaDeReceitasRecebida) {
		listaDeReceitasPublicadas = new ArrayList<Receita>();
		listaDeReceitasNaoPublicadas = new ArrayList<Receita>();
		LivroDeReceitaController livroDeReceitaController = new LivroDeReceitaController();
		
		for (Receita receitaAtual : listaDeReceitasRecebida) {
			if(livroDeReceitaController.checarReceitaPublicada(receitaAtual.getCodigo())) {
				listaDeReceitasPublicadas.add(receitaAtual);
			} else {
				listaDeReceitasNaoPublicadas.add(receitaAtual);
			}
		}
	}
}
