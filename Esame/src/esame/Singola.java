package esame;

public class Singola extends Stanza{
	
	private static String nome = "Singola";
	private Integer prezzoGiornaliero;
	private Cliente occupante;
	private Boolean disponibile;	

	public Singola(int numero, int piano, String tipo, Prenotazione prenotazione) {
		super(numero, piano, 1, tipo, prenotazione);
		this.setDisponibilita(true);
		
		if(tipo.equalsIgnoreCase("Delux")) {
			this.prezzoGiornaliero = 115;
		}else {
			this.prezzoGiornaliero = 90;
		}
	}

	//Setter e Getter
	public Integer getPrezzoGiornaliero() {
		return prezzoGiornaliero;
	}

	public void setPrezzoGiornaliero(Integer prezzoGiornaliero) {
		this.prezzoGiornaliero = prezzoGiornaliero;
	}

	public Cliente[] getOccupanti() {
		Cliente[] occupanti = new Cliente[1];
		occupanti[0] = this.occupante;
		return occupanti;
	}

	//Mettodo per aggiungere l'occupante
	public void setOccupanti(Cliente[] occupanti) {
		this.occupante = occupanti[0];		//in quanto so già che in una singola avrò solo un occupante
		this.setDisponibilita(false);
	}
	
	//Metodo per rimuovere occupante dalla stanza
	public void removeOccupante() {
		occupante = null;
		this.setDisponibilita(true);
	}
	
	//Metodo isDisponibile
	public Boolean getDisponibilita() {
		return disponibile;
	}
	
	public void setDisponibilita(boolean d) {
		this.disponibile=d;
	}
	
	//metodo che ritorna se la stanza è disponibile o meno
	public Boolean isDisponibile() {
		return this.disponibile;
	}
	
	@Override
	public String toString() {
		String s;
		if(this.isDisponibile()==true) {
			s="Singola Numero: " + this.getNumero() + ", Piano: " + this.getPiano() + ", Letti: " + this.getNumLetti() + ", Tipologia:  " + this.getTipo() + ", prezzoGiornaliero: " + prezzoGiornaliero +  "€, disponibilità: "
					+ disponibile + "\n";
		}
		else {
			s="Singola Numero: " + this.getNumero() + ", Piano: " + this.getPiano() + ", Letti: " + this.getNumLetti() + ", Tipologia:  " + this.getTipo() + ", prezzoGiornaliero: " + prezzoGiornaliero +  "€, Occupanti: "
					+ this.getOccupanti()[0].toString() + "\n";
		}
		return s;
	}

	@Override
	public String getNome() {
		return nome;
	}
	

}
