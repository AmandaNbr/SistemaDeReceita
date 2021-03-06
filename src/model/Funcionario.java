package model;
import java.time.LocalDate;

/**
 * Classe abstrata modelo de funcionario
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public abstract class Funcionario {

	private String nome;
	private String matricula;
	private String rg;
	private char sexo;
	private LocalDate dataDeIngresso;
	private double salario; 
	
	public Funcionario(String nome, 
					   String matricula, 
					   String rg, 
					   char sexo, 
					   LocalDate dataDeIngresso, 
					   double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.rg = rg;
		this.sexo = sexo;
		this.dataDeIngresso = dataDeIngresso;
		this.salario = salario;
	}
	
	public Funcionario() {};
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;	
	}
	
	public LocalDate getDataDeIngresso() {
		return dataDeIngresso;
	}
	
	public void setDataDeIngresso(LocalDate dataDeIngresso) {
		
		this.dataDeIngresso = dataDeIngresso;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", matricula=" + matricula + ", rg=" + rg + ", sexo=" + sexo
				+ ", dataDeIngresso=" + dataDeIngresso + ", salario=" + salario + "]";
	}
}
