package esame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Hotel {
	
	private Stanza[] stanze;
	private Integer numStanze;
	
	private Cliente[] clientiRegistrati = new Cliente[100];
	private Staff[] membriStaff = new Staff[100];
	
	private String nome;
	private String indirizzo;
	private String telefono;
	private Integer stelle;
	private String email;
	
	
	public Hotel() {
		this.nome="Generic";
		this.indirizzo="Main Street 1";
		this.telefono="+1 299 900 9345";
		this.stelle=5;
		this.email="generic@generic.com";
		
		this.numStanze=3;
		stanze = new Stanza[3];
		
		this.stanze[0]=new Singola(1,0,"basic",null);
		this.stanze[1]=new Doppia(2,0,"delux",null);
		this.stanze[2]=new Suite(3,0,null);
	}

	public Hotel(int numSingole, int numDoppie, int numSuite, String nome, String indirizzo, String email, String telefono, int stelle) {
		
		this.nome=nome;
		this.indirizzo=indirizzo;
		this.email=email;
		this.stelle=stelle;
		this.telefono=telefono;
		
		
		int piano=0;	//parto dal primo piano, piano terra è presente la reception
		Boolean controllo=false;
		
		this.numStanze=numSingole+numDoppie+numSuite;
		stanze = new Stanza[numStanze];
		
		for(int x=0;x<numStanze;x++) {
			
			if(x%5==0) {		//Ogni piano contiene 5 stanze
				piano++;
			}
			
			
			if(numSingole>0) {			//Istanzio le camere singole
				while(controllo==false) {
					System.out.println("Inserire la tipologia di camera Singola(Basic,Delux): ");
					String s;
					
					try {
						s = new String();
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						s = in.readLine();
						
						if(s.equalsIgnoreCase("Delux")||s.equalsIgnoreCase("Basic")){
							stanze[x]= new Singola(x+1, piano, s, null);
							controllo=true;
							numSingole--;
						}
						else {
							System.out.println("Tipologia inserita non corretta ritenta!");
						}
					} 
					catch (IOException e) {
						System.out.println("Tipologia inserita non corretta ritenta!");
					}
					
				}
			}
			else if(numSingole==0 && numDoppie>0) {		//Istanzio le camere Doppie
				while(controllo==false) {
					System.out.println("Inserire la tipologia di camera Doppia(Basic,Delux): ");
					String s;
					
					try {
						s = new String();
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						s = in.readLine();
						
						if(s.equalsIgnoreCase("Delux")||s.equalsIgnoreCase("Basic")){
							stanze[x]= new Doppia(x+1, piano, s, null);
							controllo=true;
							numDoppie--;
						}
						else {
							System.out.println("Tipologia inserita non corretta ritenta!");
						}
						
					} 
					catch (IOException e) {
						System.out.println("Tipologia inserita non inserita ritenta!");
					}
					
				}
			}
			else {			//Istanzio le Suite
				stanze[x] = new Suite(x+1, piano, null);
				numSuite--;
			}
			
			controllo=false;
		}
	}
	
	
	
	//Setter e Getter
	public Stanza[] getStanze() {
		return stanze;
	}

	public void setStanze(Stanza[] stanze) {
		this.stanze = stanze;
	}

	public Integer getNumStanze() {
		return numStanze;
	}

	public void setNumStanze(Integer numStanze) {
		this.numStanze = numStanze;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getStelle() {
		return stelle;
	}

	public void setStelle(Integer stelle) {
		this.stelle = stelle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Staff[] getMembriStaff() {
		return membriStaff;
	}
	
	
	@Override
	public String toString() {
		String s= new String("\nHotel "+ nome + " {\nnumero di stanze: " + numStanze + ", indirizzo: " + indirizzo + ", telefono: " + telefono + ", stelle: " + stelle + ", email: " + email + "\n\n");
		
		for(int x=0;x<numStanze;x++) {
			s=s+stanze[x].toString();
		}
		s=s+"}\n";
		
		return s;
	}
	
	
	//Check In
	public void checkIn(Cliente cliente1, Cliente cliente2) {
		Cliente[] c = new Cliente[2];
		c[0]=cliente1;
		c[1]=cliente2;
		
		this.checkIn(c);
	}
	
	public void checkIn(Cliente cliente) {
		Cliente[] c = new Cliente[2];
		c[0]=cliente;
		
		this.checkIn(c);
	}

	private void checkIn(Cliente[] c) {
		String s;
		Boolean controllo=false;
		Boolean annullamento=false;
		Integer controllocamere=0; //utilizzo un integer per poter stampare a video un messaggio di errrore se tutte le camere di un certo tipo non dovessero essere disponibili
		int x;
		
		while(controllo!=true) {
			if((c[0]!=null) && (c[1]!=null)) {
				System.out.println("Inserire che tipo di camera si vuole prenotare(Doppia o Suite):  // Scrivere annulla per anullare il checkIn //");
			}
			else {
				System.out.println("Inserire che tipo di camera si vuole prenotare(Singola, Doppia o Suite):  // Scrivere annulla per anullare il checkIn //");
			}
			
			try {
				s = new String();
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				s = in.readLine();
				
				if(s.equalsIgnoreCase("Singola") && c[1]==null){
					controllocamere=0;
					
					for(x=0;(x<this.numStanze) && (controllo!=true) ;x++) {
						if(stanze[x].isDisponibile()==true && stanze[x].getNome().equalsIgnoreCase("Singola")) {
							System.out.println("\nStanza numero: " + stanze[x].getNumero() + ", tipologia: " + stanze[x].getTipo() + " e' disponibile, Si vuole prenotarla?");
							
							s = in.readLine();
							
							if(s.equalsIgnoreCase("Si")) {
								System.out.println("Inserire data di arrivo (formato: mm/gg/aaaa): ");
								String arrivo=in.readLine();
								Date dataArrivo = new Date(arrivo);
								System.out.println("Inserire data di partenza (formato: mm/gg/aaaa): ");
								String partenza=in.readLine();
								Date dataPartenza = new Date(partenza);
								
								Date now = new Date(System.currentTimeMillis());
								if(dataPartenza.getTime()-dataArrivo.getTime()>0 && ((dataArrivo.getTime()-now.getTime())/1000/60/60/24)>=0) {
									stanze[x].setOccupanti(c);
									stanze[x].setP(new Prenotazione(c[0],dataArrivo,dataPartenza));
									System.out.println("Il cliente: " + stanze[x].getOccupanti()[0].getNome() + " " + stanze[x].getOccupanti()[0].getCognome() + " ha prenotato la stanza: " + stanze[x].getNumero() + ", " + stanze[x].getP().toString());
									controllo=true;
								}else {
									System.out.println("Errore nell'inserimento della data, riprovare!");
								}
								
							}
							else {
								System.out.println("Errore!");
							}
						}
						else {
							controllocamere++;
						}
					}
					
					if(controllocamere==x) {
						System.out.println("Nessuna camera Singola disponibile\n");
					}
				}else if(s.equalsIgnoreCase("Doppia")) {
					controllocamere=0;
					
					for(x=0;x<this.numStanze && controllo!=true ;x++) {
						if(stanze[x].isDisponibile()==true && stanze[x].getNome().equalsIgnoreCase("Doppia")) {
							System.out.println("Stanza numero: " + stanze[x].getNumero() + ", tipologia: " + stanze[x].getTipo() + " e' disponibile, Si vuole prenotarla?");
							
							s = in.readLine();
							
							if(s.equalsIgnoreCase("Si")) {
								System.out.println("Inserire data di arrivo (formato: mm/gg/aaaa): ");
								String arrivo=in.readLine();
								Date dataArrivo = new Date(arrivo);
								System.out.println("Inserire data di partenza (formato: mm/gg/aaaa): ");
								String partenza=in.readLine();
								Date dataPartenza = new Date(partenza);
								
								Date now = new Date(System.currentTimeMillis());
								if(dataPartenza.getTime()-dataArrivo.getTime()>0 && ((dataArrivo.getTime()-now.getTime())/1000/60/60/24)>=0) {
									stanze[x].setOccupanti(c);
									stanze[x].setP(new Prenotazione(c[0],dataArrivo,dataPartenza));
									if(c[0]!=null && c[1]!=null) {
										System.out.println("I clienti: " + stanze[x].getOccupanti()[0].getNome() + " " + stanze[x].getOccupanti()[0].getCognome() + " e " + stanze[x].getOccupanti()[1].getNome() + " " + stanze[x].getOccupanti()[1].getCognome() + "hanno prenotato la stanza: " + stanze[x].getNumero() + ", " + stanze[x].getP().toString());
									}
									else {
										System.out.println("Il cliente: " + stanze[x].getOccupanti()[0].getNome() + " " + stanze[x].getOccupanti()[0].getCognome() + " ha prenotato la stanza: " + stanze[x].getNumero() + ", " + stanze[x].getP().toString());
									}
									controllo=true;
								}else {
									System.out.println("Errore nell'inserimento della data, riprovare!");
								}
								
							}
							else {
								System.out.println("Errore!");
							}
						}
						else {
							controllocamere++;
						}
					}
					
					if(controllocamere==x) {
						System.out.println("Nessuna camera Doppia disponibile\n");
					}
					
				}else if(s.equalsIgnoreCase("Suite")) {
					controllocamere=0;

					for(x=0;x<this.numStanze && controllo!=true ;x++) {
						if(stanze[x].isDisponibile()==true && stanze[x].getNome().equalsIgnoreCase("Suite")) {
							System.out.println("Stanza numero: " + stanze[x].getNumero() + ", tipologia: " + stanze[x].getTipo() + " e' disponibile, Si vuole prenotarla?");
							
							s = in.readLine();
							
							if(s.equalsIgnoreCase("Si")) {
								stanze[x].setOccupanti(c);
								System.out.println("Inserire data di arrivo (formato: mm/gg/aaaa): ");
								String arrivo=in.readLine();
								Date dataArrivo = new Date(arrivo);
								System.out.println("Inserire data di partenza (formato: mm/gg/aaaa): ");
								String partenza=in.readLine();
								Date dataPartenza = new Date(partenza);
								
								Date now = new Date(System.currentTimeMillis());
								if(dataPartenza.getTime()-dataArrivo.getTime()>0 && ((dataArrivo.getTime()-now.getTime())/1000/60/60/24)>=0) {
									stanze[x].setP(new Prenotazione(c[0],dataArrivo,dataPartenza));
									if(c[0]!=null && c[1]!=null) {
										System.out.println("I clienti: " + stanze[x].getOccupanti()[0].getNome() + " " + stanze[x].getOccupanti()[0].getCognome() + " e " + stanze[x].getOccupanti()[1].getNome() + " " + stanze[x].getOccupanti()[1].getCognome() + "hanno prenotato la stanza: " + stanze[x].getNumero() + ", " + stanze[x].getP().toString());
									}
									else {
										System.out.println("Il cliente: " + stanze[x].getOccupanti()[0].getNome() + " " + stanze[x].getOccupanti()[0].getCognome() + " ha prenotato la stanza: " + stanze[x].getNumero() + ", " + stanze[x].getP().toString());
									}
									controllo=true;
								}else {
									System.out.println("Errore nell'inserimento della data, riprovare!");
								}
							}else {
								System.out.println("Errore!");
							}
						}
						else {
							controllocamere++;
						}
					}
					
					if(controllocamere==x) {
						System.out.println("Nessuna camera Suite disponibile\n");
					}
				}else if(s.equalsIgnoreCase("Annulla")) {
					controllo=true;
					annullamento=true;
				}
				else {
					System.out.println("Questo tipo di camera non è presente");
				}
			} 
			catch (IOException e) {
				System.out.println("Inserimento non corretto riprovare!");
			}
		}
		
		if(annullamento==true) {
			System.out.println("CheckIn annullato.");
		}else {
			System.out.println("CheckIn avvenuto con successo!\n\n");
		}
	}
	
	
	//Check Out	
	public void checkOut() {
		System.out.println("\nScegliere la stanza per il check Out: \n");
		int x=0;
		String s="";
		
		try {
			s = new String();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			s = in.readLine();
			x = Integer.parseInt(s);
		} catch (Exception e) {				//IOException e && NumberFormatException e2
			System.out.println("Inserimento non corretto riprovare!");
			this.checkOut();
		}
		
		
		if(x>=1 && x<=this.getNumStanze()) {
			this.checkOut(this.getStanze()[x-1]);	//x-1 perchè sto lavorando sull'array
		}
		else {
			System.out.println("Numero inserito non corrispondente a nessuna camera riprovare\n");
			this.checkOut();
		}
	}
	
	private void checkOut(Stanza s) {
		if(s.getDisponibilita()==false) {
			s.removeOccupante();
			System.out.println("Check Out della stanza: " + s.getNumero() + " Avvenuto con successo! Totale da pagare: " + s.getP().checkOut(s) + "€");
		}
		else{
			System.out.println("Stanza non occupata");
		}
	}

	
	//Gestisci albergo
	public void gestisciHotel() {
		System.out.println("\nScegli cosa si vuole fare: \n1 - aggiungi Cliente\n2 - checkIn\n3 - checkOut\n4 - lista Clienti\n5 - ricerca Codice fiscale\n6 - stanze Albergo\n7 - aggiungi Staff\n8 - rimuovi Staff\n9 - lista Staff\n");
		String s = new String();
		Integer x;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			s = in.readLine();
			x=Integer.parseInt(s);
					
			if(x==1) {
				this.creaCliente();
			}else if(x==2) {
				System.out.println("Scegliere la modalità di checkIn: \n1 - un cliente\n2 - due clienti");
				String mod = in.readLine();
				
				if(Integer.parseInt(mod)==1) {
					System.out.println("Cliente è già registrato? (si o no): ");
					mod=in.readLine();
					if(mod.equalsIgnoreCase("si")) {
						System.out.println("Inserire il codice fiscale: ");
						mod=in.readLine();
						Cliente c = this.cercaCliente(mod);		//controllo che sia presente veramente
						if(c==null) {
							System.out.println("Cliente non trovato, check in fallito\n");
						}else {
							this.checkIn(c);
						}
					}
					else {
						Cliente c= this.creaCliente();
						if(c!=null) {
							this.checkIn(c);
						}
					}
				}else if(Integer.parseInt(mod)==2) {
					System.out.println("Clienti già registrati? (si o no): ");
					mod=in.readLine();
					if(mod.equalsIgnoreCase("si")) {
						System.out.println("Inserire il codice fiscale del primo: ");
						mod=in.readLine();
						Cliente c1 = this.cercaCliente(mod);				//controllo che sia presente veramente
						System.out.println("Inserire il codice fiscale del secondo: ");
						mod=in.readLine();
						Cliente c2 = this.cercaCliente(mod);				//controllo che sia presente veramente
						if(c1==null || c2==null) {
							System.out.println("Cliente non trovato, check in fallito\n");
						}else {
							this.checkIn(c1,c2);
						}
					}
					else {
						Cliente c1=this.creaCliente();
						Cliente c2=this.creaCliente();
						if(c1!=null && c2!=null) {
							this.checkIn(c1,c2);
						}
					}
				}
				
			}else if(x==3) {
				this.checkOut();
			}else if(x==4){
				for(int i=0;i<100;i++) {
					if(this.clientiRegistrati[i]!=null) {
						System.out.println(this.clientiRegistrati[i].toString());
					}
				}
			}else if(x==5) {
				System.out.println("\nInserire il codice fiscale da ricercare: ");
				String cf=in.readLine();
				Cliente c = this.cercaCliente(cf);
				if(c!=null) {
					System.out.println("\n" + c.toString() + "\n");
				}else {
					System.out.println("Cliente non trovato\n");
				}
			}else if(x==6){
				System.out.println(this.toString());
			}else if(x==7){
				this.creaStaff();
			}else if(x==8){
				System.out.println("Inserire il codice fiscale:\n");
				String codf = in.readLine();
				for(int i=0;i<100;i++) {
					if(this.getMembriStaff()[i].getCodiceFiscale().equalsIgnoreCase(codf)) {
						this.getMembriStaff()[i]=null;
						System.out.println("Cancellato correttamente");
					}
				}
			}else if(x==9) {
				for(int i=0;i<100;i++) {
					if(this.membriStaff[i]!=null) {
						System.out.println(this.membriStaff[i].toString());
					}
				}
			}else{
				System.out.println("Nessuna azione corrispondente a questo numero.");
			}
			
		}catch(Exception e) {
			System.out.println("Nessuna azione selezionata, Riprova\n");
			this.gestisciHotel();   //ricorsione
		}
		
		this.gestisciHotel();
	}
	
	private Cliente cercaCliente(String codiceFiscale) {
		for(int x=0;x<100;x++) {
			if(this.clientiRegistrati[x].getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
				return this.clientiRegistrati[x];
			}
		}
		
		return null;
	}
	
	private Cliente creaCliente() {
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String nome,cognome,codiceFiscale,telefono,email,indirizzo,numCartaCredito,compleanno;
			System.out.println("\nInserire il nome: ");
			nome = in.readLine();
			System.out.println("\nInserire il cognome: ");
			cognome = in.readLine();
			System.out.println("\nInserire il codice fiscale: ");
			codiceFiscale = in.readLine();
			System.out.println("\nInserire il numero di telefono: ");
			telefono = in.readLine();
			System.out.println("\nInserire l'email: ");
			email = in.readLine();
			System.out.println("\nInserire l'indirizzo: ");
			indirizzo = in.readLine();
			System.out.println("\nInserire il numero di carta di credito: ");
			numCartaCredito = in.readLine();
			System.out.println("\nInserire data di nascita (mm/dd/aa): ");
			compleanno = in.readLine();
			
			Cliente c = new Cliente(nome, cognome, codiceFiscale, telefono, email, indirizzo, numCartaCredito,compleanno);
			
			for(int i=0;i<100;i++) {
				if(this.clientiRegistrati[i]==null) {
					this.clientiRegistrati[i]=c;
					System.out.println(c.toString() + " Salvato correttamente");
					i=100;
					return c;
				}
			}
			
			System.out.println("Inserimento fallito, lista utenti piena");
			return null;
		}catch(Exception e) {
			System.out.println("Inserimento fallito, riprovare");
			return null;
		}
		
	}
	
	private Staff creaStaff() {
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String nome,cognome,codiceFiscale,telefono,email,indirizzo,ruolo,compleanno;
			System.out.println("\nInserire il nome: ");
			nome = in.readLine();
			System.out.println("\nInserire il cognome: ");
			cognome = in.readLine();
			System.out.println("\nInserire il codice fiscale: ");
			codiceFiscale = in.readLine();
			System.out.println("\nInserire il numero di telefono: ");
			telefono = in.readLine();
			System.out.println("\nInserire l'email: ");
			email = in.readLine();
			System.out.println("\nInserire l'indirizzo: ");
			indirizzo = in.readLine();
			System.out.println("\nInserire il ruolo: ");
			ruolo = in.readLine();
			System.out.println("\nInserire data di nascita (mm/dd/aa): ");
			compleanno = in.readLine();
			
			Staff s = new Staff(nome, cognome, codiceFiscale, telefono, email, indirizzo, ruolo,compleanno);
			
			for(int i=0;i<100;i++) {
				if(this.membriStaff[i]==null) {
					this.membriStaff[i]=s;
					System.out.println(s.toString() + " Salvato correttamente");
					i=100;
					return s;
				}
			}
			
			System.out.println("Inserimento fallito, lista utenti piena");
			return null;
		}catch(Exception e) {
			System.out.println("Inserimento fallito, riprovare");
			return null;
		}
		
	}

	
}
