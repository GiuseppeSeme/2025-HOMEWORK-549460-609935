package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> nomeStanza;
	
	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
		this.nomeStanza=new HashMap<String,Stanza>();
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
	
	public LabirintoBuilder addStanzaBloccata(String nome,String attrezzoSblocco,Direzione direzioneBloccata){
		Stanza stanza=new StanzaBloccata(nome,direzioneBloccata,attrezzoSblocco);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}
	
	public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
		this.ultimaStanzaAggiunta=stanza;
		this.nomeStanza.put(stanza.getNome(), stanza);
	}
}
