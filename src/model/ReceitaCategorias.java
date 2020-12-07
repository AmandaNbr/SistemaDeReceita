package model;

/**
 * Enum das categorias das receitas
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public enum ReceitaCategorias {
	SOPAS("Sopas"),
	MASSAS("Massas"),
	SALADAS("Saladas"),
	CARNES("Carnes"),
	AVES("Aves"),
	PEIXES("Peixes"),
	FRUTOS_DO_MAR("Frutos do mar"),
	SOBREMESAS("Sobremesas");
	
	private String categoria;

	private ReceitaCategorias(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return getCategoria();
	}
}
