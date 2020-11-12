import java.util.ArrayList;

public class Empresa {

	private static ArrayList<Funcionario> funcionarios;
	private static ArrayList<LivroDeReceita> livrosDeReceita; 
	
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
}
