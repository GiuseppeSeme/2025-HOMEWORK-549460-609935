package it.uniroma3.diadia.comandi;

public interface FabbricadiComandi {
	public Comando costruisciComando(String istruzione) throws Exception;
}
