package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {
	private Labirinto labirinto;

	@BeforeEach
	void setUp() throws Exception {
		labirinto= new Labirinto();
		labirinto.creaStanze();
	}
	
	@Test
    void testStanzaInizialeAtrio() {
        assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
    }
	
	@Test
    void testStanzaVincenteBiblioteca() {
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }

	@Test
	void testCambioStanza() {
		labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertEquals("Biblioteca",labirinto.getStanzaCorrente().getNome());
	}
	
	

}