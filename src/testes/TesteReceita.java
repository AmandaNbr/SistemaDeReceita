package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.*;

class TesteReceita {
	ReceitaController receitaController = new ReceitaController();
	
	@Test
	void testValidarNomeVazio() {
		assertTrue(receitaController.validarNomeVazio("Amanda"));
		assertFalse(receitaController.validarNomeVazio(""));
	}

	@Test
	void testValidarCodigoVazio() {
		assertTrue(receitaController.validarCodigoVazio("123456"));
		assertFalse(receitaController.validarCodigoVazio(""));
	}

	@Test
	void testValidarModoDePreparoVazio() {
		assertTrue(receitaController.validarModoDePreparoVazio("teste"));
		assertFalse(receitaController.validarModoDePreparoVazio(""));
	}

	@Test
	void testValidarIngredienteVazio() {
		assertTrue(receitaController.validarIngredienteVazio("ovo"));
		assertFalse(receitaController.validarIngredienteVazio(""));
	}

	@Test
	void testValidarDataDeCriacao() {
		assertTrue(receitaController.validarDataDeCriacao("25/11/2020"));
		assertFalse(receitaController.validarDataDeCriacao("25/11/2030"));
	}
}
