package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	
	ComandoPrendi comando;
	Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		comando = new ComandoPrendi();
		Attrezzo martello = new Attrezzo("martello", 3);
		partita.getStanzaCorrente().addAttrezzo(martello);
	}

	@Test
	void testEsegui() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}

}
