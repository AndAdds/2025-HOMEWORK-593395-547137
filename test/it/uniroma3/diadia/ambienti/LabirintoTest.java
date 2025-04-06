package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
    
    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
    }

    @Test
    void testStanzaIniziale() {
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome(), "La stanza iniziale dovrebbe essere 'Atrio'");
    }

    @Test
    void testStanzaFinale() {
        assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome(), "La stanza finale dovrebbe essere 'Biblioteca'");
    }

    @Test
    void testStanzeAdiacenti() {
        assertEquals("Biblioteca", labirinto.getStanzaIniziale().getStanzaAdiacente("nord").getNome(), "A nord dell'Atrio dovrebbe esserci la Biblioteca");
    }

    @Test
    void testAttrezziNelleStanze() {
        assertTrue(labirinto.getStanzaIniziale().hasAttrezzo("osso"), "L'Atrio dovrebbe contenere l'attrezzo 'osso'");
        assertTrue(labirinto.getStanzaIniziale().getStanzaAdiacente("sud").hasAttrezzo("lanterna"), "L'Aula N10 dovrebbe contenere l'attrezzo 'lanterna'");
    }
}
