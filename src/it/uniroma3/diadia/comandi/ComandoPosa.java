package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{
	private String attrezzo;
	private final static String NOME="posa";

	@Override
	public void esegui(Partita partita) {
		if(attrezzo== null) {
			this.getIo().mostraMessaggio("scrivere nel formato posa + 'nome dell attrezzo da prendere'");

		}else if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo posato = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);

			if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(posato);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				this.getIo().mostraMessaggio("Attrezzo posato");
			}else {
				this.getIo().mostraMessaggio("Non c'e' spazio nella stanza per questo attrezzo");
			}
		}
	}
	
	@Override
	public String getNome(){
		return NOME;
	}

}
