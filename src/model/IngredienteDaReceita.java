package model;
public class IngredienteDaReceita {
	
	private Ingrediente ingrediente;
	private double quantidadeIng;
	private String medidaIng;
	
	public IngredienteDaReceita() {};
	
	public IngredienteDaReceita(Ingrediente ingrediente, double quantidadeIng, String medidaIng) {
		this.ingrediente = ingrediente;
		this.quantidadeIng = quantidadeIng;
		this.medidaIng = medidaIng;
	}
	
	@Override
	public String toString() {
		return "IngredienteDaReceita [ingrediente=" + ingrediente + ", quantidadeIng=" + quantidadeIng + ", medidaIng="
				+ medidaIng + "]";
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public double getQuantidadeIng() {
		return quantidadeIng;
	}
	
	public void setQuantidadeIng(double quantidadeIng) {
		this.quantidadeIng = quantidadeIng;
	}
	
	public String getMedidaIng() {
		return medidaIng;
	}

	public void setMedidaIng(String medidaIng) {
		this.medidaIng = medidaIng;
	}
	
}
