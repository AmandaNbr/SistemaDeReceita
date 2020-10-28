import java.math.BigDecimal;
import java.util.Date;

public class Editor extends Funcionario {

	private Funcionario funcionario;
	
	//construtor
	public Editor(String nome, int matricula, int rg, String sexo, Date dataDeIngresso, BigDecimal salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}
	
	//gets e sets
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
