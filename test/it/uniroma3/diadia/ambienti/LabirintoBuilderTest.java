package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoBuilderTest {
	Labirinto.LabirintoBuilder lb;

	@BeforeEach
	void setUp() throws Exception {
		lb=new LabirintoBuilder("labirinto.txt");
	}

	@Test
	void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class,lb.getLabirinto().getClass());
	}
	
	@Test
	void testAddStanza() {
		lb.addStanza("stanzetta");
		Stanza exp=new Stanza("stanzetta");
		assertEquals(exp,lb.getNome2stanza().get("stanzetta"));
	}
	
	@Test
	void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class,lb.addAttrezzo("cacciavite",3).getClass());
	}
	
	void testAddAttrezzoConUltimaStanzaAggiunta() {
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo exp=new Attrezzo("cacciavite",3);
		assertEquals(exp,lb.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));
	}
	
	void testAddAttrezzoConStanza() {
		lb.addStanzaIniziale("stanzetta");
		lb.addAttrezzo("cacciavite", 3);
		assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
	}
}
