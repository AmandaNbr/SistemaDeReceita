package view;

import model.Empresa;

public class Main {

	public static void main(String[] args) {
		Empresa.popularDadosParaTestar();
		MenuInicial menuInicial = new MenuInicial();
		menuInicial.startApplication();
	}
}
