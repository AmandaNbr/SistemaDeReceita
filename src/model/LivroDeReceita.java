package model;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
public class LivroDeReceita {

	private String titulo;
	private String isbn;
	private ArrayList<String> codigosReceitas;
	
	public LivroDeReceita() {}

	public LivroDeReceita(String titulo, String isbn, ArrayList<String> codigosReceitas) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.codigosReceitas = codigosReceitas;
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

	public ArrayList<String> getCodigosReceitas() {
		return codigosReceitas;
	}

	public void setCodigosReceitas(ArrayList<String> codigosReceitas) {
		this.codigosReceitas = codigosReceitas;
	}
	
	public ArrayList<LivroDeReceita> getAllLivrosDeReceita() {
		return Empresa.getLivrosDeReceita();
	}
	
	public void cadastraLivroDeReceita(LivroDeReceita livroDeReceita) {
		Empresa.addNovoLivroDeReceita(livroDeReceita);
	}
}
