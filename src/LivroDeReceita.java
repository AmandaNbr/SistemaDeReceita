import java.util.Date;

@SuppressWarnings("unused")
public class LivroDeReceita {

	private String titulo;
	private int isbn;
	private Receita receita;
	private Editor editor;
	
	
	//construtor
	public LivroDeReceita(String titulo, int isbn, Receita receita, Editor editor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.receita = receita;
		this.editor = editor;
	}
	
	
	//gets e sets
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public Receita getReceita() {
		return receita;
	}
	
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	public Editor getEditor() {
		return editor;
	}
	
	public void setEditor(Editor editor) {
		this.editor = editor;
	}
}
