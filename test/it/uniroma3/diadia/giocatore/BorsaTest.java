package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
    
    private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;

    @BeforeEach
    void setUp() {
        borsa = new Borsa(10);
        attrezzoLeggero = new Attrezzo("Piuma", 1);
        attrezzoPesante = new Attrezzo("Pietra", 15);
    }

    @Test
    void testAddAttrezzoSuccess() {
        assertTrue(borsa.addAttrezzo(attrezzoLeggero));
        assertTrue(borsa.hasAttrezzo("Piuma"));
    }

    @Test
    void testAddAttrezzoSuperaPesoMax() {
        assertFalse(borsa.addAttrezzo(attrezzoPesante));
    }

    @Test
    void testRemoveAttrezzo() {
        assertTrue(borsa.addAttrezzo(attrezzoLeggero));
        assertTrue(borsa.removeAttrezzo("Piuma"));
        assertFalse(borsa.hasAttrezzo("Piuma"));
    }

    @Test
    void testIsEmpty() {
        assertTrue(borsa.isEmpty());
        borsa.addAttrezzo(attrezzoLeggero);
        assertFalse(borsa.isEmpty());
    }
}
