package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Ingrediente;
import utils.DataUtils;
import utils.StringUtils;

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
			if(StringUtils.comparaStrings(ingredienteAtual.getNome(), nome)) {
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
		LocalDate dataDeValidadeFormatada = DataUtils.converteData(dataDeValidade);

		if(dataDeValidadeFormatada.isAfter(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarFabricacao(String dataDeFabricacao, String dataDeValidade) {
		LocalDate dataDeFabricacaoFormatada = DataUtils.converteData(dataDeFabricacao);
		LocalDate dataDeValidadeFormatada = DataUtils.converteData(dataDeValidade);
		
		if(dataDeFabricacaoFormatada.isBefore(DataUtils.dataAtual()) && 
				dataDeFabricacaoFormatada.isBefore(dataDeValidadeFormatada)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarIngredienteVazio() {
		if(ingredienteModel.getAllIngredientes().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Ingrediente> getAllIngredientes(){
		return ingredienteModel.getAllIngredientes();
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
