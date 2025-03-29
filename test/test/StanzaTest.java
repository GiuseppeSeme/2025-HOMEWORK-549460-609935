package test;
import dia.Attrezzo;
import dia.Stanza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {
	private Stanza stanza;
	private Attrezzo spada;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("null");
		this.spada = new Attrezzo("spada", 10);
	}

	@Test
	void testAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
}
	@Test
	void testHasAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
}
	
	@Test
	void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
		this.stanza.removeAttrezzo(this.spada);
		assertFalse(this.stanza.removeAttrezzo(spada));
}


}
