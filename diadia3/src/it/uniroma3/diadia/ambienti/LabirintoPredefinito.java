package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe dello studio di caso.
 * 
 * Questa � la classe che crea il labirinto definendo numero, nomi e caratteristiche delle stanze (ad esempio gli attrezzi contenuti)
 * 
 * e degli attrezzi(nome e peso)
 * 
 * @author Xadri
 *
 */
public class LabirintoPredefinito implements Labirinto {


	private Stanza stanzaVincente;
	private Stanza stanzaIngresso;
	private Stanza stanzaIniziale;
	private Stanza ultimaStanzaAggiunta;
	
	public LabirintoPredefinito() {
		init();
	}
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	@Override
	public void init() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		stanzaIniziale=atrio;
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		stanzaIngresso = atrio;  
		stanzaVincente = biblioteca;
		ultimaStanzaAggiunta= laboratorio;
	}
	/**
	 * 
	 * @return restituisce la stanza vincente
	 */
	@Override
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	@Override
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	/**
	 * 
	 * @return restituisce la stanza di ingresso
	 */
	@Override
	public Stanza getStanzaCorrente() {
			return stanzaIngresso;
		
	}
	@Override
	public Stanza getUltimaStanzaAggiunta() {
			return ultimaStanzaAggiunta;

	}
	}
