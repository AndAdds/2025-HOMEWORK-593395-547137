package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	private LabirintoBuilder labirinto;
	private Labirinto monolocale;
	private Labirinto bilocale;
	private Labirinto trilocale;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder();
	}
	@Test
	public void testAddStanza() {
		labirinto.addStanza("salone");
		assertEquals("salone" ,this.labirinto.getStanza("salone").getNome());
	}
	@Test
	public void testAddStanzaIniziale() {
		labirinto.addStanzaIniziale("qg");
		assertEquals("qg", this.labirinto.getStanzaCorrente().getNome());
		}
	
	@Test 
	public void testAddStanzaVincente() {
		labirinto.addStanzaVincente("salone");
		assertEquals("salone", this.labirinto.getStanzaVincente().getNome());
	}
	@Test
	public void testAddAttrezzoAllUltimaStanzaAggiunta() {
		this.labirinto.addStanza("atrio");
		this.labirinto.addStanza("salone");
		this.labirinto.addStanza("cucina");
		this.labirinto.addAttrezzo("spada", 5);
		
		
		//Se lo aggiungo alle prime 2 stanze va bene, dopo mi da problemi
		assertEquals(false, this.labirinto.getStanza("atrio").hasAttrezzo("spada"));
		assertEquals(false, this.labirinto.getStanza("salone").hasAttrezzo("spada"));
	    assertEquals(true, this.labirinto.getStanza("cucina").hasAttrezzo("spada"));

	}
	
	@Test
	public void testAddAdiacenza() {
		this.labirinto.addStanzaIniziale("cucina");
		this.labirinto.addStanza("bagno");
		this.labirinto.addAdiacenza("cucina", "bagno", "sud");
		this.labirinto.addAdiacenza("cucina", "bagno", "sud");
		this.labirinto.addAdiacenza("bagno", "cucina", "nord");
		assertEquals("bagno", this.labirinto.getStanzaIniziale().getStanzaAdiacente("sud").getNome());


	}
	@Test
	public void testMonolocale() {
	 this.monolocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto") 
				.addStanzaVincente("salotto") 
				.getLabirinto();
		assertSame("salotto",this.monolocale.getStanzaVincente().getNome());
		assertSame("salotto",this.monolocale.getStanzaIniziale().getNome());
	}
	@Test
	public void testBilocale() {
		this.bilocale= new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				.getLabirinto();
		assertSame("salotto",this.bilocale.getStanzaIniziale().getNome());
		assertSame("camera",this.bilocale.getStanzaVincente().getNome());
		assertTrue(this.bilocale.getStanzaCorrente().hasAttrezzo("letto"));
		assertSame("camera",this.bilocale.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
		assertSame("salotto",this.bilocale.getStanzaVincente().getStanzaAdiacente("sud").getNome());
	}
	@Test
	public void testTrilocale() {
		this.trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così creato
		assertSame("salotto",this.trilocale.getStanzaIniziale().getNome());
		assertSame("camera",this.trilocale.getStanzaVincente().getNome());
		assertTrue(this.trilocale.getStanzaCorrente().hasAttrezzo("pentola"));
		assertSame("cucina",this.trilocale.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
		assertSame("camera",this.trilocale.getUltimaStanzaAggiunta().getStanzaAdiacente("est").getNome());
	}
}
