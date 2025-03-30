package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaWin;

	@BeforeEach
	void setUp() throws Exception {
		this.labirinto= new Labirinto();
		this.stanzaWin= new Stanza("biblioteca");
	}

	@Test
	void testStanzaSetGetCorrente() {
		this.labirinto.setStanzaCorrente(stanzaWin);
		assertTrue(this.labirinto.getStanzaCorrente()==stanzaWin);
	}

}
