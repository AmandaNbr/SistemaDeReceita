package controller;

import java.util.Date;
import model.Ingrediente;
import utils.DataUtils;

public class IngredienteController {
	
	private Ingrediente ingredienteModel = new Ingrediente();
	
	public IngredienteController() {}
	
	public boolean validarNome(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarNomeRepetido(String nome) {		
		for (Ingrediente ingredienteAtual : ingredienteModel.getAllIngredientes()) {
			if(ingredienteAtual.getNome().equals(nome.trim())) {
				return false;
			}	
		}
		
		return true;
	}
	
	public boolean validarDescricao(String descricao) {
		if (!descricao.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarVencimento(String dataDeValidade) {
		Date dataDeValidadeFormatada = DataUtils.converteData(dataDeValidade);

		if(dataDeValidadeFormatada.after(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarFabricacao(String dataDeFabricacao, String dataDeValidade) {
		Date dataDeFabricacaoFormatada = DataUtils.converteData(dataDeFabricacao);
		Date dataDeValidadeFormatada = DataUtils.converteData(dataDeValidade);
		
		if(dataDeFabricacaoFormatada.before(DataUtils.dataAtual()) && 
				dataDeFabricacaoFormatada.before(dataDeValidadeFormatada)) {
			return true;
		} else {
			return false;
		}
	}

	public void cadastraIngrediente(String nome,
									String descricao,
									String dataDeFabricacao,
									String dataDeValidade) {
		
		Ingrediente ingrediente = new Ingrediente(nome.trim(),
				 								  descricao.trim(),
				 								  DataUtils.converteData(dataDeFabricacao),
				 								  DataUtils.converteData(dataDeValidade));
		
		ingredienteModel.cadastraIngrediente(ingrediente);
	}
}
