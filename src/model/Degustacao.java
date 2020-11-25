package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Degustacao {

	private String codigoReceita;
	private LocalDate dataDegustacao;
	private String matriculaDegustador;
	private int nota;
	
	public Degustacao() {}
	
	public Degustacao(String codigoReceita, LocalDate dataDegustacao, String matriculaDegustador, int nota) {
		this.codigoReceita = codigoReceita;
		this.dataDegustacao = dataDegustacao;
		this.matriculaDegustador = matriculaDegustador;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Degustacao [codigoReceita=" + codigoReceita + ", dataDegustacao=" + dataDegustacao
				+ ", matriculaDegustador=" + matriculaDegustador + ", nota=" + nota + "]";
	}

	public String getCodigoReceita() {
		return codigoReceita;
	}

	public void setCodigoReceita(String codigoReceita) {
		this.codigoReceita = codigoReceita;
	}

	public LocalDate getDataDegustacao() {
		return dataDegustacao;
	}

	public void setDataDegustacao(LocalDate dataDegustacao) {
		this.dataDegustacao = dataDegustacao;
	}

	public String getMatriculaDegustador() {
		return matriculaDegustador;
	}

	public void setMatriculaDegustador(String matriculaDegustador) {
		this.matriculaDegustador = matriculaDegustador;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}		
	
	public ArrayList<Degustacao> getAllDegustacoes() {
		return Empresa.getDegustacoes();
	}
	
	public void cadastraDegustacao(Degustacao degustacao) {
		Empresa.addDegustacao(degustacao);
	}
}
