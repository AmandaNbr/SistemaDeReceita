package model;

/**
 * Enum dos cargos de funcionario
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
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
