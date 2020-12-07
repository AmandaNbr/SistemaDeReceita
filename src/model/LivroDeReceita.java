package model;
import java.util.ArrayList;

/**
 * Modelo de livro de receita, recebe dados da controller e cadastra na Empresa (banco de dados)
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class LivroDeReceita {

	private String titulo;
	private String isbn;
	private ArrayList<String> codigosReceitas;
	private String matriculaEditor;
	
	public LivroDeReceita() {}

	public LivroDeReceita(String titulo, String isbn, ArrayList<String> codigosReceitas, String matriculaEditor) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.codigosReceitas = codigosReceitas;
		this.matriculaEditor = matriculaEditor;
	}

	@Override
	public String toString() {
		return titulo + " - " + isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getMatriculaEditor() {
		return matriculaEditor;
	}

	public void setMatriculaEditor(String matriculaEditor) {
		this.matriculaEditor = matriculaEditor;
	}

	public ArrayList<String> getCodigosReceitas() {
		return codigosReceitas;
	}

	public void setCodigosReceitas(ArrayList<String> codigosReceitas) {
		this.codigosReceitas = codigosReceitas;
	}
	
	/**
	 * Chama um metodo da Empresa que retorna uma arraylist do objeto livro de receita
	 * @return arraylist de livros de receita
	 */
	public ArrayList<LivroDeReceita> getAllLivrosDeReceita() {
		return Empresa.getLivrosDeReceita();
	}
	
	/**
	 * Chama um metodo da Empresa para cadastrar livro de receita
	 * @param objeto livro de receita
	 */
	public void cadastraLivroDeReceita(LivroDeReceita livroDeReceita) {
		Empresa.addNovoLivroDeReceita(livroDeReceita);
	}
}
