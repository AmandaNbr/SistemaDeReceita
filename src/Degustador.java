import java.math.BigDecimal;
import java.util.Date;

public class Degustador extends Funcionario{

	private int qntDegustacoes;
	private Funcionario funcionario;
	
	
	//construtor
	public Degustador(String nome, int matricula, int rg, String sexo, Date dataDeIngresso, BigDecimal salario, 
			int qntDegustacoes, Funcionario funcionario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.qntDegustacoes = qntDegustacoes;
		this.funcionario = funcionario;
	}
	 
	
	//gets e sets
	public int getQntDegustacoes() {
		return qntDegustacoes;
	}
	
	public void setQntDegustacoes(int qntDegustacoes) {
		this.qntDegustacoes = qntDegustacoes;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
