package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	static final public String[] ELENCO_COMANDI= {"vai","aiuto","fine","prendi","posa","guarda"};
	private IO io;
	private final static String NOME="aiuto";
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		io.mostraMessaggio("");
	}
	
	@Override
	public String getNome(){
		return NOME;
	}
	
}
