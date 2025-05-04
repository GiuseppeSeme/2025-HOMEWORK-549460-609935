package it.uniroma3.diadia;

public class IOSimulator implements IO{
	
	private String[] LetturaRiga;
	private int indice;
	private String[] messaggi;
	private int indiceMessaggi;
	private int indiceMostrati;
	
	public String[] getMessaggi() {
		return messaggi;
	}
	
	public void setMessaggi(String[] messaggi) {
		this.messaggi=messaggi;
	}
	
	public IOSimulator(String[] righeDaLeggere) {
		this.LetturaRiga=righeDaLeggere;
		this.indice=0;
		this.indiceMostrati=0;
		this.messaggi=new String[42*23];
	}
	
	@Override
	public String leggiRiga() {
		String riga=null;
		riga=this.LetturaRiga[indice];
		this.indice++;
		return riga;
	}
	
	@Override
	public void mostraMessaggio(String mess) {
		this.messaggi[indiceMessaggi]=mess;
		this.indiceMessaggi++;
	}
	
	public String nextMessaggio(){
		String next=this.messaggi[this.indiceMostrati];
		this.indiceMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMostrati<this.indiceMessaggi;
	}
	
}
