package it.uniroma3.diadia.ambienti; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
    
    private Stanza stanza;
    private Stanza stanzaAdiacente;
    private Attrezzo attrezzo;
    
    @Before
    public void setUp() {
        stanza = new Stanza("Biblioteca");
        stanzaAdiacente = new Stanza("Laboratorio");
        attrezzo = new Attrezzo("Libro", 1);
    }
    
    @Test
    public void testGetNome() {
        assertEquals("Biblioteca", stanza.getNome());
    }
    
    @Test
    public void testImpostaStanzaAdiacente() {
        stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
    public void testGetStanzaAdiacente_NonPresente() {
        assertNull(stanza.getStanzaAdiacente("sud"));
    }
    
    @Test
    public void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(attrezzo));
        assertTrue(stanza.hasAttrezzo("Libro"));
    }
    
    @Test
    public void testHasAttrezzo_NonPresente() {
        assertFalse(stanza.hasAttrezzo("Penna"));
    }
    
    @Test
    public void testGetAttrezzo_Presente() {
        stanza.addAttrezzo(attrezzo);
        assertEquals(attrezzo, stanza.getAttrezzo("Libro"));
    }
    
    @Test
    public void testGetAttrezzo_NonPresente() {
        assertNull(stanza.getAttrezzo("Penna"));
    }
    
    @Test
    public void testRemoveAttrezzo() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.removeAttrezzo(attrezzo));
        assertFalse(stanza.hasAttrezzo("Libro"));
    }
    
    @Test
    public void testRemoveAttrezzo_NonPresente() {
        assertFalse(stanza.removeAttrezzo(attrezzo));
    }
}
