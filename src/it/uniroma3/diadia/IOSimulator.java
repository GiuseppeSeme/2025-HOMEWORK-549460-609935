package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO{
	
	private List<String> LetturaRiga;
	private int indice;
	private List<String>messaggi;
	private int indiceMessaggi;
	private int indiceMostrati;
	
	public List<String> getMessaggi() {
		return messaggi;
	}
	
	public void setMessaggi(List<String> messaggi) {
		this.messaggi=messaggi;
	}
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.LetturaRiga=righeDaLeggere;
		this.indice=0;
		this.indiceMostrati=0;
		this.messaggi=new ArrayList<String>();
	}
	
	@Override
	public String leggiRiga() {
		String riga=null;
		riga=this.LetturaRiga.get(indice);
		this.indice++;
		return riga;
	}
	
	@Override
	public void mostraMessaggio(String mess) {
		this.messaggi.add(this.indiceMessaggi,mess);
		this.indiceMessaggi++;
	}
	
	public String nextMessaggio(){
		String next=this.messaggi.get(indiceMostrati);
		this.indiceMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMostrati<this.indiceMessaggi;
	}
	
}
