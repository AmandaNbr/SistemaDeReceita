package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ingrediente {

	private String nome;
	private String descricao;
	private LocalDate dataDeFabricacao;
	private LocalDate dataDeValidade;
	
	public Ingrediente() {}
	
	public Ingrediente(String nome, String descricao, LocalDate dataDeFabricacao, LocalDate dataDeValidade) {
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
	
	public LocalDate getDataDeFabricacao() {
		return dataDeFabricacao;
	}
	
	public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}
	
	public void setDataDeValidade(LocalDate dataDeValidade) {
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
