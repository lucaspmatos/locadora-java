package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import main.*;

import org.junit.jupiter.api.Test;

class VeiculoTeste {

	@Test
	void anoInvalido() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testeAnoInvalido);
	}

	static void testeAnoInvalido() throws NumeroInvalidoException {
		new Veiculo("GM", "Ninguém gosta", 0, "Ninguém liga", 35000,
				new Categoria("Ok", true, "Hidráulica", 4, false));
	}

	@Test
	void precoInvalido() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testePrecoInvalido);
	}

	static void testePrecoInvalido() throws NumeroInvalidoException {
		new Veiculo("GM", "Ninguém gosta", 2001, "Ninguém liga", -2,
				new Categoria("Ok", true, "Hidráulica", 4, false));
	}

	@Test
	void cadastro() throws NumeroInvalidoException {
		Veiculo v = new Veiculo("GM", "Ninguém gosta", 2001, "Ninguém liga", 200,
				new Categoria("Ok", true, "Hidráulica", 4, false));
		assertEquals(v.getMarca(), "GM");
	}
}
