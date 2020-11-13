import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

// TODO: mudar para GUI.
public class Comunicacao {
	Scanner ler = new Scanner(System.in);
	
	public void start() {
		escolherOpcaoMenuPrincipal();
	}
	
	private void showMenuPrincipal() {
		System.out.println("1 - Cadastrar cozinheiro.\n"
				+ "2 - Cadastrar degustador.\n"
				+ "3 - Cadastrar editor.\n"
				+ "4 - Cadastrar ingredientes.\n"
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
			for(Funcionario funcionario : Empresa.getAllFuncionarios()) {
				System.out.println(funcionario.toString());
			}
			System.out.println("\n\n");
			
			showMenuPrincipal();
			opcao = ler.next();
			
			switch (opcao) {
			case "1":
				if (cadastrarCozinheiro()) {
					System.out.println("Cozinheiro cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar cozinheiro. Tente novamente com dados validos!");
				}
				break;
			case "2":
				//cadastrarDegustador();
				System.out.println("c1");
				break;
			case "3":
				//cadastrarEditor();
				System.out.println("c1");
				break;
			case "4":
				//cadastrarIngredientes();
				System.out.println("c1");
				break;
			case "5":
				//cadastrarReceita();
				System.out.println("c1");
				break;
			case "6":
				//realizarDegustacao();
				System.out.println("c1");
				break;
			case "7":
				System.out.println("c1");
				break;
			case "8":
				System.out.println("c1");
				break;
			case "9":
				System.out.println("c1");
				break;
			case "10":
				System.out.println("c10");
				break;
			case "11":
				opcao = "invalid";
				break;
			default:
				System.out.println("Opção invalida. Escolha uma opção valida!");
			}
			
		} while(!opcao.equals("invalid"));
		
	}
	
	private boolean cadastrarCozinheiro() {		
		System.out.print("Nome do cozinheiro: ");
		ler = new Scanner(System.in);
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
	}
	
	
	//menu precisa ter:
	
	//cadastrar cozinheiro, degustador, editor
	
	//cadastrar ingredientes
	
	//cadastrar receita(se tiver cozinheiro)
	
	//degustacao
	
	//montar livro
	
	//relação de todas as receitas 
	
	//relação chefe -> receitas q ele fez

	//printar livro
}
