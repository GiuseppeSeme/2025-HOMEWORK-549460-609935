package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class LabirintoTest {
	Labirinto labirinto;
	Stanza biblioteca;
	Stanza DS1;
	@BeforeEach
	void setUp(){
		labirinto= Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		biblioteca=new Stanza("Biblioteca");
		DS1=new Stanza("DS1");
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
		labirinto.setStanzaCorrente(DS1);
		assertEquals(DS1,labirinto.getStanzaCorrente());
	}
	
	

}