package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * classe di test della classe Borsa
 * 
 * @author Xadri
 *
 */
public class BorsaTest {

	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Attrezzo spranga;
	private Attrezzo erFero;
	private Borsa borsaMezzaPiena;

	
	@Before
	public  void setUp() {
		borsaPiena= new Borsa();
		borsaVuota= new Borsa();
		this.spranga= new Attrezzo("spranga", 10);
		this.erFero= new Attrezzo("erFero", 4);
		this.borsaPiena.addAttrezzo(spranga);
		borsaMezzaPiena=new Borsa(20);
		Attrezzo pistola= new Attrezzo("pistola",2);
		Attrezzo coltello= new Attrezzo("coltello",2);
		Attrezzo ascia= new Attrezzo("ascia",5);
		this.borsaMezzaPiena.addAttrezzo(erFero);
		this.borsaMezzaPiena.addAttrezzo(pistola);
		this.borsaMezzaPiena.addAttrezzo(coltello);
		this.borsaMezzaPiena.addAttrezzo(ascia);

		
	}
	
	

	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertEquals("Errore, non c'è la spranga", false , this.borsaVuota.removeAttrezzo("spranga"));
	}


	
	@Test
	public void testRemoveAttrezzoBorsaPiena() {
		assertEquals("Errore, l'attrezzo è presente e lo zaino è pieno", true , this.borsaPiena.removeAttrezzo("spranga"));

	}
	
	@Test
	public void testRemoveAttrezzoBorsaPienaAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo è presente e lo zaino è pieno", false , this.borsaPiena.removeAttrezzo("erFero"));

	}
	/**
	 * Test metodo addAttrezzo
	 */

	@Test
	public void testAddAttrezzoBorsaPiena() {

		assertEquals("Errore, non avrebbe potuto aggiungerlo", false , this.borsaPiena.addAttrezzo(erFero));

	}

	@Test
	public void testAddAttrezzoBorseVuota() {
		assertEquals("Errore, avrebbe dovuto aggiungerlo", true, this.borsaVuota.addAttrezzo(erFero));

	}

	@Test
	public void testAddAttrezzoSenzaAttrezzo() {
		assertEquals("Errore, non hai aggiunto nessun attrezzo", false, this.borsaVuota.addAttrezzo(null));
	}


	/**
	 * Test metodo hasAttrezzo
	 */

	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", true, this.borsaPiena.hasAttrezzo("spranga"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", false, this.borsaPiena.hasAttrezzo("joint"));
	}
	@Test
	public void testHasAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", false, this.borsaVuota.hasAttrezzo("joint"));
	}

	@Test
	public void testHasAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", false, this.borsaPiena.hasAttrezzo("cravatta"));


	}

	/**
	 * Test metodo getAttrezzo
	 */

	@Test
	public void testGetAttrezzoConAttrezzoPresente() {
		assertEquals("Errore, l'attrezzo è presente", spranga , this.borsaPiena.getAttrezzo("spranga"));
	}

	@Test
	public void testGetAttrezzoConAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente", null, this.borsaPiena.getAttrezzo("joint"));
	}
	@Test
	public void testGetAttrezzoConAttrezzoNonPresenteBis() {
		assertEquals("Errore, non ci sono proprio attrezzi qui", null, this.borsaVuota.getAttrezzo("joint"));
	}


	@Test
	public void testGetAttrezzoConAttrezzoSconosciuto() {
		assertEquals("Errore, l'attrezzo non esiste proprio", null , this.borsaPiena.getAttrezzo("cravatta"));


	}
	@Test
	public void testGetContenutoOrdinatoPerPeso() {

		assertEquals("[pistola (2kg), coltello (2kg), erFero (4kg), ascia (5kg)]", this.borsaMezzaPiena.getContenutoOrdinatoPerPeso().toString());
	}
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		
		assertEquals("[ascia (5kg), coltello (2kg), erFero (4kg), pistola (2kg)]", this.borsaMezzaPiena.getContenutoOrdinatoPerNome().toString());
	}
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		
		assertEquals("{2=[coltello (2kg), pistola (2kg)], 4=[erFero (4kg)], 5=[ascia (5kg)]}", this.borsaMezzaPiena.getContenutoRaggruppatoPerPeso().toString());
	}
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		
		assertEquals("[coltello (2kg), pistola (2kg), erFero (4kg), ascia (5kg)]", this.borsaMezzaPiena.getSortedSetOrdinatoPerPeso().toString());
	}
}
