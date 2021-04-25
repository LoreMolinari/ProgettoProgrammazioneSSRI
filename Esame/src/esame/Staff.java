package esame;

public class Staff extends Persona{

	private String ruolo;
	
	
	
	public Staff(String nome, String cognome, String codiceFiscale, String telefono, String email, String indirizzoResidenza, String ruolo, String compleanno) {
		super(nome, cognome, codiceFiscale, telefono, email, indirizzoResidenza, compleanno);
		this.ruolo = ruolo;
	}

	//Setter e Getter
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}



	@Override
	public String toString() {
		return "[nome: " + this.getNome() + ", cognome: " + this.getCognome() + ", codice fiscale: " + this.getCodiceFiscale() + ", telefono: "
				+ this.getTelefono() + ", email: " + this.getEmail() + ", indirizzo residenza: " + this.getIndirizzoResidenza() + ", ruolo nell'albergo: " + this.getRuolo() + ", data di Nascita: " + this.getDateformat().format(this.getCompleanno()) + "]";
	}

}
