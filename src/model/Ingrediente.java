package model;
import java.util.Date;

public class Ingrediente {

	private String nome;
	private Date dataDeFabricacao;
	private Date dataDeValidade;
	private String descricao;
	
	public Ingrediente(String nome, Date dataDeFabricacao, Date dataDeValidade, String descricao) {
		this.nome = nome;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeValidade = dataDeValidade;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", dataDeFabricacao=" + dataDeFabricacao + ", dataDeValidade="
				+ dataDeValidade + ", descricao=" + descricao + "]";
	}
	
	//gets e sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}
	
	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	public Date getDataDeValidade() {
		return dataDeValidade;
	}
	
	public void setDataDeValidade(Date dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
