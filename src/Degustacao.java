import java.lang.reflect.Array;
import java.util.Date;

public class Degustacao {

	private Receita receita;
	private Date dataDegustacao;
	private Degustador degustador;
	private Cozinheiro cozinheiro;
	private int nota;
	
	
	//construtor
	public Degustacao(Receita receita, Date dataDegustacao, Degustador degustador, Cozinheiro cozinheiro, int nota) {
		this.receita = receita;
		this.dataDegustacao = dataDegustacao;
		this.degustador = degustador;
		this.cozinheiro = cozinheiro;
		this.nota = nota;
	}
	
	
	//gets e sets
	public Receita getReceita() {
		return receita;
	}
	
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	public Date getDataDegustacao() {
		return dataDegustacao;
	}
	
	public void setDataDegustacao(Date dataDegustacao) {
		this.dataDegustacao = dataDegustacao;
	}
	
	public Degustador getDegustador() {
		return degustador;
	}
	
	public void setDegustador(Degustador degustador) {
		this.degustador = degustador;
	}
	
	public Cozinheiro getCozinheiro() {
		return cozinheiro;
	}
	
	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}
	
	public int getNota() {
		return nota;
	}
	
	public void setNota(int nota) {
		this.nota = nota;
	}
}
