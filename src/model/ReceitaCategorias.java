package model;

public enum ReceitaCategorias {
	SOPAS("Sopas"),
	MASSAS("Massas"),
	SALADAS("Saladas"),
	CARNES("Carnes"),
	AVES("Aves"),
	PEIXES("Peixes"),
	FRUTOS_DO_MAR("Frutos do mar"),
	SOBREMESAS("Sobremesa");
	
	private String categoria;

	private ReceitaCategorias(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
}
