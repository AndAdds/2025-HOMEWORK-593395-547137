package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] listaComandi;
	private int indiceComandi;
	private String[] messaggiStampati;
	private int numeroMessaggiStampati;
	private int numeroMessaggiVisti;

	public IOSimulator(String[] listaComandi) {
		this.listaComandi = listaComandi;
		this.indiceComandi = 0;
		this.messaggiStampati = new String[1000];
		this.numeroMessaggiStampati = 0;
		this.numeroMessaggiVisti = 0;
	}
	
	
	/**
	 * ritorna il numero di tutti i messaggi stampati nel corso della partita, non corrisponde necessariamente
	 * alla dimensione dell'array
	 * 
	 */
	public int getNumeroMessaggiStampati() {
		return numeroMessaggiStampati;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		messaggiStampati[numeroMessaggiStampati] = messaggio;
		numeroMessaggiStampati++;
	}

	@Override
	public String leggiRiga() {
		String comando = null;
		if (indiceComandi < listaComandi.length) {
			comando = listaComandi[indiceComandi];
			indiceComandi++;
		}
		return comando;
	}

	public String prossimoMessaggio() {
		String prossimo = this.messaggiStampati[this.numeroMessaggiVisti];
		this.numeroMessaggiVisti++;
		return prossimo;
	}

	public boolean hasNextMessaggio() {
		return this.numeroMessaggiVisti < this.numeroMessaggiStampati;
	}

}
