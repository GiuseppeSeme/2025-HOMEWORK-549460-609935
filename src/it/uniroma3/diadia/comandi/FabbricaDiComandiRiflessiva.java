package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricadiComandi{
	
	private IO io;
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io=io;
	}
	
	public Comando costruisciComando(String istruzione) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando=null;
		String parametro=null;
		Comando comando=null;
		
		if(scannerDiParole.hasNext())
			nomeComando=scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro=scannerDiParole.next();
		
		StringBuilder nomeClasse=new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		//inserisco la prima lettera del comando e la rendo maiuscola
		nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
		//inserico la seconda parte del comando così com'è
		nomeClasse.append(nomeComando.substring(1));
		
		comando= (Comando)Class.forName(nomeClasse.toString()).newInstance();
		comando.setParametro(parametro);
		comando.setIo(io);
		return comando;
	}
}
