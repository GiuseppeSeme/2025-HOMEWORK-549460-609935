package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo martello;

	@BeforeEach
	void setUp() throws Exception {
		borsa= new Borsa(10);
		osso=new Attrezzo("Osso",7);
		lanterna=new Attrezzo("Lanterna",3);
		martello=new Attrezzo("Martello",10);
	}

	@Test
	void testAggiuntaAttrezzo() {
		assertTrue(borsa.addAttrezzo(lanterna));
		assertEquals(3,borsa.getPeso());
		assertEquals(lanterna,borsa.getAttrezzo("Lanterna"));
	}
	
	@Test
	void testLimitePeso(){
		borsa.addAttrezzo(martello);
		assertFalse(borsa.addAttrezzo(osso));
	}
	
	@Test
	void testhasAttrezzo(){
		borsa.addAttrezzo(martello);
		assertTrue(borsa.hasAttrezzo("Martello"));
		assertFalse(borsa.hasAttrezzo("Osso"));
	}

}
