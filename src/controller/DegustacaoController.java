package controller;

import java.util.Date;

import model.Degustacao;
import model.Degustador;
import model.Funcionario;
import model.Receita;
import utils.DataUtils;

public class DegustacaoController {
	
	public DegustacaoController() {}
	
	private Degustacao degustacaoModel = new Degustacao();
	private Receita receitaModel = new Receita();
	
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
}
