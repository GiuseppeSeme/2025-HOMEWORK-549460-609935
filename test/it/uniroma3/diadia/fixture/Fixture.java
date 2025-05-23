package it.uniroma3.diadia.fixture;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {
	public static IOSimulator creaSimulazionePartita(String... comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
}
