package model;
import java.util.ArrayList;

/**
 * Funciona como um banco de dados que armazena enquanto o software está rodando
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class Empresa {

	protected static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	protected static ArrayList<LivroDeReceita> livrosDeReceita = new ArrayList<>(); 
	protected static ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	protected static ArrayList<Receita> receitas = new ArrayList<>(); 
	protected static ArrayList<Degustacao> degustacoes = new ArrayList<>();
	
	/**
	 * Cria uma arraylist se ainda não existir e cadastra funcionario nessa lista
	 * @param objeto funcionario
	 */
	protected static void addNovoFuncionario(Funcionario funcionario) {
		if(funcionarios == null) {
			funcionarios = new ArrayList<>();
			funcionarios.add(funcionario);
		} else {
			funcionarios.add(funcionario);
		}
	}
	
	/**
	 * Cria uma arraylist se ainda não existir e cadastra livro de receita
	 * @param objeto livro de receita
	 */
	protected static void addNovoLivroDeReceita(LivroDeReceita livroDeReceita) {
		if(livrosDeReceita == null) {
			livrosDeReceita = new ArrayList<>();
			livrosDeReceita.add(livroDeReceita);
		} else {
			livrosDeReceita.add(livroDeReceita);
		}
	}

	/**
	 * Cria uma arraylist se ainda não existir e cadastra ingrediente
	 * @param objeto ingrediente
	 */
	protected static void addIngrediente(Ingrediente ingrediente) {
		if(ingredientes == null) {
			ingredientes = new ArrayList<>();
			ingredientes.add(ingrediente);
		} else {
			ingredientes.add(ingrediente);
		}
	}
	
	/**
	 * Cria uma arraylist se ainda não existir e cadastra receita
	 * @param objeto receita
	 */
	protected static void addReceita(Receita receita) {
		if(receitas == null) {
			receitas = new ArrayList<>();
			receitas.add(receita);
		} else {
			receitas.add(receita);
		}
	}
	
	/**
	 * Cria uma arraylist se ainda não existir e cadastra degustacao
	 * @param objeto degustacao
	 */
	protected static void addDegustacao(Degustacao degustacao) {
		if(degustacoes == null) {
			degustacoes = new ArrayList<>();
			degustacoes.add(degustacao);
		} else {
			degustacoes.add(degustacao);
		}
	}
	
	protected static ArrayList<Funcionario> getAllFuncionarios() {
		return funcionarios;
	}
	
	protected static ArrayList<LivroDeReceita> getLivrosDeReceita() {
		return livrosDeReceita;
	}
	
	protected static ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	protected static ArrayList<Receita> getReceitas() {
		return receitas;
	}
	
	protected static ArrayList<Degustacao> getDegustacoes() {
		return degustacoes;
	}
	
	/**
	 * Pega uma arraylist de funcionarios pelo cargo (cozinheiro, degustador ou editor)
	 * @param objeto cargo
	 * @return arraylist de funcionarios de um determinado cargo
	 */
	protected static ArrayList<Funcionario> getFuncionariosPorCargo(Object cargoClass) {
		ArrayList<Funcionario> funcionariosPorCargo = new ArrayList<>();
		
		for(Funcionario funcionario : funcionarios) {
			if (funcionario.getClass().equals(cargoClass)) {
				funcionariosPorCargo.add(funcionario);
			}
		}
		
		return funcionariosPorCargo;
	}
}
