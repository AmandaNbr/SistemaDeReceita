package model;
import java.util.ArrayList;
import java.util.Date;

public class Cozinheiro extends Funcionario{

	private ArrayList<String> restaurantesTrab;	

	public Cozinheiro(String nome, 
				      String matricula, 
				      String rg, 
				      char sexo, 
				      Date dataDeIngresso, 
				      double salario,  
				      ArrayList<String> restaurantesTrab) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
		this.restaurantesTrab = restaurantesTrab;
	}
	
	@Override
	public String toString() {
		return "Cozinheiro [restaurantesTrab=" + restaurantesTrab + "]";
	}

	//gets e sets
	public ArrayList<String> getRestaurantesTrab() {
		return restaurantesTrab;
	}
	
	public void setRestaurantesTrab(ArrayList<String> restaurantesTrab) {
		this.restaurantesTrab = restaurantesTrab;
	}
}
