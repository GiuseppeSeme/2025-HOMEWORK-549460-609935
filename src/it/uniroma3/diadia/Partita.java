package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;


/*
 
Questa classe modella una partita del gioco*
@author  docente di POO
@see Stanza
@version base*/

public class Partita {

    private boolean finita;

    public Giocatore giocatore;
    public Labirinto labirinto;

    public Partita(){
        this.labirinto = new Labirinto();
        this.labirinto.creaStanze();
        this.finita = false;
        this.giocatore=new Giocatore();

    }



/*
Restituisce vero se e solo se la partita e' stata vinta
@return vero se partita vinta
*/
    
public boolean vinta() {
    return this.labirinto.getStanzaCorrente().equals(this.labirinto.getStanzaVincente());//usato equals al posto di == per confrontrate 2 stringhe}
}
    /*
     
Restituisce vero se e solo se la partita e' finita
@return vero se partita finita*/
public boolean isFinita() {
    return finita || vinta() || (giocatore.getCfu() == 0);}

 
     /*
Imposta la partita come finita*/
  public void setFinita() {
      this.finita = true;
     }
  
  //Cfu a stringa
  public String ToString() {
      return labirinto.getStanzaCorrente()+"\nCfu = " + this.giocatore.getCfu();}

}