package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
	Partita partita;
	ComandoPosa comando;
	
	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		comando = new ComandoPosa();
		Attrezzo martello = new Attrezzo("martello", 3);
		partita.getGiocatore().getBorsa().addAttrezzo(martello);
		
	}

	@Test
	void testPosaOggetto() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
		partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo("martello"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

}
