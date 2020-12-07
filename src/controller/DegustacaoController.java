package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Degustacao;
import model.Degustador;
import model.Receita;
import utils.DataUtils;
import utils.StringUtils;

/**
 * Valida os dados da degustacao que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class DegustacaoController {
	
	public DegustacaoController() {}
	
	private Degustacao degustacaoModel = new Degustacao();
	
	/**
	 * Valida se a data da degustacao é válida em relacao a data de criacao da receita
	 * @param string da data da degustacao
	 * @param objeto receita
	 * @return verdadeiro se a data da degustacao for depois da data de criacao da receita ou falso se for antes
	 */
	public boolean validarDataDegustacaoReceita(String dataDegustacao, Receita receita) {
		LocalDate dataDegustacaoFormatada = DataUtils.converteData(dataDegustacao);

		if(!dataDegustacaoFormatada.isBefore(receita.getDataDeCriacao())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Cadastra a degustacao
	 * @param objeto receita (para pegar o codigo da receita)
	 * @param string da data de degustacao
	 * @param objeto degustador (para pegar a matricula do degustador)
	 * @param string nota 
	 */
	public void  cadastraDegustacao(Receita codigoReceita,
									String dataDegustacao,
									Degustador matriculaDegustador,
									String nota) {
		
		Degustacao degustacao = new Degustacao(codigoReceita.getCodigo(), 
				                               DataUtils.converteData(dataDegustacao), 
				                               matriculaDegustador.getMatricula(), 
				                               Integer.parseInt(nota));
		degustacaoModel.cadastraDegustacao(degustacao);
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto degustacao
	 * @return arraylist de degustacoes
	 */
	public ArrayList<Degustacao> getAllDegustacoes() {
		return degustacaoModel.getAllDegustacoes();
	}
	
	/**
	 * Percorre as degustacorre, compara o código das receitas e retorna uma arraylist das degustacoes da receita em questao
	 * @param string do codigo da receita
	 * @return arraylist de degustacao por receita
	 */
	public ArrayList<Degustacao> getDegustacaoPorReceita(String codigoReceita) {
		ArrayList<Degustacao> listaDegustacoes = new ArrayList<Degustacao>();
		
		for (Degustacao degustacao : getAllDegustacoes()) {
			if(StringUtils.comparaStrings(degustacao.getCodigoReceita(), codigoReceita)) {
				listaDegustacoes.add(degustacao);
				
			}
		}
		
		return listaDegustacoes;
	}
}
