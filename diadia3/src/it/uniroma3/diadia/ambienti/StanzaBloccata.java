package it.uniroma3.diadia.ambienti;

/**
 * Estensione classe Stanza che, nel caso in cui nella stanza
 * non ci sia un determinato attrezzo,
 * ha una direzione inaccessibile.
 * Normale altrimenti.
 * @author Fox
 *
 */
public class StanzaBloccata extends Stanza{

	private String nsePassa;
	private String passPartout;


	public StanzaBloccata(String nome) {
		super(nome);
		nsePassa=null;
		passPartout=null;


	}



	public StanzaBloccata setPass(String passPartout) {
		this.passPartout=passPartout;
		return this;
	}

	public StanzaBloccata setBlocco(String blocco) {
		this.nsePassa=blocco;
		return this;	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.contentEquals(nsePassa) && !this.hasAttrezzo(passPartout)) {
			return this;
		}
		else
			return this.getAdiacenze().get(direzione);
	}

	@Override
	public String getDescrizione() {
		
		if(this.getAttrezzi().get(passPartout)==null && this.getAdiacenze().containsKey(nsePassa))
			return "Stanza Bloccata, sarà necessario forzarla";
		else
			return this.toString();


	}

}
