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
		LocalDate dataDeCriacaoFormatada = DataUtils.converteData(dataDeCriacao);

		if(dataDeCriacaoFormatada.isBefore(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
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
	
	public boolean validarReceitasVazias() {
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
	
	public String mediaNotas(String codigoReceitaAtual) {
		ArrayList<Degustacao> listaDeDegustacoes = degustacaoController.getDegustacaoPorReceita(codigoReceitaAtual);
		
		if(listaDeDegustacoes.isEmpty()) {
			return "--";
		} else {
			return String.valueOf(listaDeDegustacoes.stream().mapToDouble(degustacaoModel -> degustacaoModel.getNota()).average().getAsDouble());
		}
		
	}
	
	public ArrayList<Receita> getReceitasPorCozinheiro(String matriculaCozinheiro) {
		ArrayList<Receita> listaDeReceitasPorCozinheiro = new ArrayList<Receita>();
		
		for (Receita receitaAtual : getAllReceitas()) {
			if(StringUtils.comparaStrings(receitaAtual.getMatriculaCozinheiro(), matriculaCozinheiro)) {
				listaDeReceitasPorCozinheiro.add(receitaAtual);
			}
		}
		
		return listaDeReceitasPorCozinheiro;
	}
	
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
