package esame;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Prenotazione {
	
	private Cliente[] clienti;
	private Date arrivo;
	private Date partenza;
	private DateFormat dateformat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
	
	//Prenotazione-CheckIn un cliente
	public Prenotazione(Cliente c, Date arrivo, Date partenza) {
		this.clienti = new Cliente[1];
		this.clienti[0]=c;
		
		this.arrivo=arrivo;
		this.partenza=partenza;
	}
	
	//Prenotazione-CheckIn due clienti
	public Prenotazione(Cliente[] c, Date arrivo, Date partenza) {
		this.clienti = c;
		this.arrivo = arrivo;
		this.partenza = partenza;
	}
	
	//Check-Out, ritorna il prezzo da pagare
	public Integer checkOut(Stanza stanza) {
		long differenza = this.partenza.getTime()-this.arrivo.getTime();
		long giorni = differenza/1000/60/60/24;
		System.out.println("\nGiorni di pernottamento: " + giorni);
		int costo = (int) giorni * stanza.getPrezzoGiornaliero();
		
		return costo;
	}

	
	//Setter e Getter
	public Cliente[] getClienti() {
		return clienti;
	}

	public void setClienti(Cliente[] clienti) {
		this.clienti = clienti;
	}

	public Date getArrivo() {
		return arrivo;
	}

	public void setArrivo(Date arrivo) {
		this.arrivo = arrivo;
	}

	public Date getPartenza() {
		return partenza;
	}

	public void setPartenza(Date partenza) {
		this.partenza = partenza;
	}

	@Override
	public String toString() {
		return "[arrivo: " + this.dateformat.format(arrivo) + ", partenza:" + this.dateformat.format(partenza) + "]";
	}
	
	
	
	
	
	
	
 
}
