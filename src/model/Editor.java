package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo de editor, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class Editor extends Funcionario {
		
	public Editor() {}
	
	public Editor(String nome, 
			      String matricula, 
			      String rg, 
			      char sexo, 
			      LocalDate dataDeIngresso, 
			      double salario) {
		super(nome, matricula, rg, sexo, dataDeIngresso, salario);
	}
	
	@Override
	public String toString() {
		return getNome() + " - " + getMatricula();
	}

	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto funcionario do tipo editor
	 * @return arraylist de editores
	 */
	public ArrayList<Funcionario> getAllEditores() {
		return Empresa.getFuncionariosPorCargo(Editor.class);
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar editor
	 * @param objeto editor
	 */
	public void cadastrarEditor(Editor editor) {
		Empresa.addNovoFuncionario(editor);
	}
}
