import java.lang.reflect.Array;

public class Cozinheiro {

	private String nomeChef;
	private Array restaurantesTrab;
	private Funcionario funcionario;
	
	
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
