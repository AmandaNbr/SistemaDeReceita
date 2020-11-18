package model;
import java.util.ArrayList;

public class Empresa {

	protected static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	protected static ArrayList<LivroDeReceita> livrosDeReceita = new ArrayList<>(); 
	protected static ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	protected static ArrayList<Receita> receitas = new ArrayList<>(); 
	
	protected static void addNovoFuncionario(Funcionario funcionario) {
		if(funcionarios == null) {
			funcionarios = new ArrayList<>();
			funcionarios.add(funcionario);
		} else {
			funcionarios.add(funcionario);
		}
	}
	
	protected static void addNovoLivroDeReceita(LivroDeReceita livroDeReceita) {
		if(livrosDeReceita == null) {
			livrosDeReceita = new ArrayList<>();
			livrosDeReceita.add(livroDeReceita);
		} else {
			livrosDeReceita.add(livroDeReceita);
		}
	}

	protected static void addIngrediente(Ingrediente ingrediente) {
		if(ingredientes == null) {
			ingredientes = new ArrayList<>();
			ingredientes.add(ingrediente);
		} else {
			ingredientes.add(ingrediente);
		}
	}
	
	protected static void addReceita(Receita receita) {
		if(receitas == null) {
			receitas= new ArrayList<>();
			receitas.add(receita);
		} else {
			receitas.add(receita);
		}
	}
	
	protected static ArrayList<Funcionario> getAllFuncionarios() {
		return funcionarios;
	}

	protected static ArrayList<LivroDeReceita> getLivrosDeReceita() {
		return livrosDeReceita;
	}
	
	protected static ArrayList<Funcionario> getFuncionariosPorCargo(Object cargoClass) {
		ArrayList<Funcionario> funcionariosPorCargo = new ArrayList<>();
		
		for(Funcionario funcionario : funcionarios) {
			if (funcionario.getClass().equals(cargoClass)) {
				funcionariosPorCargo.add(funcionario);
			}
		}
		
		return funcionariosPorCargo;
	}
	
	protected static ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	protected static ArrayList<Receita> getReceitas() {
		return receitas;
	}
}
