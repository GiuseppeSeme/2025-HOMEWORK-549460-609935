package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica s1;
	private Attrezzo p;
	private Attrezzo m;
	private Attrezzo v;
	
	@BeforeEach
	void setUp() throws Exception {
		s1=new StanzaMagica("s1");
		p=new Attrezzo("pala",33);
		m=new Attrezzo("martello",42);
		v=new Attrezzo("vanga",42);
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(m));

	}


	@Test
	public void testModificaAttrezzo() {
		assertTrue(s1.addAttrezzo(p));
		assertTrue(s1.addAttrezzo(v));
		assertTrue(s1.addAttrezzo(m));
		}

}
