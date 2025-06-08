package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe di test per la classe Stanza
 * 
 * Questa è stata la mia prima classe di test
 * 
 * @author Xadri
 *
 */
public class StanzaTest {

	private Stanza vuotaMaAdiacente;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Attrezzo spranga;
	private Attrezzo erFero;
	private Attrezzo frusta;
	private Attrezzo spadino;
	private Attrezzo pugnoThanos;
	private Attrezzo martelloThor;
	private Attrezzo tensore;
	private Attrezzo grimaldello;
	private Attrezzo bong;
	private Attrezzo rubberDucky;
	private Attrezzo tirapugni;
	private Stanza ciecaMaPiena;




	@Before
	public void setUp() {

		this.stanzaEst= new Stanza("Est");
		this.stanzaOvest= new Stanza("Ovest");
		this.stanzaNord= new Stanza("Nord");
		this.stanzaSud= new Stanza("Sud");
		this.vuotaMaAdiacente= new Stanza("vuota ma adiacente");
		this.vuotaMaAdiacente.impostaStanzaAdiacente("nord", stanzaNord);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("est", stanzaEst);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("sud", stanzaSud);
		this.vuotaMaAdiacente.impostaStanzaAdiacente("ovest", stanzaOvest);
		this.spranga= new Attrezzo("spranga", 10);
		this.tensore= new Attrezzo("tensore", 1);
		this.grimaldello=new Attrezzo("grimaldello", 1);
		this.bong= new Attrezzo("bong", 2);
		this.rubberDucky= new Attrezzo("rubberDucky", 1);
		this.tirapugni = new Attrezzo("tirapugni", 3);
		this.erFero= new Attrezzo("erFero", 4);
		this.frusta= new Attrezzo("frusta", 3);
		this.spadino= new Attrezzo("spadino", 1);
		this.pugnoThanos= new Attrezzo("pugno di Thanos", 20);
		this.martelloThor= new Attrezzo("martello di Thor", 18);
		this.ciecaMaPiena= new Stanza("cieca ma piena");
		this.ciecaMaPiena.addAttrezzo(spranga);
		this.ciecaMaPiena.addAttrezzo(erFero);
		this.ciecaMaPiena.addAttrezzo(frusta);
		this.ciecaMaPiena.addAttrezzo(spadino);

		
		


	}

	/**
	 * Test metodo getStanzaAdiacente
	 */
	@Test
	public void testAdiacenzeNord() {
		assertEquals("Errore adiacenza Nord",stanzaNord ,this.vuotaMaAdiacente.getStanzaAdiacente("nord"));
	}
	@Test
	public void testAdiacenzeEst() {
		assertEquals("Errore adiacenza Est",stanzaEst ,this.vuotaMaAdiacente.getStanzaAdiacente("est"));
	}
	@Test
	public void testAdiacenzeSud() {
		assertEquals("Errore adiacenza Sud",stanzaSud ,this.vuotaMaAdiacente.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAdiacenzeOvest() {
		assertEquals("Errore adiacenza Ovest",stanzaOvest ,this.vuotaMaAdiacente.getStanzaAdiacente("ovest"));
	}


	/**
	 * Test metodo impostaStanzaAdiacente
	 */


	@Test
	public void testImpostaAdiacenzaNord() {
		this.ciecaMaPiena.impostaStanzaAdiacente("nord", stanzaNord);
		assertEquals("Errore Impostazione adiacenza nord" , stanzaNord , this.ciecaMaPiena.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenzaEst() {
		this.ciecaMaPiena.impostaStanzaAdiacente("est", stanzaEst);
		assertEquals("Errore Impostazione adiacenza est" ,stanzaEst , this.ciecaMaPiena.getStanzaAdiacente("est"));
	}
	@Test
	public void testImpostaAdiacenzaSud() {
		this.ciecaMaPiena.impostaStanzaAdiacente("sud", stanzaSud);
		assertEquals("Errore Impostazione adiacenza sud" ,stanzaSud , this.ciecaMaPiena.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaAdiacenzaOvest() {
		this.ciecaMaPiena.impostaStanzaAdiacente("ovest", stanzaOvest);
		assertEquals("Errore Impostazione adiacenza ovest" ,stanzaOvest , this.ciecaMaPiena.getStanzaAdiacente("ovest"));
	}

	@Test
	public void testImpostaAdiacenzaDirezioneErrata() {
		this.ciecaMaPiena.impostaStanzaAdiacente("sdu", stanzaSud);
		assertEquals("Errore, gli sto dando una direzione nulla", stanzaSud, this.ciecaMaPiena.getStanzaAdiacente("sdu"));
	}
	@Test
	public void testImpostaAdiacenzaStanzaNulla() {
		this.ciecaMaPiena.impostaStanzaAdiacente("nord", null);
		assertEquals("Errore, gli sto dando una stanza null", null , this.ciecaMaPiena.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenzaNulla() {
		this.ciecaMaPiena.impostaStanzaAdiacente(null, null);
		assertEquals("Errore, è tutto nullo", null, this.ciecaMaPiena.getStanzaAdiacente(null));
	}

	/**
	 * Test metodo getDescrizione
	 */

	@Test
	public void testGetDescrizioneVuotaMaAdiacente() {
		assertEquals("Errore Descrizione di vuotaMaAdiacente", "vuota ma adiacente\nUscite: [nord, sud, ovest, est]\nAttrezzi nella stanza: [] ", this.vuotaMaAdiacente.getDescrizione());
	}

	



	/**
	 * Test metodo addAttrezzo
	 */

	@Test
	public void testAddAttrezzoStanzaPiena() {
		this.ciecaMaPiena.addAttrezzo(tirapugni);
		this.ciecaMaPiena.addAttrezzo(martelloThor);
		this.ciecaMaPiena.addAttrezzo(tensore);
		this.ciecaMaPiena.addAttrezzo(grimaldello);
		this.ciecaMaPiena.addAttrezzo(rubberDucky);
		this.ciecaMaPiena.addAttrezzo(bong);
		assertEquals("Errore, non avrebbe potuto aggiungerlo", false , this.ciecaMaPiena.addAttrezzo(pugnoThanos) );

	}

	@Test
	public void testAddAttrezzoStanzaVuota() {
		assertEquals("Errore, avrebbe dovuto aggiungerlo", true, this.vuotaMaAdiacente.addAttrezzo(martelloThor));

	}

	@Test
	public void testAddAttrezzoSenzaAttrezzo() {
		assertEquals("Errore, non hai aggiunto nessun attrezzo", false, this.vuotaMaAdiacente.addAttrezzo(null));
	}


	/**
	 * Test metodo hasAttrezzo
	 */

	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", true, this.ciecaMaPiena.hasAttrezzo("spadino"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", false, this.ciecaMaPiena.hasAttrezzo("joint"));
	}
	@Test
	public void testHasAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", false, this.vuotaMaAdiacente.hasAttrezzo("joint"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", false, this.ciecaMaPiena.hasAttrezzo("cravatta"));


	}

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", "spadino (1kg)", this.ciecaMaPiena.getAttrezzo("spadino").toString());
	}

	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", null, this.ciecaMaPiena.getAttrezzo("joint"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", null, this.vuotaMaAdiacente.getAttrezzo("joint"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", null , this.ciecaMaPiena.getAttrezzo("cravatta"));


	}

	/**
	 * Test metodo removeAttrezzo
	 */

	@Test
	public void testRemoveAttrezzoConAttrezzoPresente() {

		assertEquals("Errore, l'attrezzo era presente", true, this.ciecaMaPiena.removeAttrezzo("spadino"));
	}
	@Test
	public void testRemoveAttrezzoConAttrezzoNonPresente() {

		assertEquals("Errore, l'attrezzo non era presente", false , this.ciecaMaPiena.removeAttrezzo("martello di Thor"));
	}@Test
	public void testRemoveAttrezzoConAttrezzoNullo() {
		assertEquals("Errore, non gli avevi dato nulla da rimuovere", false, this.ciecaMaPiena.removeAttrezzo(null));
	}
}
