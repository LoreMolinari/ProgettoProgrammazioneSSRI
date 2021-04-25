package esame;

import java.text.DateFormat;
import java.util.*; 

public abstract class Persona {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String telefono;
	private String email;
	private String indirizzoResidenza;
	private Date compleanno;
	private DateFormat dateformat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);		//rende il formato della data leggibile in gg/mm/aa
	
	public Persona(String nome, String cognome, String codiceFiscale, String telefono, String email, String indirizzoResidenza, String dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.email = email;
		this.indirizzoResidenza = indirizzoResidenza;
		this.compleanno = new Date(dataNascita);
	}
	
	
	
	//Setter e Getter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	public Date getCompleanno() {
		return compleanno;
	}

	public void setCompleanno(Date compleanno) {
		this.compleanno = compleanno;
	}
	
	public DateFormat getDateformat() {
		return dateformat;
	}



	@Override
	public abstract String toString();
	
	
	
}
