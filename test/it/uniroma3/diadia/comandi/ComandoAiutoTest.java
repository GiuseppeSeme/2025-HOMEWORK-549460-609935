package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.comandi.ComandoAiuto;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.fixture.Fixture;

class ComandoAiutoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testComandoAiuto() {
		String[] Lettura= {"aiuto","fine"};
		IOSimulator io=Fixture.creaSimulazionePartita(Lettura);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO,io.nextMessaggio());
		for(int i=0;i<ComandoAiuto.ELENCO_COMANDI.length;i++) {
			assertTrue(io.hasNextMessaggio());
			assertEquals(ComandoAiuto.ELENCO_COMANDI[i]+" ",io.nextMessaggio());
		}
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.MESSAGGIO_FINE,io.nextMessaggio());
	}

}
