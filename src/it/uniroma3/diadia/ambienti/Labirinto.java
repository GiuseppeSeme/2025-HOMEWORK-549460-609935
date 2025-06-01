package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.personaggi.Mago;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	private Labirinto(String nomeFile)throws FileNotFoundException, FormatoFileNonValidoException{
		CaricatoreLabirinto c=new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale=c.getStanzaIniziale();
		this.stanzaVincente=c.getStanzaVincente();
	}
	/**
     * Crea tutte le stanze e le porte di collegamento
     * */
/*    public void creaStanze() {

		
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo piedediporco = new Attrezzo("piedediporco",2);

		
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaBloccata("Aula N10", "est", "piedediporco");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

       
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(piedediporco);

		// il gioco comincia nell'atrio
       	this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
   }
///
 */
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente=stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	public static class LabirintoBuilder {
		
		public static  class Pippo {
			//another useless nested class
		}
		
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> nomeStanza;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto=new Labirinto(labirinto);
			this.nomeStanza=new HashMap<>();
		}
		
		public Map<String, Stanza> getNome2stanza(){
			return nomeStanza;
		}
		
		public Labirinto getLabirinto(){
			return this.labirinto;
		}
		
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale){
			Stanza i=new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(i);
			this.UltimaStanzaAggiuntaEAggiorna(i);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String stanzaVincente){
			Stanza v=new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(v);
			this.UltimaStanzaAggiuntaEAggiorna(v);
			return this;
		}
		
		public LabirintoBuilder addStanza(String stanza){
			Stanza s=new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String attrezzo,int peso){
			Attrezzo a=new Attrezzo(attrezzo,peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String stanzaCorrente,String stanzaAdiacente, Direzione direzione){
			Stanza c=this.nomeStanza.get(stanzaCorrente);
			Stanza a=this.nomeStanza.get(stanzaAdiacente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}
		public LabirintoBuilder addStanzaMagica(String nome){
			Stanza stanza=new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome,String attrezzoLuminoso){
			Stanza stanza=new StanzaBuia(nome,attrezzoLuminoso);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome,String attrezzoSblocco,String direzioneBloccata){
			Stanza stanza=new StanzaBloccata(nome,Direzione.valueOf(direzioneBloccata),attrezzoSblocco);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta=stanza;
			this.nomeStanza.put(stanza.getNome(), stanza);
		}
		
		public LabirintoBuilder addStrega(String nome,String presentazione) {
			Strega s=new Strega(nome,presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome,String presentazione) {
			Cane c=new Cane(nome,presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome,String presentazione,Attrezzo attrezzo) {
			Mago m=new Mago(nome,presentazione,attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}
		
	}

}
