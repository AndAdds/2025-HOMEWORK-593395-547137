package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * 
 * 
 * @version versione.a
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole io) {
		String istruzione;
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do
			istruzione = io.leggiriga();
		while (!processaIstruzione(istruzione, io));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole io) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(io);
			this.partita.setFinita();
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),io);
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(io);
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(),io);
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(),io);
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.isFinita()) {
			if (this.partita.vinta()) {
				io.mostraMessaggio("Hai vinto!");
			}
			return true;
		}
		return false;
	}

	/*
	 * restituisce true se riesce a posare l'attrezzo, false altrimenti
	 */
	private boolean posa(String nomeAttrezzo, IOConsole io) {
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
 			this.partita.getStanzaCorrente().addAttrezzo(this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
 			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
 			io.mostraMessaggio("l'oggetto: "+ nomeAttrezzo + " è stato posato");
 			io.mostraMessaggio(""+this.partita.getStanzaCorrente());
 			return true;
 		}
		return false;
	}
	
	/*
		restituisce true se riesce a prendere l'attrezzo, false altrimenti
	*/	
	private boolean prendi(String nomeAttrezzo, IOConsole io) {
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
 			this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
 			this.partita.getStanzaCorrente().removeAttrezzo(this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));	
 			io.mostraMessaggio("l'oggetto: "+ nomeAttrezzo + " è stato preso");
 			io.mostraMessaggio(""+this.partita.getGiocatore().getBorsa());
 			return true;
 		}
		return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole io) {
		String stampaComandi="";
		for (int i = 0; i < elencoComandi.length; i++)
			stampaComandi += elencoComandi[i] + " ";
		io.mostraMessaggio(stampaComandi);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione, IOConsole io) {
		if (direzione == null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("cfu: " + partita.getGiocatore().getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole io) {
		io.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole io = new IOConsole();
		gioco.gioca(io);
	}
}