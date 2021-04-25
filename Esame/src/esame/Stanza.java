package esame;

public abstract class Stanza {
	private Integer numero;
	private Integer piano;
	private Integer numLetti;	//1 o 2
	private String tipo;	//Basic, Delux, Luxury
	private Prenotazione p;
	
	//Costruttore
	public Stanza(int numero, int piano, int numLetti, String tipo, Prenotazione p) {
		this.numero=numero;
		this.piano=piano;
		this.numLetti=numLetti;
		this.tipo=tipo;
		this.p=p;
	}

	//Getter e Setter
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPiano() {
		return piano;
	}

	public void setPiano(Integer piano) {
		this.piano = piano;
	}

	public Integer getNumLetti() {
		return numLetti;
	}

	public void setNumLetti(Integer numLetti) {
		this.numLetti = numLetti;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Prenotazione getP() {
		return p;
	}

	public void setP(Prenotazione p) {
		this.p = p;
	}

	public abstract void setOccupanti(Cliente[] occupanti);
	
	public abstract Cliente[] getOccupanti();
	
	public abstract Boolean isDisponibile();
	
	public abstract String getNome();
	
	public abstract void removeOccupante();
	
	public abstract Boolean getDisponibilita();
	
	public abstract Integer getPrezzoGiornaliero();
	
	@Override
	public abstract String toString();
	
}
