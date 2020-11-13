import java.util.ArrayList;
import java.util.Date;

public class Receita {

	private String nome;
	private String codigo;
	private Date dataDeCriacao;
	private int porcoesQueRende;
	private String categoria;
	
	private ArrayList<IngredienteDaReceita> ingredientesDaReceita;
	
	private String cozinheiro;
	
	private int nota;
	

	public Receita(String nome, String codigo, Date dataDeCriacao, int porcoesQueRende, String categoria,
			String cozinheiro, int nota, ArrayList<IngredienteDaReceita> ingredientesDaReceita) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.dataDeCriacao = dataDeCriacao;
		this.porcoesQueRende = porcoesQueRende;
		this.categoria = categoria;
		this.cozinheiro = cozinheiro;
		this.nota = nota;
		this.ingredientesDaReceita = ingredientesDaReceita;
	}

	public Receita() {};
	
	@Override
	public String toString() {
		return "Receita [nome=" + nome + ", codigo=" + codigo + ", dataDeCriacao=" + dataDeCriacao
				+ ", porcoesQueRende=" + porcoesQueRende + ", categoria=" + categoria + ", cozinheiro=" + cozinheiro
				+ ", nota=" + nota + ", ingredientesDaReceita=" + ingredientesDaReceita + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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

	public ArrayList<IngredienteDaReceita> getIngredientesDaReceita() {
		return ingredientesDaReceita;
	}

	public void setIngredientesDaReceita(ArrayList<IngredienteDaReceita> ingredientesDaReceita) {
		this.ingredientesDaReceita = ingredientesDaReceita;
	}
}
