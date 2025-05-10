package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoLuminoso;
	
	public StanzaBuia(String nome, String nomePassepartout) {
		super(nome);
		this.nomeAttrezzoLuminoso = nomePassepartout;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getDescrizione() {
		String descrizione;
		if(this.hasAttrezzo(nomeAttrezzoLuminoso))
			descrizione = super.getDescrizione();
		else
			descrizione = "qui c'è un buio pesto";
		return descrizione;
	}
}
