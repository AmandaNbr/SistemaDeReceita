import java.util.Date;

public class Receita {

	private String nome;
	private int codigo;
	private Date dataDeCriacao;
	private int porcoesQueRende;
	private String categoria;
	
	private Ingrediente ingredientes;
	private double quantidadeIng;
	private String medida;
	
	private String cozinheiro;
	
	private int nota;

	
	//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public int getPorcoesQueRende() {
		return porcoesQueRende;
	}

	public void setPorcoesQueRende(int porcoesQueRende) {
		this.porcoesQueRende = porcoesQueRende;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Ingrediente getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingrediente ingredientes) {
		this.ingredientes = ingredientes;
	}

	public double getQuantidadeIng() {
		return quantidadeIng;
	}

	public void setQuantidadeIng(double quantidadeIng) {
		this.quantidadeIng = quantidadeIng;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getCozinheiro() {
		return cozinheiro;
	}

	public void setCozinheiro(String cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}
