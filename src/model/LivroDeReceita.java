package model;
import java.util.ArrayList;
import java.util.Date;

import utils.StringUtils;

@SuppressWarnings("unused")
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
	
	public Editor getEditorPorMatricula(String matriculaEditor) {
		Editor editor = new Editor();
		
		for (Funcionario editorAtual : editor.getAllEditores()) {
			if(StringUtils.comparaStrings(editorAtual.getMatricula(), matriculaEditor)) {
				return (Editor) editorAtual;
			}
		}
		
		return null;
	}
	
	public ArrayList<LivroDeReceita> getAllLivrosDeReceita() {
		return Empresa.getLivrosDeReceita();
	}
	
	public void cadastraLivroDeReceita(LivroDeReceita livroDeReceita) {
		Empresa.addNovoLivroDeReceita(livroDeReceita);
	}
}
