package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {
	IO io = new IOConsole();
	FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);

	@Test
	void testCostruisciComandoAiuto() {
		Comando comando = fabbrica.costruisciComando("aiuto");
		assertEquals(comando.getNome(), "aiuto");
	}

	@Test
	void testCostruisciComandoVai() {
		Comando comando = fabbrica.costruisciComando("vai nord");
		assertEquals(comando.getNome(), "vai");
		assertEquals(comando.getParametro(), "nord");
	}

	@Test
	void testCostruisciComandoPrendi() {
		Comando comando = fabbrica.costruisciComando("prendi osso");
		assertEquals(comando.getNome(), "prendi");
		assertEquals(comando.getParametro(), "osso");
	}

	@Test
	void testCostruisciComandoPosa() {
		Comando comando = fabbrica.costruisciComando("posa albero");
		assertEquals(comando.getNome(), "posa");
		assertEquals(comando.getParametro(), "albero");
	}

	@Test
	void testCostruisciComandoGuarda() {
		Comando comando = fabbrica.costruisciComando("guarda");
		assertEquals(comando.getNome(), "guarda");
	}

	@Test
	void testCostruisciComandoFine() {
		Comando comando = fabbrica.costruisciComando("fine");
		assertEquals(comando.getNome(), "fine");
	}

}
