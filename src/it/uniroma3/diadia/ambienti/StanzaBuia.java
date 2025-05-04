package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String attrezzoL;

	public StanzaBuia(String nome ,String attrezzo){
		super(nome);
		this.attrezzoL=attrezzo;
	}
	
	@Override
	public String getDescrizione(){
		String b=new String();
		b="qui c'è un buio pesto";
		if(!this.hasAttrezzo(attrezzoL))
			return b;
		return super.getDescrizione();
	}
}
