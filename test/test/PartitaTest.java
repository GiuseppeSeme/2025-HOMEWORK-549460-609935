package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class PartitaTest {
	
	private Partita partita;
	@BeforeEach
	void setUp() throws Exception {
		this.partita=new Partita();
	}
	
	@Test
	void testNuovaPartitaNONFINITA_E_POI_FINITA() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	@Test
	void testPartitaVINTA() {
	    this.partita.labirinto.setStanzaCorrente(this.partita.labirinto.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	void testPartitaPERSA() {
		this.partita.giocatore.setCfu(0);
		assertFalse(this.partita.vinta());
	}

}
