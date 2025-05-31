package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static String MESSAGGIO_CANE = "Bau bau, ti ho tolto un CFU!";
	private static String CIBO_PREFERITO= "osso";
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg=MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");
		
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("Collare", 2));
		}else {
			risposta.append(attrezzo.getNome()+ ",ma non è il mio cibo preferito! ");
			this.agisci(partita);//TODO forse causa di problemi
		}
		return risposta.toString();
	}
}
