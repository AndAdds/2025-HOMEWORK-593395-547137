package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * 
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Giocatore giocatore;
	private boolean finita;

	public Partita() {
		this.finita = false;
		this.labirinto = new Labirinto();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.stanzaVincente = labirinto.getStanzaFinale();
		this.giocatore = new Giocatore();
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == this.stanzaVincente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
