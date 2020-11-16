package model;
import java.util.Date;

public class Degustacao {


	private String codigoReceita;
	private Date dataDegustacao;
	private String matriculaDegustador;
	private int nota;
	
	public Degustacao() {}
	
	public Degustacao(String codigoReceita, Date dataDegustacao, String matriculaDegustador, int nota) {
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

	public Date getDataDegustacao() {
		return dataDegustacao;
	}

	public void setDataDegustacao(Date dataDegustacao) {
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
}
