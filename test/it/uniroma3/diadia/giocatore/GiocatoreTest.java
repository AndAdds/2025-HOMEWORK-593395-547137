package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
    
    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
    }

    @Test
    void testCfuIniziali() {
        assertEquals(20, giocatore.getCfu());
    }

    @Test
    void testSetCfu() {
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu());
    }
    
    @Test
    void testBorsaNonNull() {
        assertNotNull(giocatore.getBorsa());
    }
    
    @Test
    void testStampaDescrizione() {
    	System.out.println(giocatore);
    }
}
