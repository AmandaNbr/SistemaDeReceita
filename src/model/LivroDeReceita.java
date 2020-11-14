package model;
import java.util.Date;

@SuppressWarnings("unused")
public class LivroDeReceita {

	private String titulo;
	private String isbn;
	
	public LivroDeReceita(String titulo, String isbn) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "LivroDeReceita [titulo=" + titulo + ", isbn=" + isbn + "]";
	}

	//gets e sets
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
}
