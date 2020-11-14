package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Empresa;
import model.Funcionario;
import model.Ingrediente;
import model.IngredienteDaReceita;
import model.Receita;

// TODO: mudar para GUI. (:
public class Comunicacao {
	Scanner ler = new Scanner(System.in);
	
	public void start() {
		escolherOpcaoMenuPrincipal();
	}
	
	private void showMenuPrincipal() {
		System.out.println("1 - Cadastrar cozinheiro.\n"
				+ "2 - Cadastrar degustador.\n"
				+ "3 - Cadastrar editor.\n"
				+ "4 - Cadastrar ingrediente.\n"
				+ "5 - Cadastrar receita.\n"
				+ "6 - Realizar degustacao.\n"
				+ "7 - Adicionar receitas ao livro.\n"
				+ "8 - Relação das receitas publicadas.\n"
				+ "9 - Relação das receitas por chefes\n"
				+ "10 - Imprimir livro de receitas\n"
				+ "11 - Sair.\n");
	}
	
	private void escolherOpcaoMenuPrincipal() {		
		String opcao;
		
		do {
//			for(Funcionario funcionario : Empresa.getAllFuncionarios()) {
//				System.out.println(funcionario.toString());
//			}
//			for(Ingrediente ingrediente : Empresa.getIngredientes()) {
//				System.out.println(ingrediente.toString());
//			}
			System.out.println("\n\n");
			
			showMenuPrincipal();
			opcao = ler.next();
			
			switch (opcao) {
			case "1":
				if (cadastrarFuncionario("cozinheiro")) {
					System.out.println("Cozinheiro cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar cozinheiro. Tente novamente com dados validos!");
				}
				break;
			case "2":
				System.out.println("O cadastro de degustadores é feito na degustação");
				break;
			case "3":
				if (cadastrarFuncionario("editor")) {
					System.out.println("Editor cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar editor. Tente novamente com dados validos!");
				}
				break;
			case "4":
				if (cadastrarIngrediente()) {
					System.out.println("Ingrediente cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar ingrediente. Tente novamente com dados validos!");
				}
				break;
			case "5":
				if (cadastrarReceita()) {
					System.out.println("Receita cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar receita. Tente novamente com dados validos!");
				};
				break;
			case "6":
				if (cadastrarFuncionario("degustador")) {
					System.out.println("Degustador cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar degustador. Tente novamente com dados validos!");
				};
				// TODO: Implementar a degustacao
				break;
			case "7":
				// TODO: Implementar a adicao de receitas ao livro
				break;
			case "8":
				// TODO: Relação das receitas publicadas
				break;
			case "9":
				// TODO: Relação de receitas por chefes
				break;
			case "10":
				// TODO: Imprimir livro de receitas
				break;
			case "11":
				opcao = "invalid";
				break;
			default:
				System.out.println("Opção invalida. Escolha uma opção valida!");
			}
			
		} while(!opcao.equals("invalid"));
		
	}
	
	private boolean cadastrarFuncionario(String tipoFuncionario) {
		
		System.out.print("Nome: ");
		ler = new Scanner(System.in); // Repeti pois estava dando erro na hora de usar o NextLine
		String nome = ler.nextLine();
		// TODO: criar validacao do nome.
		
		System.out.print("Matricula: ");
		ler = new Scanner(System.in);
		String matricula = ler.next();
		// TODO: criar validacao da matricula.
		
		System.out.print("RG: ");
		String rg = ler.next();
		// TODO: criar validacao rg.
		
		System.out.print("Sexo: ");
		char sexo = ler.next().charAt(0);
		// TODO: criar validacao sexo.
		
		System.out.print("Data de Ingresso na Empresa (no formato dd/mm/aaaa): ");
		String dataDeIngresso = ler.next();
		Date formatedDataDeIngresso;
		try {
			formatedDataDeIngresso = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeIngresso);
		} catch (ParseException e) {
			// TODO: criar validacao data.
			return false;
		}
		
		System.out.print("Salario: ");
		double salario = ler.nextDouble();
		// TODO: criar validacao salario.
		
		if (tipoFuncionario.equals("cozinheiro")) {
			
			System.out.println("Deseja ser chamado de Chef? (s/n)");
			char r1 = ler.next().charAt(0);
			if(r1 == 's') {
				nome = "Chef " + nome;
			} else if (r1 == 'n') {
				// Nada a fazer 
			} else {
				System.out.println("erro");
				return false;
			}
			// TODO: validar respostas
			
			System.out.println("Deseja informar os restaurantes em que trabalhou? (s/n)");
			char r2 = ler.next().charAt(0);
			String restaurantes = "";
			if(r2 == 's') {
				System.out.println("Digite todos os restaurantes separados por vírgula, aperte ENTER quando finalizar: ");
				ler = new Scanner(System.in);
				restaurantes = ler.nextLine();
			} else if (r2 == 'n') {
				// Nada a fazer
			} else {
				System.out.println("erro");
				return false;
			}
		
			Cozinheiro cozinheiro = new Cozinheiro(nome,
												   matricula,
												   rg,
												   sexo,
												   formatedDataDeIngresso, 
												   salario, 
												   new ArrayList<String>(Arrays.asList(restaurantes.split(",")))
												   );
			
			Empresa.addNovoFuncionario(cozinheiro);
			
			return true;
		} else if (tipoFuncionario.equals("degustador")) {
			
			Degustador degustador = new Degustador(nome, 
												   matricula, 
												   rg, 
												   sexo, 
												   formatedDataDeIngresso, 
												   salario, 
												   1);
			
			Empresa.addNovoFuncionario(degustador);
			
			return true;
		} else if (tipoFuncionario.equals("editor")) {	
			
			Editor editor = new Editor();
			
			Empresa.addNovoFuncionario(editor);
			
			return true;
		} else {
			return false;
		}
	}
	
	private boolean cadastrarIngrediente() {
		
		System.out.print("Nome: ");
		ler = new Scanner(System.in);
		String nome = ler.nextLine();
		
		System.out.print("Data de fabricacao: ");
		ler = new Scanner(System.in);
		String dataDeFabricacao = ler.next();
		Date formatedDataDeFabricacao;
		try {
			formatedDataDeFabricacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeFabricacao);
		} catch (ParseException e) {
			// TODO: criar validacao data.
			return false;
		}
		
		System.out.print("Data de validade: ");
		String dataDeValidade = ler.next();
		Date formatedDataDeValidade;
		try {
			formatedDataDeValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeValidade);
		} catch (ParseException e) {
			// TODO: criar validacao data e data de validade.
			return false;
		}
		
		System.out.print("Descricao: ");
		ler = new Scanner(System.in);
		String descricao = ler.nextLine();
		
		Ingrediente ingrediente = new Ingrediente(nome, 
												  formatedDataDeFabricacao, 
												  formatedDataDeValidade, 
												  descricao);
		
		Empresa.addIngrediente(ingrediente);
		return true;
	}
	
	private boolean cadastrarReceita() {
		
		System.out.print("Nome: ");
		ler = new Scanner(System.in);
		String nome = ler.nextLine();
		
		System.out.print("Codigo; ");
		ler = new Scanner(System.in);
		String codigo = ler.next();
		
		System.out.print("Data de criacao: ");
		String dataDeCriacao = ler.next();
		Date formatedDataDeCriacao;
		try {
			formatedDataDeCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeCriacao);
		} catch (ParseException e) {
			// TODO: criar validacao data
			return false;
		}
		
		System.out.print("Porcoes que rende: ");
		int porcoesQueRende = ler.nextInt();
		
		System.out.print("Categoria: ");
		String categoria = ler.next();
		// TODO: implementar lista de categorias
		
		System.out.println("Ingredientes: ");
		
		char respostaNovoIngrediente; 
		ArrayList<IngredienteDaReceita> ingredientesDaReceita = new ArrayList<>();
		
		do {
			//instancia idr
			System.out.println("Nome do ingrediente: ");
			ler = new Scanner(System.in);
			String nomeIngrediente = ler.nextLine();
			
			Ingrediente ingrediente = findIngrediente(nomeIngrediente);
			
			if(ingrediente == null) {
				return false;
			}
			
			System.out.println("Quantidade: ");
			ler = new Scanner(System.in);
			double quantidadeIng = ler.nextDouble();
			
			System.out.println("Medida: (Caso não exista, aperte ENTER)");
			ler = new Scanner(System.in);
			String medidaIng = ler.nextLine();
			
			ingredientesDaReceita.add(new IngredienteDaReceita(ingrediente, 
															   quantidadeIng, 
															   medidaIng));
			
			
			System.out.println("Deseja adicionar um novo ingrediente? (s/n)");
			respostaNovoIngrediente = ler.next().charAt(0);
		} while(respostaNovoIngrediente == 's');
		
		System.out.println("Cozinheiro: ");
		System.out.println("Matricula do cozinheiro: ");
		ler = new Scanner(System.in);
		String matriculaCozinheiro = ler.nextLine();
		
		Cozinheiro cozinheiro = findCozinheiro(matriculaCozinheiro);
		
		if(cozinheiro == null) {
			return false;
		}
		
		System.out.println(cozinheiro.toString());
		
		Empresa.addReceita(new Receita(nome, 
				                       codigo, 
				                       formatedDataDeCriacao, 
				                       porcoesQueRende, 
				                       categoria, 
				                       cozinheiro.getMatricula(), 
				                       -1, 
				                       ingredientesDaReceita));
		return true;
	}
	
	private Ingrediente findIngrediente(String nomeIngrediente) {
		
		for(Ingrediente ingrediente : Empresa.getIngredientes()) {
			if (ingrediente.getNome().equals(nomeIngrediente)) {
				return ingrediente;
			}
		}
		
		return null;
	}
	
	private Cozinheiro findCozinheiro(String matriculaCozinheiro) {
		
		for(Funcionario cozinheiro : Empresa.getFuncionariosPorCargo(Cozinheiro.class)) {
			if (cozinheiro.getMatricula().equals(matriculaCozinheiro)) {
				return (Cozinheiro) cozinheiro;
			}
		}
		
		return null;
	}
	
	//menu precisa ter:
	
	//cadastrar cozinheiro, degustador, editor -> belesa
	
	//cadastrar ingredientes -> belesa
	
	//cadastrar receita 
	
	//fazer degustacao
	
	//montar livro
	
	//relação de todas as receitas 
	
	//relação chefe -> receitas q ele fez

	//printar livro
}
