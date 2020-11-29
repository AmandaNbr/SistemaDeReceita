package controller;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Funcionario;
import utils.StringUtils;

/**
 * Valida os dados dos funcionarios que vem da interface do usuario (view) e cadastra (model)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class FuncionarioController {
	
	public FuncionarioController() {}

	private Cozinheiro cozinheiroModel = new Cozinheiro();
	private Degustador degustadorModel = new Degustador();
	private Editor editorModel = new Editor();
	
	/**
	 * Valida se a string nome está vazia
	 * @param string do nome do funcionario
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
	 * Valida se a string matricula está vazia
	 * @param string da matricula do funcionario 
	 * @return verdadeiro se tiver algo escrito ou falso se for uma string vazia
	 */
	public boolean validarMatriculaVazia(String matricula) {
		if (!matricula.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Valida se a matricula do funcionario é repetida
	 * @param string da matricula do funcionario
	 * @return verdadeiro se não for repetida ou falso se for
	 */
	public boolean validarMatriculaRepetida(String matricula) {		
		for (Funcionario cozinheiroAtual : cozinheiroModel.getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(StringUtils.comparaStrings(degustadorAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getMatricula(), matricula)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Valida se o rg é válido
	 * @param string do rg do funcionario
	 * @return verdadeiro se for valido ou falso se não for
	 */
	public boolean validarRGValido(String rg) {
		if(!rg.equals("0.000.000") && !rg.equals("1.111.111") && !rg.equals("2.222.222") && 
		   !rg.equals("3.333.333") && !rg.equals("4.444.444") && !rg.equals("5.555.555") &&
		   !rg.equals("6.666.666") && !rg.equals("7.777.777") && !rg.equals("8.888.888") && 
		   !rg.equals("9.999.999")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Valida se o rg do funcionario é repetida
	 * @param string do rg do funcionario
	 * @return verdadeiro se não for repetido ou falso se for
	 */
	public boolean validarRGRepetido(String rg) {
		for (Funcionario cozinheiroAtual : cozinheiroModel.getAllCozinheiros()) {
			if(StringUtils.comparaStrings(cozinheiroAtual.getRg(), rg)) {
				return false;
			}
		}
		
		for (Funcionario degustadorAtual : degustadorModel.getAllDegustadores()) {
			if(StringUtils.comparaStrings(degustadorAtual.getRg(), rg)) {
				return false;
			}
		}
		
		for (Funcionario editorAtual : editorModel.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getRg(), rg)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Valida se o valor do salario é maior que o salario mínimo
	 * @param string salario do funcionario
	 * @return verdadeiro se for maior que o salario minimo ou falso se nao for
	 */
	public boolean validarSalario(String salario) {
		double salarioFinal = converterSalario(salario);
		if (salarioFinal > 1045.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Recebe o salario da forma R$ ##,##, retira o 'R$', troca os pontos por nada (pois os numeros grandes ficam com
	 * pontos para separar as casas decimais), e troca a vírgula por ponto
	 * @param string do salario do funcionario
	 * @return double salario
	 */
	public double converterSalario(String salarioRecebido) {
		String salarioFormatado = salarioRecebido.replace(".", "").replace("R$ ", "").replace(",", ".");
		return Double.parseDouble(salarioFormatado);
	}
}
