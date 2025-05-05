package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;

public class ComandoFine implements Comando{
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		System.out.println("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
		
	}

}
