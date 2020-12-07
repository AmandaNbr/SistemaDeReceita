package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo de degustador, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class Degustador extends Funcionario{
	 
	public Degustador() {}
	
	public Degustador(String nome, String matricula, String rg, char sexo, LocalDate dataDeIngresso, double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}
	
	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto funcionario do tipo degustador
	 * @return arraylist de degustadores
	 */
	public ArrayList<Funcionario> getAllDegustadores() {
		return Empresa.getFuncionariosPorCargo(Degustador.class);
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar degustador
	 * @param objeto degustador
	 */
	public void cadastrarDegustador(Degustador degustador) {
		Empresa.addNovoFuncionario(degustador);		
	}

	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}
}
