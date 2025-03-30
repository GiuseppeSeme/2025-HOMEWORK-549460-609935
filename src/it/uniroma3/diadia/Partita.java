package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 5;
	private boolean finita;
	private int cfu;

	
	public Labirinto labirinto;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente().equals(this.labirinto.getStanzaVincente());//usato equals al posto di == per confrontrate 2 stringhe
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	//Cfu a stringa
	public String ToString() {
		return labirinto.getStanzaCorrente()+"\nCfu = " + this.getCfu();
	}
}
