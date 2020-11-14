package model;
import java.util.ArrayList;

public class Empresa {

	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static ArrayList<LivroDeReceita> livrosDeReceita = new ArrayList<>(); 
	private static ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	private static ArrayList<Receita> receitas = new ArrayList<>(); 
	
	
	
	public static void addNovoFuncionario(Funcionario funcionario) {
		if(funcionarios == null) {
			funcionarios = new ArrayList<>();
			funcionarios.add(funcionario);
		} else {
			funcionarios.add(funcionario);
		}
	}
	
	public static void addNovoLivroDeReceita(LivroDeReceita livroDeReceita) {
		if(livrosDeReceita == null) {
			livrosDeReceita = new ArrayList<>();
			livrosDeReceita.add(livroDeReceita);
		} else {
			livrosDeReceita.add(livroDeReceita);
		}
	}

	public static void addIngrediente(Ingrediente ingrediente) {
		if(ingredientes == null) {
			ingredientes = new ArrayList<>();
			ingredientes.add(ingrediente);
		} else {
			ingredientes.add(ingrediente);
		}
	}
	
	public static void addReceita(Receita receita) {
		if(receitas == null) {
			receitas= new ArrayList<>();
			receitas.add(receita);
		} else {
			receitas.add(receita);
		}
	}
	
	public static ArrayList<Funcionario> getAllFuncionarios() {
		return funcionarios;
	}

	public static ArrayList<LivroDeReceita> getLivrosDeReceita() {
		return livrosDeReceita;
	}
	
	public static ArrayList<Funcionario> getFuncionariosPorCargo(Object cargoClass) {
		ArrayList<Funcionario> funcionariosPorCargo = new ArrayList<>();
		
		for(Funcionario funcionario : funcionarios) {
			if (funcionario.getClass().equals(cargoClass)) {
				funcionariosPorCargo.add(funcionario);
			}
		}
		
		return funcionariosPorCargo;
	}
	
	public static ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public static ArrayList<Receita> getReceitas() {
		return receitas;
	}
}
