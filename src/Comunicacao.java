import java.lang.reflect.Array;
import java.util.Date;
import java.util.Scanner;

// TODO: mudar para GUI.
public class Comunicacao {
	
	Scanner ler = new Scanner(System.in);
	String n;
	
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
		
		do {
			System.out.flush();
			showMenuPrincipal();
			n = ler.next();
			
			switch (n) {
			case "1":
				cadastrarCozinheiro();
				System.out.println("c1");
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
				n = "invalid";
				break;
			default:
				System.out.println("Opção invalida. Escolha uma opção valida!");
			}
			
		} while(!n.equals("invalid"));
		
	}
	
	private void cadastrarCozinheiro() {
		System.out.flush();
		
		System.out.print("Nome do cozinheiro: ");
		String nome = ler.next();
		// TODO: criar validacao do nome.
		
		System.out.print("Matricula: ");
		String matricula = ler.next();
		// TODO: criar validacao da matricula.
		
		System.out.print("RG: ");
		String rg = ler.next();
		// TODO: criar validacao rg.
		
		System.out.print("Sexo: ");
		char sexo = ler.next().charAt(0);
		// TODO: criar validacao sexo.
		
		System.out.print("Data de Ingresso na Empresa: ");
		String dataDeIngresso = ler.next();
		// TODO: criar validacao data.
		
		System.out.print("Salario: ");
		double salario = ler.nextDouble();
		// TODO: criar validacao salario.
		
		System.out.println("Deseja ser chamado de Chef? (s/n)");
		char r1 = ler.next().charAt(0);
		if(r1 == 's') {
			nome += "Chef";
			System.out.println("Ok, Chef " + nome);
		} else if (r1 == 'n') {
			System.out.println("(:");
		}
		// TODO: validar respostas
		
		System.out.println("Deseja informar os restaurantes em que trabalhou? (s/n)");
		char r2 = ler.next().charAt(0);
		if(r2 == 's') {
			//ler aqui os restaurantes
		} else if (r2 == 'n') {
			System.out.println("aa");
		}
		// TODO: armazenar lista de restaurantes
		
//nome, matricula, rg, sexo, dataDeIngresso, salario, nomeChef, restaurantesTrab;
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
