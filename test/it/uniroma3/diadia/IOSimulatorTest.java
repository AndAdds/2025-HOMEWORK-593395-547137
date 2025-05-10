package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	
	private String [] comandiDaLeggere;
	IOSimulator io;
	DiaDia partita;
	
	@BeforeEach
	void setUp() throws Exception {
		String [] arrayComandi = {"prendi osso", "vai sud", "vai nord", "vai nord"};
		this.comandiDaLeggere = arrayComandi;
		this.io = new IOSimulator(comandiDaLeggere);
		partita = new DiaDia(this.io);
		partita.gioca();
		
	}

	@Test
	void test() {
		assertEquals(""
				+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
				+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
				+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
				+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
				+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
				+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
				+ "Per conoscere le istruzioni usa il comando 'aiuto'.", io.prossimoMessaggio());
		
		assertEquals("Aula N10", io.prossimoMessaggio());
		
		assertEquals("Atrio", io.prossimoMessaggio());
		
		assertEquals("Biblioteca", io.prossimoMessaggio());
		
		assertEquals("Hai vinto!", io.prossimoMessaggio());
	}

}
