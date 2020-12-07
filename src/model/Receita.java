package model;
import java.time.LocalDate;
import java.util.ArrayList;

import utils.StringUtils;

/**
 * Modelo de receita, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class Receita {

	private String nome;
	private String codigo;
	private LocalDate dataDeCriacao;
	private int porcoesQueRende;
	private ReceitaCategorias categoria;
	private ArrayList<IngredienteDaReceita> ingredientesDaReceita;
	private String matriculaCozinheiro;
	private String modoDePreparo;
	
	public Receita() {};

	public Receita(String nome, String codigo, LocalDate dataDeCriacao, int porcoesQueRende, ReceitaCategorias categoria,
			ArrayList<IngredienteDaReceita> ingredientesDaReceita, String matriculaCozinheiro, String modoDePreparo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.dataDeCriacao = dataDeCriacao;
		this.porcoesQueRende = porcoesQueRende;
		this.categoria = categoria;
		this.ingredientesDaReceita = ingredientesDaReceita;
		this.matriculaCozinheiro = matriculaCozinheiro;
		this.modoDePreparo = modoDePreparo;
	}

	@Override
	public String toString() {
		return nome + " - " + codigo;
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

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public int getPorcoesQueRende() {
		return porcoesQueRende;
	}

	public void setPorcoesQueRende(int porcoesQueRende) {
		this.porcoesQueRende = porcoesQueRende;
	}

	public ReceitaCategorias getCategoria() {
		return categoria;
	}

	public void setCategoria(ReceitaCategorias categoria) {
		this.categoria = categoria;
	}

	public String getMatriculaCozinheiro() {
		return matriculaCozinheiro;
	}

	public void setMatriculaCozinheiro(String matriculaCozinheiro) {
		this.matriculaCozinheiro = matriculaCozinheiro;
	}

	public ArrayList<IngredienteDaReceita> getIngredientesDaReceita() {
		return ingredientesDaReceita;
	}

	public void setIngredientesDaReceita(ArrayList<IngredienteDaReceita> ingredientesDaReceita) {
		this.ingredientesDaReceita = ingredientesDaReceita;
	}
	
	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto receita
	 * @return arraylist de receitas
	 */
	public ArrayList<Receita> getAllReceitas(){
		return Empresa.getReceitas();
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar receita
	 * @param objeto receita
	 */
	public void cadastraReceita(Receita receita) {
		Empresa.addReceita(receita);
	}

	/**
	 * Pega uma determinada receita pelo codigo
	 * @param string do codigo da receita
	 * @return 
	 */
	public Receita getReceitaPorCodigo(String codigoReceita) {
		for (Receita receitaAtual : getAllReceitas()) {
			if(StringUtils.comparaStrings(receitaAtual.getCodigo(), codigoReceita)) {
				return receitaAtual;
			}
		}
		
		return null;
	}
}
