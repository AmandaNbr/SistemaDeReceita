package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Ingrediente;
import utils.DataUtils;
import utils.StringUtils;

/**
 * Valida os dados dos ingredientes que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class IngredienteController {
	
	private Ingrediente ingredienteModel = new Ingrediente();
	
	public IngredienteController() {}
	
	/**
	 * Valida se a string nome está vazia
	 * @param string do nome do ingrediente
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarNome(String nome) {
		if (!nome.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se o nome do ingrediente é repetido
	 * @param string do nome do ingrediente
	 * @return verdadeiro se não for repetido ou falso se for
	 */
	public boolean validarNomeRepetido(String nome) {		
		for (Ingrediente ingredienteAtual : ingredienteModel.getAllIngredientes()) {
			if(StringUtils.comparaStrings(ingredienteAtual.getNome(), nome)) {
				return false;
			}	
		}
		
		return true;
	}
	
	/**
	 * Valida se a descricao está vazia
	 * @param string da descricao do ingrediente
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarDescricao(String descricao) {
		if (!descricao.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se o ingrediente está vencido
	 * @param string da data de validade
	 * @return verdadeiro se não estiver vencido ou falso se estiver
	 */
	public boolean validarVencimento(String dataDeValidade) {
		LocalDate dataDeValidadeFormatada = DataUtils.converteData(dataDeValidade);

		if(dataDeValidadeFormatada.isAfter(DataUtils.dataAtual())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se a data de fabricacao é antes da data de validade e antes da data atual.
	 * @param string da data de fabricacao
	 * @param string da data de validade
	 * @return verdadeiro se for antes da data atual e antes da data de validade ou falso se for o contrario
	 */
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
	
	/**
	 * Verifica se há algum ingrediente cadastrado
	 * @return verdadeiro se não houver ingrediente cadastrado ou falso se houver
	 */
	public boolean validarIngredienteVazio() {
		if(ingredienteModel.getAllIngredientes().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Chama um metodo da model que retorna uma arraylist do objeto ingrediente
	 * @return arraylist de ingredientes
	 */
	public ArrayList<Ingrediente> getAllIngredientes(){
		return ingredienteModel.getAllIngredientes();
	}

	/**
	 * Cadastra ingrediente
	 * @param string do nome do ingrediente
	 * @param string da descricao do ingrediente
	 * @param string da data de fabricacao do ingrediente
	 * @param string da data de validade do ingrediente
	 */
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
