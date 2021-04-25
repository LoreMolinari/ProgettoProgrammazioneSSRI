package esame;

public class Cliente extends Persona{
	
	private String numCartaCredito;

	public Cliente(String nome, String cognome, String codiceFiscale, String telefono, String email, String indirizzoResidenza, String numCartaCredito, String compleanno) {
		super(nome, cognome, codiceFiscale, telefono, email, indirizzoResidenza, compleanno);
		this.numCartaCredito = numCartaCredito;
	}
	
	
	//Setter e Getter
	public String getNumCartaCredito() {
		return numCartaCredito;
	}



	public void setNumCartaCredito(String numCartaCredito) {
		this.numCartaCredito = numCartaCredito;
	}



	@Override
	public String toString() {
		return "[nome: " + this.getNome() + ", cognome: " + this.getCognome() + ", codice fiscale: " + this.getCodiceFiscale() + ", telefono: "
		+ this.getTelefono() + ", email: " + this.getEmail() + ", indirizzo residenza: " + this.getIndirizzoResidenza() + ", numero carta di credito: " + this.getNumCartaCredito() + ", compleanno: " + this.getDateformat().format(this.getCompleanno()) + "]";
	}

}
