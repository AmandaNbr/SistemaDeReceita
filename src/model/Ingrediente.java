package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo de ingrediente, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
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
	
	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto ingrediente
	 * @return arraylist de ingredientes
	 */
	public ArrayList<Ingrediente> getAllIngredientes() {
		return Empresa.getIngredientes();
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar ingrediente
	 * @param objeto ingrediente
	 */
	public void cadastraIngrediente(Ingrediente ingrediente) {
		Empresa.addIngrediente(ingrediente);
	}
}
