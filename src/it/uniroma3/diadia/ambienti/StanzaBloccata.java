package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String nomePassepartout;

	public StanzaBloccata(String nome, String direzioneBloccata, String nomePassepartout) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomePassepartout = nomePassepartout;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(direzioneBloccata.equals(dir) && this.hasAttrezzo(nomePassepartout))
			return super.getStanzaAdiacente(dir);
		return this;
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		descrizione.append("la direzione bloccata è ");
		descrizione.append(direzioneBloccata);
		
		descrizione.append("\nl'oggetto per sbloccarla è chiamato ");
		descrizione.append(nomePassepartout);
		
		descrizione.append("\n"+super.getDescrizione());
		return descrizione.toString();
	}

}
