package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica roomMagic;
	private Attrezzo frustino;

	private Attrezzo bacchetta;
	
	@Before
	public void setUp() {
		roomMagic= new StanzaMagica("magic", 1);
		frustino= new Attrezzo("frustino",3);

		bacchetta= new Attrezzo("bacchetta",2);
	}
	@Test
	public void testAddAttrezzoConUnAttrezzoNessunaReazione() {
		assertNull( roomMagic.getAttrezzo("bacchetta"));
		roomMagic.addAttrezzo(bacchetta);
		assertEquals("Errore, la stanza non dovrebbe impazzire", bacchetta, roomMagic.getAttrezzo("bacchetta"));
	}
	@Test
	public void testAddAttrezzoConDueAttrezziConReazione() {
		roomMagic.addAttrezzo(bacchetta);
		roomMagic.addAttrezzo(frustino);
		assertEquals("Errore, il nome  non dovrebbe essere invertito", "bacchetta (2kg)", roomMagic.getAttrezzo("bacchetta").toString());
		assertEquals("Errore, il nome non dovrebbe essere invertito", bacchetta, roomMagic.getAttrezzo("bacchetta"));
		assertEquals("Errore, l'attrezzo deve stare nella stanza col nome invertito", true, roomMagic.hasAttrezzo("onitsurf"));
		assertEquals("Errore, il nome dovrebbe essere invertito ed il peso raddoppiato", "onitsurf (6kg)", roomMagic.getAttrezzo("onitsurf").toString());
	}
	
}
