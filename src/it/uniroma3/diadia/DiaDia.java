package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	
	IOConsole io= new IOConsole();
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		while (!processaIstruzione(io.leggiRiga()));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) 
			return false;

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			io.mostraMessaggio("Comando sconosciuto");
		if( this.partita.isFinita()) {
			if (this.partita.vinta()) {
				io.mostraMessaggio("Hai vinto!");
			}else
				io.mostraMessaggio("Hai perso!");
			return true;
		}
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	//posa oggetto dalla borsa alla stanza
	private void posa(String attrezzo) {
		if(attrezzo== null) {
			io.mostraMessaggio("scrivere nel formato posa + 'nome dell attrezzo da prendere'");
			
		}else if(this.partita.giocatore.borsa.hasAttrezzo(attrezzo)) {
			Attrezzo posato = this.partita.giocatore.borsa.removeAttrezzo(attrezzo);
			if(this.partita.labirinto.getStanzaCorrente().addAttrezzo(posato)==true) {
				io.mostraMessaggio(this.partita.labirinto.getStanzaCorrente().toString());
			}else {
				this.partita.giocatore.borsa.addAttrezzo(posato);
				io.mostraMessaggio("Non è posibile posare l'attrezzo");
			}
		}else
			io.mostraMessaggio("Non hai questo attrezzo nella borsa");
		
	}
	
	//prendi l'oggetto dalla stanza
	private void prendi(String attrezzo) {
		if(attrezzo == null) {
			io.mostraMessaggio("scrivere nel formato prendi + 'nome dell attrezzo da prendere'");
			
		}else if (this.partita.labirinto.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo preso = this.partita.labirinto.getStanzaCorrente().getAttrezzo(attrezzo);
			this.partita.labirinto.getStanzaCorrente().removeAttrezzo(preso);
			this.partita.giocatore.borsa.addAttrezzo(preso);
			io.mostraMessaggio(this.partita.giocatore.borsa.toString());
		}
		else
			io.mostraMessaggio("Questo Attrezzo non è presente nella stanza");
		
		
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.print("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			this.partita.giocatore.setCfu(--cfu);
		}
		io.mostraMessaggio(partita.ToString());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}