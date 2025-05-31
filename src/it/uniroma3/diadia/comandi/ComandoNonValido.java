package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{
	private IO io;
	private final static String NOME="non valido";
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido");
	}
	
	@Override
	public String getNome(){
		return NOME;
	}
	
}
