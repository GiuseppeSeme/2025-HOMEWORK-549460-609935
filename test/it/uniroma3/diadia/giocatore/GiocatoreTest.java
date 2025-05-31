package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	private Giocatore giocatore;
	@BeforeEach
	void setUp() throws Exception {
		giocatore =new Giocatore();
	}

	@Test
	void testCfuIniziali() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	void testsetCfu() {
		giocatore.setCfu(15);
		assertEquals(15,giocatore.getCfu());
	}
	
	@Test
    void testBorsaVuotaInizialmente() {
        assertTrue(giocatore.getBorsa().isEmpty());
    }
}
