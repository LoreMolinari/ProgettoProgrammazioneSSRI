package esame;

public class Doppia extends Stanza{

	private static String nome = "Doppia";
	private Integer prezzoGiornaliero;
	private Cliente occupante1;
	private Cliente	occupante2;
	private Boolean disponibile;
	
	public Doppia(int numero, int piano, String tipo, Prenotazione prenotazione) {
		super(numero, piano, 2, tipo, prenotazione);
		this.setDisponibilita(true);
		
		if(tipo.equalsIgnoreCase("Delux")) {
			this.prezzoGiornaliero = 250;
		}else {
			this.prezzoGiornaliero = 175;
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
		Cliente[] occupanti = new Cliente[2];
		occupanti[0] = this.occupante1;
		occupanti[1] = this.occupante2;
		return occupanti;
	}

	//Mettodo per aggiungere gli occupanti
	public void setOccupanti(Cliente[] occupanti) {
		this.occupante1=occupanti[0];
		this.occupante2=occupanti[1];
		this.setDisponibilita(false);
	}
	
	//Metodo per rimuovere gli occupanti dalla stanza
	public void removeOccupante() {
		this.occupante1 = null;
		this.occupante2 = null;
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
			s="Doppia Numero: " + this.getNumero() + ", Piano: " + this.getPiano() + ", Letti: " + this.getNumLetti() + ", Tipologia:  " + this.getTipo() + ", prezzoGiornaliero: " + prezzoGiornaliero +  "€, disponibilità: "
					+ disponibile + "\n";
		}
		else {
			if(this.occupante1!=null && this.occupante2!=null) {
				s="Doppia Numero: " + this.getNumero() + ", Piano: " + this.getPiano() + ", Letti: " + this.getNumLetti() + ", Tipologia:  " + this.getTipo() + ", prezzoGiornaliero: " + prezzoGiornaliero +  "€, Occupanti: {"
						+ this.getOccupanti()[0].toString() + " e " + this.getOccupanti()[1].toString() + "}\n";
			}
			else {
				s="Doppia Numero: " + this.getNumero() + ", Piano: " + this.getPiano() + ", Letti: " + this.getNumLetti() + ", Tipologia:  " + this.getTipo() + ", prezzoGiornaliero: " + prezzoGiornaliero +  "€, Occupanti: {"
						+ this.getOccupanti()[0].toString() + "}\n";
			}
		}
		return s;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	

}
