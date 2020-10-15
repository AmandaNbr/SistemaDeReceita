import java.math.BigDecimal;
import java.util.Date;

public class Funcionario {

	private String nome;
	private int matricula;
	private int rg;
	private String sexo;
	private Date dataDeIngresso;
	private BigDecimal salario;
	
	//classe abstrata não sei se está certo fazer o contrutor aqui!
	
	
	//construtor
	public Funcionario(String nome, int matricula, int rg, String sexo, Date dataDeIngresso, BigDecimal salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.rg = rg;
		this.sexo = sexo;
		this.dataDeIngresso = dataDeIngresso;
		this.salario = salario;
	}
	
	
	//gets e sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getRg() {
		return rg;
	}
	
	public void setRg(int rg) {
		this.rg = rg;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getDataDeIngresso() {
		return dataDeIngresso;
	}
	
	public void setDataDeIngresso(Date dataDeIngresso) {
		this.dataDeIngresso = dataDeIngresso;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}
