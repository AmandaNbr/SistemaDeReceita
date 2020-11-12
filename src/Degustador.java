import java.math.BigDecimal;
import java.util.Date;

public class Degustador extends Funcionario{

	private int qntDegustacoes;	
	
	//construtor
	public Degustador(String nome, 
			          String matricula, 
			          String rg, 
			          char sexo, 
			          Date dataDeIngresso, 
			          double salario, 
			          int qntDegustacoes, 
			          Funcionario funcionario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.qntDegustacoes = qntDegustacoes;
	}
	 
	
	//gets e sets
	public int getQntDegustacoes() {
		return qntDegustacoes;
	}
	
	public void setQntDegustacoes(int qntDegustacoes) {
		this.qntDegustacoes = qntDegustacoes;
	}
}
