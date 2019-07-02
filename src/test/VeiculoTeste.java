package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.*;

import org.junit.jupiter.api.Test;

class VeiculoTeste {

	private Locadora locadora;

	@BeforeEach
	void inicializarLocadora() {
		this.locadora = new Locadora("LocalCar", "00.258.000/4444-12", "4002-8922",
				new Localizacao("Rua 135", "Jd. Curitiba", "Goiânia", "Goiás"));
	}

	@Test
	void anoInvalido() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testeAnoInvalido);
	}

	static void testeAnoInvalido() throws NumeroInvalidoException {
		Veiculo v = new Veiculo("GM", "Ninguém gosta", 0, "Ninguém liga", 35000,
				new Categoria("Ok", true, "Hidráulica", 4, false));
	}

	@Test
	void precoInvalido() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testePrecoInvalido);
	}

	static void testePrecoInvalido() throws NumeroInvalidoException {
		Veiculo v = new Veiculo("GM", "Ninguém gosta", 2001, "Ninguém liga", -2,
				new Categoria("Ok", true, "Hidráulica", 4, false));
	}

	@Test
	void cadastro() throws NumeroInvalidoException {
		Veiculo v = new Veiculo("GM", "Ninguém gosta", 2001, "Ninguém liga", 200,
				new Categoria("Ok", true, "Hidráulica", 4, false));
		assertEquals(v.getMarca(), "GM");
	}
}
