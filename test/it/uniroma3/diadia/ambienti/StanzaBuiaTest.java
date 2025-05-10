package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	Stanza scantinato;
	Attrezzo torcia;
	
	@BeforeEach
	void setUp() throws Exception {
		 scantinato = new StanzaBuia("scantinato", "torcia");
		 torcia = new Attrezzo("torcia", 2);
		 
	}

	@Test
	void testGetDescrizioneSenzaAttrezzoLuminoso() {
		assertEquals("qui c'è un buio pesto",scantinato.getDescrizione());
		
	}
	
	@Test
	void testGetDescrizioneConAttrezzoLuminoso() {
		scantinato.addAttrezzo(torcia);
		assertEquals(scantinato.toString(),scantinato.getDescrizione());
		
	}

}
