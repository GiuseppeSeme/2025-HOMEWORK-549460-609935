package it.uniroma3.didia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.IO;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando expected;

	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
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
