package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	private IO io;
	private final static String NOME="guarda";
	
	@Override
	public void esegui(Partita partita){
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai ancora:"+partita.getGiocatore().getCfu()+"CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
