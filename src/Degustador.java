import java.math.BigDecimal;
import java.util.Date;

public class Degustador {

	private int qntDegustacoes;
	private Funcionario funcionario;
	
	
	//construtor
	public Degustador(int qntDegustacoes, Funcionario funcionario) {
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
