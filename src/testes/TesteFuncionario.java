package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.FuncionarioController;

class TesteFuncionario {
	FuncionarioController funcionarioController = new FuncionarioController();
	
	@Test
	void testValidarNome() {
		assertTrue(funcionarioController.validarNome("Amanda"));
		assertFalse(funcionarioController.validarNome(""));
	}

	@Test
	void testValidarMatriculaVazia() {
		assertTrue(funcionarioController.validarMatriculaVazia("1ab"));
		assertFalse(funcionarioController.validarMatriculaVazia(""));
	}
	
	@Test
	void testValidarRGValido() {
		assertTrue(funcionarioController.validarRGValido("2.432.069"));
		assertFalse(funcionarioController.validarRGValido("0.000.000"));
	}

	@Test
	void testValidarSalario() {
		assertTrue(funcionarioController.validarSalario("1046"));
		assertFalse(funcionarioController.validarSalario("1044"));
	}
}
