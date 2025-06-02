package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

class ComandoAiutoTest {
	List<String> Lettura;
	

	@BeforeEach
	void setUp() throws Exception {
		Lettura = new ArrayList<>();
	}

	@Test
	void testComandoAiuto() throws Exception{
		Lettura.add("aiuto");
		Lettura.add("fine");
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
