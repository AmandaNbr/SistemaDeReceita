package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Degustacao;
import model.Degustador;
import model.Receita;
import utils.DataUtils;
import utils.StringUtils;

public class DegustacaoController {
	
	public DegustacaoController() {}
	
	private Degustacao degustacaoModel = new Degustacao();
	public boolean validarDataDegustacaoReceita(String dataDegustacao, Receita receita) {
		Date dataDegustacaoFormatada = DataUtils.converteData(dataDegustacao);

		if(!dataDegustacaoFormatada.before(receita.getDataDeCriacao())) {
			return true;
		} else {
			return false;
		}
	}
	
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
	
	public ArrayList<Degustacao> getAllDegustacoes() {
		return degustacaoModel.getAllDegustacoes();
	}
	
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
