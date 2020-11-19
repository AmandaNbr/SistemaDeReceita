package model;
import java.util.ArrayList;
import java.util.Arrays;

import utils.DataUtils;

public class Empresa {

	protected static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	protected static ArrayList<LivroDeReceita> livrosDeReceita = new ArrayList<>(); 
	protected static ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	protected static ArrayList<Receita> receitas = new ArrayList<>(); 
	protected static ArrayList<Degustacao> degustacoes = new ArrayList<>();
	
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
			receitas = new ArrayList<>();
			receitas.add(receita);
		} else {
			receitas.add(receita);
		}
	}
	
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
	
	protected static ArrayList<Degustacao> getDegustacoes() {
		return degustacoes;
	}
	
	// dados 
	public static void popularDadosParaTestar () {
		Ingrediente ingrediente1 = new Ingrediente();
		ingrediente1.setNome("Ovo");
		ingrediente1.setDescricao("Médio");
		ingrediente1.setDataDeFabricacao(DataUtils.converteData("01/01/2000"));
		ingrediente1.setDataDeValidade(DataUtils.converteData("01/01/2021"));
		ingredientes.add(ingrediente1);
		Ingrediente ingrediente2 = new Ingrediente();
		ingrediente2.setNome("Sal");
		ingrediente2.setDescricao("Do mar.");
		ingrediente2.setDataDeFabricacao(DataUtils.converteData("01/01/2000"));
		ingrediente2.setDataDeValidade(DataUtils.converteData("01/01/2021"));
		ingredientes.add(ingrediente2);
		Ingrediente ingrediente3 = new Ingrediente();
		ingrediente3.setNome("Manteiga");
		ingrediente3.setDescricao("Extraído da banha do porco na fazenda do Sr. Raimundo.");
		ingrediente3.setDataDeFabricacao(DataUtils.converteData("01/01/2000"));
		ingrediente3.setDataDeValidade(DataUtils.converteData("01/01/2021"));
		ingredientes.add(ingrediente3);
		
		Cozinheiro cozinheiro1 = new Cozinheiro();
		cozinheiro1.setNome("Chef Robson Arnaldo da Silva Matos");
		cozinheiro1.setRg("3.456.889");
		cozinheiro1.setMatricula("1aB");
		cozinheiro1.setSalario(2300.00);
		cozinheiro1.setSexo('M');
		cozinheiro1.setDataDeIngresso(DataUtils.converteData("01/01/2019"));
		cozinheiro1.setRestaurantesTrab(new ArrayList<String>(Arrays.asList("Rattatoule", "Restaurante da Esquina", "Hamburgueria Carne Boa")));
		funcionarios.add(cozinheiro1);
		
		Receita receita1 = new Receita();
		receita1.setNome("Bolo de cake");
		receita1.setCodigo("12345");
		receita1.setDataDeCriacao(DataUtils.converteData("01/12/2019"));
		receita1.setPorcoesQueRende(2);
		receita1.setCategoria(ReceitaCategorias.SOBREMESAS);
		receita1.setIngredientesDaReceita(new ArrayList<IngredienteDaReceita>(Arrays.asList(
										  new IngredienteDaReceita(ingrediente1, 2.0, ""), 
				                          new IngredienteDaReceita(ingrediente2, 1.0, "pitada"))));
		receita1.setMatriculaCozinheiro(cozinheiro1.getMatricula());
		receita1.setModoDePreparo("Nao sei nao enche o saco >:(");
		receitas.add(receita1);
		
		Receita receita2 = new Receita();
		receita2.setNome("Churrasco");
		receita2.setCodigo("54321");
		receita2.setDataDeCriacao(DataUtils.converteData("01/01/2019"));
		receita2.setPorcoesQueRende(10);
		receita2.setCategoria(ReceitaCategorias.CARNES);
		receita2.setIngredientesDaReceita(new ArrayList<IngredienteDaReceita>(Arrays.asList(
										  new IngredienteDaReceita(ingrediente1, 2.0, ""), 
				                          new IngredienteDaReceita(ingrediente2, 1.0, "pitada"))));
		receita2.setMatriculaCozinheiro(cozinheiro1.getMatricula());
		receita2.setModoDePreparo("Primeiro coloca na agua dps ferve e faz bolo");
		receitas.add(receita2);
		
		Degustador degustador1 = new Degustador();
		degustador1.setNome("Cleber Matos Matusalem");
		degustador1.setRg("3.456.000");
		degustador1.setMatricula("1aBc");
		degustador1.setSalario(2300.00);
		degustador1.setSexo('M');
		degustador1.setDataDeIngresso(DataUtils.converteData("01/01/2015"));
		funcionarios.add(degustador1);
		
		Editor editor1 = new Editor();
		editor1.setNome("Clemencia Fofinha Nunes");
		editor1.setRg("4.666.000");
		editor1.setMatricula("1a2b");
		editor1.setSalario(2300.00);
		editor1.setSexo('F');
		editor1.setDataDeIngresso(DataUtils.converteData("01/01/2015"));
		funcionarios.add(editor1);
		
		LivroDeReceita livroDeReceita1 = new LivroDeReceita();
		livroDeReceita1.setTitulo("O livro mais melhor");
		livroDeReceita1.setIsbn("002-00-00-00200-2");
		livroDeReceita1.setCodigosReceitas(new ArrayList<String>(Arrays.asList(
																 receita1.getCodigo(), 
																 receita2.getCodigo())));
		livrosDeReceita.add(livroDeReceita1);
	}
}
