package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Funzione di test per la classe labirinto
 * 
 * Non ci sono metodi da testare
 * 
 * @author Xadri
 *
 */
public class LabirintoTest {
	private LabirintoPredefinito labirinto;
	private Stanza atrio;
	private Stanza biblioteca;
	
	@Before
	public void setUp() {
		this.labirinto=new LabirintoPredefinito();
		atrio=this.labirinto.getStanzaCorrente();
		biblioteca=this.labirinto.getStanzaVincente();
	}

	@Test
	public void testStanzaCorrente() {
		assertEquals(atrio, this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaVincente() {
		assertEquals(biblioteca,this.labirinto.getStanzaVincente());
	}

}
