package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;



class PartitaTest {
	
	Labirinto labirinto;
	Partita p;
	Stanza s;

	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}
	@Test
	void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	void testPartitaFinita() {
		assertFalse(p.isFinita());
	}

}
