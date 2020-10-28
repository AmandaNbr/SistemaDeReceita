import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Date;

public class Cozinheiro extends Funcionario{

	private String nomeChef;
	private Array restaurantesTrab;
	private Funcionario funcionario;
	

	//construtor
	public Cozinheiro(String nome, int matricula, int rg, String sexo, Date dataDeIngresso, BigDecimal salario, 
			String nomeChef,  Array restaurantesTrab, Funcionario funcionario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.nomeChef = nomeChef;
		this.restaurantesTrab = restaurantesTrab;
		this.funcionario = funcionario;
	}

	//gets e sets
	public String getNomeChef() {
		return nomeChef;
	}
	
	public void setNomeChef(String nomeChef) {
		this.nomeChef = nomeChef;
	}
	
	public Array getRestaurantesTrab() {
		return restaurantesTrab;
	}
	
	public void setRestaurantesTrab(Array restaurantesTrab) {
		this.restaurantesTrab = restaurantesTrab;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
