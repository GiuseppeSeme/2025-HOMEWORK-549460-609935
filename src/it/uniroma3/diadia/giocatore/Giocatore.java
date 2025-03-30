package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 5;
	private int cfu;
	public Borsa borsa;
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa= new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
}
