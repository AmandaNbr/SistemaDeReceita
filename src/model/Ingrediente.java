package model;
import java.util.ArrayList;
import java.util.Date;

public class Ingrediente {

	private String nome;
	private String descricao;
	private Date dataDeFabricacao;
	private Date dataDeValidade;
	
	public Ingrediente() {}
	
	public Ingrediente(String nome, String descricao, Date dataDeFabricacao, Date dataDeValidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeValidade = dataDeValidade;
	}

	@Override
	public String toString() {
		return nome;
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
	
	public ArrayList<Ingrediente> getAllIngredientes() {
		return Empresa.getIngredientes();
	}
	
	public void cadastraIngrediente(Ingrediente ingrediente) {
		Empresa.addIngrediente(ingrediente);
	}
}
