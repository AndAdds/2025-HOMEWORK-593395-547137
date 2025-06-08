package it.uniroma3.diadia.ambienti;
/**
 * Estensione di Stanza che restituisce un messaggio diverso
 * qualora al suo interno non ci sia un determinato attrezzo, 
 * altrimenti si comporta normalmente.
 * @author Xadri
 *
 */
public class StanzaBuia extends Stanza{
	

	private String attrezzoIlluminante;

	public StanzaBuia(String nome) {
		super(nome);
		attrezzoIlluminante=null;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoIlluminante))
			return this.toString();
		else
			return ("qui c'è buio pesto");
	}
	public StanzaBuia setAttrezzoIlluminante(String nomeAttrezzo) {
		this.attrezzoIlluminante=nomeAttrezzo;
		return this;
	}
	

}
