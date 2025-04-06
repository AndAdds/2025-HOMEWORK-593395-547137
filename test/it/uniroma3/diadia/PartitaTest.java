package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
    
    private Partita partita;
    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto(); // Assumendo un costruttore predefinito
        partita = new Partita();
    }

    @Test
    void testPartitaNonFinitaAllInizio() {
        assertFalse(partita.isFinita());
    }

    @Test
    void testSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());
    }

    @Test
    void testPartitaVinta() {
        partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(partita.vinta());
    }
    
    @Test
    void testPartitaFinisceQuandoGiocatoreHaZeroCFU() {
        Giocatore giocatore = new Giocatore();
        giocatore.setCfu(0);
        partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita());
    }
}
