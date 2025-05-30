package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lumino;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "lumino");
		lumino = new Attrezzo("lumino", 1);
	}


	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(lumino);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto";
		assertEquals(e, stanza.getDescrizione());
	}
}
