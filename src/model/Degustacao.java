package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo de degustacao, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
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
	
	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto degustacao
	 * @return arraylist de degustacao
	 */
	public ArrayList<Degustacao> getAllDegustacoes() {
		return Empresa.getDegustacoes();
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar degustacao
	 * @param objeto degustacao
	 */
	public void cadastraDegustacao(Degustacao degustacao) {
		Empresa.addDegustacao(degustacao);
	}
}
