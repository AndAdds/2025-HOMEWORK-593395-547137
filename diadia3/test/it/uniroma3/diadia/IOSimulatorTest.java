package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.LabirintoPredefinito;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;


public class IOSimulatorTest {

	private DiaDia session;
	private IOSimulator io;

	/**
	 * Raccolta di output statici
	 */
	private static final String ERRORE_TEST = "Errore";
	private static final String OUTPUT_AIUTO="vai + <direzione>    aiuto    fine    prendi + <nomeAttrezzo>    posa + <nomeAttrezzo>    guarda";
	private static final String OUTPUT_INIZIALE=DiaDia.MESSAGGIO_BENVENUTO;
	private static final String OUTPUT_FINALE=ComandoFine.OUTPUT_FINALE;
	private static final String OUTPUT_NON_VALIDO=ComandoNonValido.OUTPUT_NON_VALIDO;
	private static final String OUTPUT_PRENDI_SENZA_SUCCESSO=ComandoPrendi.OUTPUT_PRENDI_SENZA_SUCCESSO;
	private static final String OUTPUT_POSA_SENZA_SUCCESSO=ComandoPosa.OUTPUT_POSA_SENZA_SUCCESSO;
	private static final String OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA=ComandoPrendi.OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA;
	private static final String OUTPUT_DIREZIONE_INESISTENTE=ComandoVai.OUTPUT_DIREZIONE_INESISTENTE;
	private static final String OUTPUT_VAI_SENZA_DIREZIONE=ComandoVai.OUTPUT_VAI_SENZA_DIREZIONE;
	private static final String OUTPUT_VITTORIA=DiaDia.OUTPUT_VITTORIA;
	private static final String OUTPUT_ESAURIMENTO_CFU=DiaDia.OUTPUT_ESAURIMENTO_CFU;
	private static final String OUTPUT_POSA_CON_ATTREZZO_IN_BORSA = ComandoPosa.OUTPUT_POSA_CON_ATTREZZO_IN_BORSA;

	private static final String FINE =FabbricaDiComandiFisarmonica.FINE+" ";
	private static final String VAI =FabbricaDiComandiFisarmonica.VAI+" ";
	private static final String GUARDA =FabbricaDiComandiFisarmonica.GUARDA+" ";
	private static final String AIUTO =FabbricaDiComandiFisarmonica.AIUTO+" ";
	private static final String POSA =FabbricaDiComandiFisarmonica.POSA+" ";
	private static final String PRENDI =FabbricaDiComandiFisarmonica.PRENDI+" ";
	/**
	 * Raccolta output dinamici
	 */

	private String outputStanza;
	private String outputBorsa;


	@Before

	public void setUp() {

		this.io = new IOSimulator();
		session=new DiaDia(new LabirintoPredefinito(),io);


	}
	/**
	 * 								LE STRINGHE INSERITE NELL'ARRAY DI STRINGHE "simulazione" SONO GLI EFFETTIVI COMANDI CHE IOSimulator SIMULERA',
	 * 							IL COMANDO FINE SERVE E' (tranne che per la simulazione della partita vinta) NECESSARIO PER TERMINARE LA SIMULAZIONE,
	 * 									GLI OUTPUT DELLA SIMULAZIONE VENGONO RESTITUITI IN UN UNICA STRINGA DALLA "IO" TRAMITE IL METODO:
	 * 										 ".getOutput()" (dalla quale viene escluso il messaggio iniziale automatico).
	 * 
	 * Simulazioni semplici con singolo comando.
	 */

	@Test
	public void testSimulazioneSempliceFine() {

		String[] simulazione= {FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,OUTPUT_INIZIALE+OUTPUT_FINALE, this.io.getOutput());
	}
	@Test
	public void testSimulazioneSempliceGuarda() {

		String[] simulazione= {GUARDA,FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(outputGuarda()+OUTPUT_FINALE),outputIntroSkipped());
	}

	@Test
	public void testSimulazioneSempliceNonValido() {
		String[] simulazione= {"sbagliato",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_NON_VALIDO+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSempliceAiuto() {
		String[] simulazione= {AIUTO,FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_AIUTO+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePosaConParametroEAttrezzoInBorsa() {
		Attrezzo attrezzo=new Attrezzo("chiave",1);
		this.session.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
		String[] simulazione= {POSA+"chiave",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_POSA_CON_ATTREZZO_IN_BORSA+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePosaConParametroEAttrezzoNonInBorsa() {
		String[] simulazione= {POSA+"chiave",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_POSA_SENZA_SUCCESSO+OUTPUT_FINALE), outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePosaSenzaParametro() {
		String[] simulazione= {POSA,FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePrendiConParametroEAttrezzoInBorsa() {
		Attrezzo attrezzo=new Attrezzo("chiave",1);
		this.session.getPartita().getStanzaCorrente().addAttrezzo(attrezzo);
		String[] simulazione= {PRENDI+"chiave",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePrendiConParametroEAttrezzoNonInBorsa() {
		String[] simulazione= {PRENDI+"chiave",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE), outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSemplicePrendiSenzaParametro() {
		String[] simulazione= {PRENDI,FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSempliceVaiConParametroErrato() {
		String[] simulazione= {VAI+"piano",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test
	public void testSimulazioneSempliceVaiSenzaParametro() {
		String[] simulazione= {VAI,FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_VAI_SENZA_DIREZIONE+OUTPUT_FINALE),outputIntroSkipped());
	}
	@Test 
	public void testSimulazioneSempliceVaiConParametroEsatto() {
		String[] simulazione= {VAI+"sud",FINE};
		int i=0;
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(outputSpostamento(i++)+OUTPUT_FINALE),outputIntroSkipped());

		/**
		 * 
		 * 								LE STRINGHE INSERITE NELL'ARRAY DI STRINGHE "simulazione" SONO GLI EFFETTIVI COMANDI CHE IOSimulator SIMULERA',
		 * 						IL COMANDO FINE E' (tranne che per la simulazione della partita vinta) NECESSARIO PER TERMINARE LA SIMULAZIONE,
		 * 									GLI OUTPUT DELLA SIMULAZIONE VENGONO RESTITUITI IN UN UNICA STRINGA DALLA "IO" TRAMITE IL METODO:
		 * 										 ".getOutput()" (dalla quale viene escluso il messaggio iniziale automatico).
		 * 
		 * Simulazioni con N comandi
		 */
	}@Test 
	/**
	 * se il test è valido per N spostamenti, lo sarà anche per gli N+1 
	 * 				
	 */
	public void testSimulazioneDoppioVaiConParametroEsatto() {
		String[] simulazione= {VAI+"sud",VAI+"nord",FINE};
		int i=0;
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(outputSpostamento(i++)+outputSpostamento(i++)+
				OUTPUT_FINALE),outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneAttrezzoCambiaStanza() {
		String[] simulazione= {PRENDI+"osso",VAI+"est",POSA+"osso",GUARDA, FINE};
		int i=0;
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(OUTPUT_PRENDI_CON_ATTREZZO_IN_STANZA+outputSpostamento(i++)+OUTPUT_POSA_CON_ATTREZZO_IN_BORSA+outputGuarda()+OUTPUT_FINALE),outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneVittoria() {
		String[] simulazione= {VAI+"sud",VAI+"nord",VAI+"nord"};
		int i=0;
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(outputSpostamento(i++)+outputSpostamento(i++)+outputSpostamento(i++)+OUTPUT_VITTORIA),outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneSconfittaEsaurimentoCFU() {
		String[] simulazione= {VAI+"sud",VAI+"nord",VAI+"est"};
		int i=0;
		this.session.getPartita().getGiocatore().setCfu(3);
		this.start(simulazione);
		assertEquals(ERRORE_TEST,(outputSpostamento(i++)+outputSpostamento(i++)+outputSpostamento(i++)+OUTPUT_ESAURIMENTO_CFU),outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneComandiErrati() {
		String[] simulazione= {"via sia","prova casa","auto","fane",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,OUTPUT_NON_VALIDO+OUTPUT_NON_VALIDO+OUTPUT_NON_VALIDO+
				OUTPUT_NON_VALIDO+OUTPUT_FINALE,outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneParametriErrati() {
		String[] simulazione= {VAI+"via",PRENDI+"mele",POSA+"cibo",VAI+"a casa",PRENDI+"la prima a destra",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_POSA_SENZA_SUCCESSO+
				OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+
				OUTPUT_FINALE,outputIntroSkipped());

	}
	@Test 
	public void testSimulazioneUtonto() {
		String[] simulazione= {VAI+"via",PRENDI+"mele",POSA+"cibo",VAI+"a casa",PRENDI+"la prima a destra",VAI+"via",PRENDI+"mele",POSA+"cibo",VAI+"a casa",PRENDI+"la prima a destra",FINE};
		this.start(simulazione);
		assertEquals(ERRORE_TEST,OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+
				OUTPUT_POSA_SENZA_SUCCESSO+OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+
				OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_POSA_SENZA_SUCCESSO+
				OUTPUT_DIREZIONE_INESISTENTE+OUTPUT_PRENDI_SENZA_SUCCESSO+OUTPUT_FINALE,outputIntroSkipped());

	}
	/**
	 * metodi per definire l'output "dinamico" in maniera più elegante e comprensibile
	 */
	private void start(String[] simulazione) {
		this.io.setInput(simulazione);
		session.gioca();
	}
	public String outputIntroSkipped() {
		return this.io.getOutput().substring(OUTPUT_INIZIALE.length());
	}
	public String outputSpostamento(int i) {
		return	this.session.getPartita().getPercorso(i);
	}
	private String outputGuarda() {
		outputStanza=this.session.getPartita().getStanzaCorrente().getDescrizione();
		outputBorsa=this.session.getPartita().getGiocatore().getBorsa().toString();
		return outputStanza+outputBorsa;
	}


}
