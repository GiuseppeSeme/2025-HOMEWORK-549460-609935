package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando expected;

	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole(new Scanner(System.in));
		fabbrica=new FabbricaDiComandiFisarmonica(io);
	}


	@Test
	void testComandoNonValido() {
		expected=new ComandoNonValido();
		assertEquals(expected.getNome(),fabbrica.costruisciComando("dron").getNome());
	}

	@Test
	void testComandoConParametro() {
		expected=new ComandoVai();
		expected.setParametro("nord");
		Comando corrente=fabbrica.costruisciComando("vai nord");
		assertEquals(expected.getNome(),corrente.getNome());
		assertEquals(expected.getParametro(),corrente.getParametro());
	}
	
	@Test
	void testComandoSenzaParametro() {
		expected=new ComandoFine();
		assertEquals(expected.getNome(),fabbrica.costruisciComando("fine").getNome());
	}
}
