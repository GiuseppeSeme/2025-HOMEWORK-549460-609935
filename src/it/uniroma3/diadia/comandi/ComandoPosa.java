package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private IO io;
	private String attrezzo;
	private final static String NOME="aiuto";

	@Override
	public void esegui(Partita partita) {
		if(attrezzo== null) {
			io.mostraMessaggio("scrivere nel formato posa + 'nome dell attrezzo da prendere'");

		}else if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo posato = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);

			if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(posato);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				io.mostraMessaggio("Attrezzo posato");
			}else {
				io.mostraMessaggio("Non c'e' spazio nella stanza per questo attrezzo");
			}
		}
	}

	@Override
	public void setParametro(String parametro){
		this.attrezzo=parametro;
	}

	@Override
	public String getParametro(){
		return this.attrezzo;
	}
	@Override
	public void setIo(IO io){
		this.io=io;
	}
	@Override
	public String getNome(){
		return NOME;
	}

}
