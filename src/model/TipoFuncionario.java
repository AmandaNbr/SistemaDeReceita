package model;

public enum TipoFuncionario {
	COZINHEIRO("cozinheiro"),
	EDITOR("editor"),
	DEGUSTADOR("degustador");
	
	private String tipo;
	
	TipoFuncionario(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
