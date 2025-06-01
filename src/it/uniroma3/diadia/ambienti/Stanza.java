package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String, Attrezzo> nomeAttrezzi;
	private int numeroAttrezzi;
	
	
	private Map<Direzione, Stanza> direzioniStanze;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioniStanze = new HashMap<>();
		this.nomeAttrezzi = new HashMap<>() ;
	}
	
	public List<Stanza> getStanzeAdiacenti(){
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : direzioniStanze.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.direzioniStanze = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;
		/*for(int i=0; i<this.direzioni.length; i++)  
			if (direzione.equals(this.direzioni[i])) { 
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}*/
		if(direzioniStanze.containsKey(direzione)) {
			this.direzioniStanze.put(direzione, stanza);
			aggiornato=true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioniStanze.put(direzione, stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
			if (this.direzioniStanze.containsKey(direzione))
				stanza = this.direzioniStanze.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.nomeAttrezzi.values();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.nomeAttrezzi.put(attrezzo.getNome(),attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		
		if(this.getAttrezzi()==null)
			risultato.append("\nNessun Attrezzo");
		else {
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(this.getAttrezzi().toString());
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.nomeAttrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
			if (this.nomeAttrezzi.containsKey(nomeAttrezzo))
				return attrezzoCercato = this.nomeAttrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo wanted) {
			if(wanted!=null) {
				this.nomeAttrezzi.remove(wanted.getNome(),wanted);
				return true;
			}else
		return false;
	}

	public Set<Direzione> getDirezioni(){
		return direzioniStanze.keySet();
	}
	
	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!= obj.getClass())
			return false;
		Stanza that=(Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio=personaggio;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
}