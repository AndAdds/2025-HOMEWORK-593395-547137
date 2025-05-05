package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;

	private int cfu;
	private Borsa borsa;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("cfu rimasti: " + this.cfu);
		risultato.append("\n"+this.borsa.toString());
		return risultato.toString();
	}
	

}
