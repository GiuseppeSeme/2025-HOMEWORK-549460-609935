package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private Direzione direzioneBloccata;
	private String attrezzoSblocca;
	
	public StanzaBloccata(String nome,Direzione direzioneBloccata,String attrezzoSblocca) {
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoSblocca=attrezzoSblocca;
	}
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSblocca)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	@Override
	public String getDescrizione(){
		String bloccata="Stanza bloccata in direzione: "+ direzioneBloccata+" Prendi il "+attrezzoSblocca+" e posalo nella stanza per sbloccarla\n";
		if(!this.hasAttrezzo(attrezzoSblocca))
			return bloccata + super.getDescrizione();
		return super.getDescrizione();
	}
}
