package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	Stanza stanzino;
	Attrezzo passepartout;
	Stanza cucina;
	
	@BeforeEach
	void setUp() throws Exception {
		stanzino = new StanzaBloccata("stanzino", "sud", "pergamena");
		passepartout= new Attrezzo("pergamena", 1); 
		cucina = new Stanza("cucina");
		stanzino.impostaStanzaAdiacente("sud", cucina);
		
	}

	@Test
	void testGetStanzaAdiacenteSenzaPassepartout() {
		assertSame(stanzino, stanzino.getStanzaAdiacente("sud"));
	}
	
	@Test
	void testGetStanzaAdiacenteConPassepartout() {
		stanzino.addAttrezzo(passepartout);
		assertSame(cucina, stanzino.getStanzaAdiacente("sud"));
	}


}
