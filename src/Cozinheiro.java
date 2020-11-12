import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Date;

public class Cozinheiro extends Funcionario{

	private String nomeChef;
	private Array restaurantesTrab;	

	//construtor
	public Cozinheiro(String nome, 
				      String matricula, 
				      String rg, 
				      char sexo, 
				      Date dataDeIngresso, 
				      double salario, 
			          String nomeChef,  
			          Array restaurantesTrab, 
			          Funcionario funcionario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.nomeChef = nomeChef;
		this.restaurantesTrab = restaurantesTrab;
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
}
